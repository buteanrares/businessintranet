import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CalendarEventBaseModel } from 'src/app/models/calendar-models/calendar-event-base-model';
import { EmployeeBaseModel } from 'src/app/models/employee-models/employee-base-model';
import { EmployeeModelExtended } from 'src/app/models/employee-models/employee-model-extended';

@Injectable({
  providedIn: 'root'
})
export class CalendarEventService {

  constructor(private http: HttpClient) { }

  getAllCalendarEvents(): Observable<CalendarEventBaseModel[]> {
    return this.http.get<CalendarEventBaseModel[]>('http://localhost:8080/api/calendarevent/all')
  }

  addCalendarEvent(calendarEvent: CalendarEventBaseModel): Observable<CalendarEventBaseModel> {
    return this.http.post<CalendarEventBaseModel>('http://localhost:8080/api/calendarevent/add', calendarEvent);
  }

  updateCalendarEvent(calendarEvent: CalendarEventBaseModel): Observable<CalendarEventBaseModel> {
    return this.http.post<CalendarEventBaseModel>('http://localhost:8080/api/calendarevent/update', calendarEvent);
  }

  deleteCalendarEvent(id: number) {
    return this.http.delete(`http://localhost:8080/api/calendarevent/delete/${id}`);
  }

  getAllCalendarEventsByInvitedEmployee(invitedEmployee: EmployeeModelExtended): Observable<CalendarEventBaseModel[]> {
    return this.http.post<CalendarEventBaseModel[]>('http://localhost:8080/api/calendarevent/findall/byinvitedemployee', invitedEmployee);
  }
}
