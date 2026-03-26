package edu.aptashynskyi.aws.probe.domain.trainers;

import java.util.UUID;

public interface PendingTrainingRequest {
    UUID getTrainerTraineeId_TrainerId_id();
    UUID getTrainerTraineeId_TraineeId_id();
    boolean getConfirmed();
}
