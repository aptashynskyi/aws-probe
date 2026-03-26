package edu.aptashynskyi.aws.probe.domain.trainers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineesRepository extends JpaRepository<Trainee, TraineeId> {
}
