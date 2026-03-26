package edu.aptashynskyi.aws.probe.domain.trainers;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Persistable;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Trainee implements Persistable<TraineeId> {

    @EmbeddedId
    private TraineeId id;

    @Transient
    private boolean isNew = false;

    @OneToMany(mappedBy = "trainee")
    private Set<TrainerTrainee> trainers = new HashSet<>();

    public Trainee() {
    }

    public Trainee(TraineeId id) {
        this.id = id;
        this.isNew = true;
    }

    @Override
    public @NonNull TraineeId getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}
