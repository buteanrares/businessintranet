package com.BusinessIntranet.BusinessIntranet.CalendarEvent;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/calendarevent")
public class CalendarEventController {
    private final CalendarEventService calendarEventService;

    @Autowired
    public CalendarEventController(CalendarEventService calendarEventService) {
        this.calendarEventService = calendarEventService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CalendarEvent>> getCalendarEvents() {
        List<CalendarEvent> calendarEvents = calendarEventService.findAllCalendarEvents();
        return new ResponseEntity<>(calendarEvents, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CalendarEvent> getCalendarEventById(@PathVariable("id") Long id){
        CalendarEvent calendarEvent = calendarEventService.findCalendarEventById(id);
        return new ResponseEntity<>(calendarEvent,HttpStatus.OK);
    }

    @PostMapping("/findall/byinvitedemployee")
    public ResponseEntity<List<CalendarEvent>> getCalendarEventByInvitedEmployeeId(@RequestBody Employee invitedEmployee){
        List<CalendarEvent> calendarEvents = calendarEventService.findAllByInvitedEmployee(invitedEmployee);
        return new ResponseEntity<>(calendarEvents,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CalendarEvent> createCalendarEvent(@RequestBody CalendarEvent calendarEvent){
        CalendarEvent newCalendarEvent = calendarEventService.createCalendarEvent(calendarEvent);
        return new ResponseEntity<>(newCalendarEvent,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CalendarEvent> updateCalendarEvent(@RequestBody CalendarEvent calendarEvent){
        CalendarEvent updateCalendarEvent = calendarEventService.updateCalendarEvent(calendarEvent);
        return new ResponseEntity<>(updateCalendarEvent,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCalendarEvent(@PathVariable("id") Long id){
        calendarEventService.deleteCalendarEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
