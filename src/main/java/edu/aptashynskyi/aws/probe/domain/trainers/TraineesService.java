package edu.aptashynskyi.aws.probe.domain.trainers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TraineesService {

    private final TrainerTraineeRepository trainerTraineeRepository;
    private final TraineesRepository traineesRepository;
    private final TrainersRepository trainersRepository;

    @Autowired
    public TraineesService(TrainerTraineeRepository trainerTraineeRepository, TraineesRepository traineesRepository,
                           TrainersRepository trainersRepository) {
        this.trainerTraineeRepository = trainerTraineeRepository;
        this.traineesRepository = traineesRepository;
        this.trainersRepository = trainersRepository;
    }

    @Transactional
    public TrainerTraineeView requestTraining(TraineeId traineeId, TrainerId trainerId) {
        var trainer = this.trainersRepository.findByIdJoinFetchTrainerTrainees(trainerId).orElseThrow(NoSuchElementException::new);
        if (!trainer.hasFreePlace()) throw new IllegalStateException("Trainer has no free place");
        var trainee = this.traineesRepository.findById(traineeId).orElseGet(() -> new Trainee(traineeId));
        var trainerTrainee = new TrainerTrainee(trainer, trainee);
        this.trainerTraineeRepository.save(trainerTrainee);
        return TrainerTraineeView.from(trainerTrainee);
    }

    @Transactional
    public void confirm(TrainerId trainerId, TraineeId traineeId) {
        var trainerTrainee = this.trainerTraineeRepository.findByIdForUpdate(new TrainerTraineeId(trainerId, traineeId))
                .orElseThrow(NoSuchElementException::new);
        if (trainerTrainee.confirmed()) throw new IllegalStateException("Trainer is already approved");
        trainerTrainee.confirm();
    }

    @Transactional(readOnly = true)
    public List<PendingTrainingRequest> pendingTrainingRequests(TrainerId trainerId) {
        return this.trainerTraineeRepository.findAllByTrainerTraineeId_TrainerIdAndConfirmed(trainerId, false);
    }

}
