package edu.aptashynskyi.aws.probe.domain.trainers;

import java.util.UUID;

public record TrainerTraineeView(UUID trainerId, UUID traineeId, boolean confirmed) {
    public static TrainerTraineeView from(TrainerTrainee trainerTrainee) {
        var trainerTraineeId = trainerTrainee.trainerTraineeId();
        return new TrainerTraineeView(
                trainerTraineeId.trainerId().id(), trainerTraineeId.traineeId().id(), trainerTrainee.confirmed()
        );
    }
}
