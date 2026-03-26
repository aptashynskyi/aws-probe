package edu.aptashynskyi.aws.probe.domain.trainers;

import jakarta.persistence.*;

@Entity
public class TrainerTrainee {

    @EmbeddedId
    private TrainerTraineeId trainerTraineeId;

    @MapsId("trainerId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Trainer trainer;

    @MapsId("traineeId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Trainee trainee;

    private boolean confirmed = false;

    public TrainerTrainee() {
    }

    public TrainerTrainee(Trainer trainer, Trainee trainee) {
        this.trainer = trainer;
        this.trainee = trainee;
        this.trainerTraineeId = new TrainerTraineeId(trainer.id(), trainee.id());
    }

    public TrainerTraineeId trainerTraineeId() {
        return trainerTraineeId;
    }

    public boolean confirmed() {
        return confirmed;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof TrainerTrainee that)) return false;

        return trainerTraineeId.equals(that.trainerTraineeId);
    }

    @Override
    public int hashCode() {
        return trainerTraineeId.hashCode();
    }

    public void confirm() {
        this.confirmed = true;
    }
}
