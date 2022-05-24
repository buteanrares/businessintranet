package com.BusinessIntranet.BusinessIntranet.CalendarEvent;

import com.BusinessIntranet.BusinessIntranet.CalendarEvent.Exceptions.CalendarEventNotFoundException;
import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEventService {
    public final CalendarEventRepository calendarEventRepository;

    @Autowired
    public CalendarEventService(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    public CalendarEvent createCalendarEvent(CalendarEvent calendarEvent){
        return calendarEventRepository.save(calendarEvent);
    }

    public List<CalendarEvent> findAllCalendarEvents(){
        return calendarEventRepository.findAll();
    }

    public CalendarEvent findCalendarEventById(Long id){
        return calendarEventRepository.findById(id)
                .orElseThrow(()-> new CalendarEventNotFoundException("Calendar event with id "+id+" does not exist"));
    }

    public List<CalendarEvent> findAllByInvitedEmployee(Employee invitedEmployee){
        return calendarEventRepository.findAllByInvitedEmployeesContaining(invitedEmployee);
    }

    public CalendarEvent updateCalendarEvent(CalendarEvent calendarEvent){
        return calendarEventRepository.save(calendarEvent);
    }

    public void deleteCalendarEvent(Long id){
        calendarEventRepository.findById(id)
                .orElseThrow(()-> new CalendarEventNotFoundException("Calendar event with id "+id+" does not exist"));
        calendarEventRepository.deleteById(id);
    }
}
