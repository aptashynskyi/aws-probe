package edu.aptashynskyi.aws.probe.domain.trainers;

import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Persistable;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trainers")
public class Trainer implements Persistable<TrainerId> {

    @EmbeddedId
    private TrainerId id;

    private String firstName;

    private String lastName;

    private int capacity;

    @Transient
    private boolean isNew = false;

    @OneToMany(mappedBy = "trainer")
    private Set<TrainerTrainee> trainees = new HashSet<>();

    public Trainer() {
    }

    public Trainer(TrainerId id, String firstName, String lastName, int capacity) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.capacity = capacity;
        this.isNew = true;
    }

    @Override
    public @NonNull TrainerId getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Trainer trainer)) return false;

        return id.equals(trainer.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public boolean hasFreePlace() {
        return this.capacity > this.trainees.size();
    }
}
