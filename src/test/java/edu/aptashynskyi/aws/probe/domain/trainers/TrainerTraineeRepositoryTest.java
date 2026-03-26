package edu.aptashynskyi.aws.probe.domain.trainers;

import edu.aptashynskyi.aws.probe.domain.Attendee;
import edu.aptashynskyi.aws.probe.domain.AttendeesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TrainerTraineeRepositoryTest {

    @Autowired
    private AttendeesRepository attendeesRepository;

    @Autowired
    private TraineesRepository traineesRepository;

    @Autowired
    private TrainersRepository trainersRepository;

    @Autowired
    private TrainerTraineeRepository trainerTraineeRepository;

    @Test
    void bootstrap() {
        var attendee = attendeesRepository.saveAndFlush(new Attendee(attendeesRepository.newId(), "John", "Doe"));
        var trainee = traineesRepository.saveAndFlush(new Trainee(traineesRepository.newId(attendee.getId())));
        var trainer = trainersRepository.saveAndFlush(new Trainer(trainersRepository.newId(), "Jane", "Smith", 1));
        trainerTraineeRepository.saveAndFlush(new TrainerTrainee(trainer, trainee));

        var pendingTrainingRequests = trainerTraineeRepository.findAllByTrainerTraineeId_TrainerIdAndConfirmed(trainer.getId(), false);
        assertEquals(1, pendingTrainingRequests.size());
        assertEquals(trainer.getId().id(), pendingTrainingRequests.getFirst().getTrainerTraineeId_TrainerId_id());
        assertEquals(trainee.getId().id(), pendingTrainingRequests.getFirst().getTrainerTraineeId_TraineeId_id());
    }

}