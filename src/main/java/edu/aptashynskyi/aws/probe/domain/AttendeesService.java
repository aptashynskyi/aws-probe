package edu.aptashynskyi.aws.probe.domain;

import edu.aptashynskyi.aws.probe.domain.trainers.TraineeId;
import edu.aptashynskyi.aws.probe.domain.trainers.TrainerId;
import edu.aptashynskyi.aws.probe.domain.trainers.TrainersRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class AttendeesService {

    private final AttendeesRepository attendeesRepository;
    private final TrainersRepository trainersRepository;

    @Autowired
    public AttendeesService(AttendeesRepository attendeesRepository, TrainersRepository trainersRepository) {
        this.attendeesRepository = attendeesRepository;
        this.trainersRepository = trainersRepository;
    }

    @Transactional
    public AttendeeView createAttendee(@NonNull String fistName, @NonNull String lastName) {
        var attendee = new Attendee(attendeesRepository.newId(), fistName, lastName);
        attendeesRepository.save(attendee);
        return AttendeeView.from(attendee);
    }

    @Transactional
    public void requestTraining(@NonNull AttendeeId attendeeId, @NonNull TrainerId trainerId) {

        var trainer = trainersRepository.findById(trainerId).orElseThrow(NoSuchElementException::new);

    }

}
