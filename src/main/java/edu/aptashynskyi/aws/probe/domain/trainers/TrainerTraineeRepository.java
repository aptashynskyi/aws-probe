package edu.aptashynskyi.aws.probe.domain.trainers;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainerTraineeRepository extends JpaRepository<TrainerTrainee, TrainerTraineeId> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT tt FROM TrainerTrainee tt WHERE tt.trainerTraineeId = :trainerTraineeId")
    Optional<TrainerTrainee> findByIdForUpdate(TrainerTraineeId trainerTraineeId);

    List<PendingTrainingRequest> findAllByTrainerTraineeId_TrainerIdAndConfirmed(TrainerId trainerId, boolean confirmed);
}
