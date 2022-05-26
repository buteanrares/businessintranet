package com.BusinessIntranet.BusinessIntranet.CalendarEvent;

import com.BusinessIntranet.BusinessIntranet.CalendarEvent.Exceptions.CalendarEventNotFoundException;
import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import com.BusinessIntranet.BusinessIntranet.Employee.EmployeeRepository;
import com.BusinessIntranet.BusinessIntranet.Employee.Exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEventService {
    public final CalendarEventRepository calendarEventRepository;
    public final EmployeeRepository employeeRepository;

    @Autowired
    public CalendarEventService(CalendarEventRepository calendarEventRepository, EmployeeRepository employeeRepository) {
        this.calendarEventRepository = calendarEventRepository;
        this.employeeRepository = employeeRepository;
    }

    public CalendarEvent createCalendarEvent(CalendarEvent calendarEvent) {
        mapInvitedEmployeesIdsToInvitedEmployees(calendarEvent);
        return calendarEventRepository.save(calendarEvent);
    }

    public List<CalendarEvent> findAllCalendarEvents() {
        return calendarEventRepository.findAll();
    }

    public CalendarEvent findCalendarEventById(Long id) {
        return calendarEventRepository.findById(id)
                .orElseThrow(() -> new CalendarEventNotFoundException("Calendar event with id " + id + " does not exist"));
    }

    public List<CalendarEvent> findAllByInvitedEmployeeId(Long invitedEmployeeId) {
        return calendarEventRepository.findAllByInvitedEmployeeId(invitedEmployeeId);
    }

    public CalendarEvent updateCalendarEvent(CalendarEvent calendarEvent) {
        mapInvitedEmployeesIdsToInvitedEmployees(calendarEvent);
        return calendarEventRepository.save(calendarEvent);
    }

    public void deleteCalendarEvent(Long id) {
        calendarEventRepository.findById(id)
                .orElseThrow(() -> new CalendarEventNotFoundException("Calendar event with id " + id + " does not exist"));
        calendarEventRepository.deleteById(id);
    }

    private void mapInvitedEmployeesIdsToInvitedEmployees(CalendarEvent calendarEvent){
        // Map calendarEvent.invitedEmployeesIds to invitedEmployees
        String[] invitedEmployeesIds = calendarEvent.getInvitedEmployeesIds().split(", ");
        for (String stringId : invitedEmployeesIds) {
            Long employeeId = Long.parseLong(stringId);
            Employee referencedEmployee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + employeeId + " does not exist"));
            calendarEvent.addInvitedEmployee(referencedEmployee);
        }
    }
}
