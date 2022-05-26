package com.BusinessIntranet.BusinessIntranet.CalendarEvent;

import com.BusinessIntranet.BusinessIntranet.Employee.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class CalendarEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private Date start;
    private Date end;
    @OneToOne
    private CalendarEventColor calendarEventColor;
    @ManyToMany
    private List<Employee> invitedEmployees = new ArrayList<>();
    private String invitedEmployeesIds; // received value from frontend, received raw instead of mapping in front; ex "1, 2, 5"

    public CalendarEvent() {
    }

    public CalendarEvent(String title, Date start, Date end, CalendarEventColor calendarEventColor, List<Employee> invitedEmployees) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.calendarEventColor=calendarEventColor;
        this.invitedEmployees = invitedEmployees;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date startDateTime) {
        this.start = startDateTime;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date endDateTime) {
        this.end = endDateTime;
    }

    public CalendarEventColor getCalendarEventColor() {
        return calendarEventColor;
    }

    public void setCalendarEventColor(CalendarEventColor calendarEventColor) {
        this.calendarEventColor = calendarEventColor;
    }

    public List<Employee> getInvitedEmployees() {
        return invitedEmployees;
    }

    public void setInvitedEmployees(List<Employee> invitedEmployees) {
        this.invitedEmployees = invitedEmployees;
    }

    public void addInvitedEmployee(Employee invitedEmployee){
        this.invitedEmployees.add(invitedEmployee);
    }

    public String getInvitedEmployeesIds() {
        return invitedEmployeesIds;
    }
}
