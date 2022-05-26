package com.BusinessIntranet.BusinessIntranet.CalendarEvent;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
    List<CalendarEvent> findAllByInvitedEmployeesContaining(Employee invitedEmployee);

    @Query(value = "select calendar_event.* from calendar_event inner join calendar_event_invited_employees on calendar_event_invited_employees.calendar_event_id = calendar_event.id where calendar_event_invited_employees.invited_employees_id = ?1", nativeQuery = true)
    List<CalendarEvent> findAllByInvitedEmployeeId(Long invitedEmployeeId);
}
