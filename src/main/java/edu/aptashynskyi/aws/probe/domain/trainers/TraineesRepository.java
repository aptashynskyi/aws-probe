package edu.aptashynskyi.aws.probe.domain.trainers;

import edu.aptashynskyi.aws.probe.domain.AttendeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineesRepository extends JpaRepository<Trainee, TraineeId> {
    default TraineeId newId(AttendeeId id) {
        return new TraineeId(id.id());
    }
}
