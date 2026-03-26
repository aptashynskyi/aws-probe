package edu.aptashynskyi.aws.probe.domain.trainers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TrainersRepository extends JpaRepository<Trainer, TrainerId> {
    @Query("select t from Trainer t left join fetch t.trainees")
    Optional<Trainer> findByIdJoinFetchTrainerTrainees(TrainerId attr0);

    default TrainerId newId() {
        return new TrainerId(UUID.randomUUID());
    }
}
