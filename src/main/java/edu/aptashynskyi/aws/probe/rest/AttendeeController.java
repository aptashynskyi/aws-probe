package edu.aptashynskyi.aws.probe.rest;

import edu.aptashynskyi.aws.probe.domain.AttendeeView;
import edu.aptashynskyi.aws.probe.domain.AttendeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {

    private final AttendeesService attendeesService;

    @Autowired
    public AttendeeController(AttendeesService attendeesService) {
        this.attendeesService = attendeesService;
    }

    @PostMapping
    public ResponseEntity<AttendeeView> createAttendee(@RequestBody AttendeeCreateData data) {
        return ResponseEntity.ok(attendeesService.createAttendee(data.firstName(), data.lastName()));
    }
}
