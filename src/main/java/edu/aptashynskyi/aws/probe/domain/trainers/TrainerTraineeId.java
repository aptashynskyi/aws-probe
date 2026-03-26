package edu.aptashynskyi.aws.probe.domain.trainers;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TrainerTraineeId implements Serializable {

    @Embedded
    private TrainerId trainerId;
    @Embedded
    private TraineeId traineeId;

    public TrainerTraineeId() {
    }

    public TrainerTraineeId(TrainerId trainerId, TraineeId traineeId) {
        this.trainerId = trainerId;
        this.traineeId = traineeId;
    }

    public TrainerId trainerId() {
        return trainerId;
    }

    public TraineeId traineeId() {
        return traineeId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (TrainerTraineeId) obj;
        return Objects.equals(this.trainerId, that.trainerId) &&
                Objects.equals(this.traineeId, that.traineeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, traineeId);
    }

}
