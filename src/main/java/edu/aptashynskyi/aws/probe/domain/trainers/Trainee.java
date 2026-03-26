package edu.aptashynskyi.aws.probe.domain.trainers;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Trainee {

    @EmbeddedId
    private TraineeId id;

    @OneToMany(mappedBy = "trainee")
    private Set<TrainerTrainee> trainers = new HashSet<>();

    public Trainee() {
    }

    public Trainee(TraineeId id) {
        this.id = id;
    }

    public TraineeId id() {
        return id;
    }
}
