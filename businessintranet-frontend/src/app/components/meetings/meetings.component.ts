import { Component, OnInit } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { CalendarEventBaseModel } from 'src/app/models/calendar-models/calendar-event-base-model';
import { EmployeeModelExtended } from 'src/app/models/employee-models/employee-model-extended';
import { EnumRole } from 'src/app/models/role-models/enum-roles';
import { AuthenticationService } from 'src/app/service/authentication/authentication.service';
import { CalendarEventService } from '../calendar/service/calendar-event.service';

@Component({
  selector: 'app-meetings',
  templateUrl: './meetings.component.html',
  styleUrls: ['./meetings.component.scss']
})
export class MeetingsComponent implements OnInit {
  loggedInUser: EmployeeModelExtended;

  calendarEvents: CalendarEventBaseModel[] = [];

  constructor(private authenticationService: AuthenticationService, private calendarEventService: CalendarEventService) {
    this.startMeeting = this.startMeeting.bind(this);
  }

  async ngOnInit(): Promise<void> {
    const data$ = this.authenticationService.getLoggedInUser();
    this.loggedInUser = await lastValueFrom(data$);
    this.initData();
  }

  initData() {
    if (this.isCEO()) {
      this.calendarEventService.getAllCalendarEvents().subscribe(
        rsp => {
          this.mapResponseToCalendarEvents(rsp);
        })
    }
    else {
      this.calendarEventService.getAllCalendarEventsInvitedEmployeeById(this.loggedInUser.id).subscribe(
        rsp => {
          this.mapResponseToCalendarEvents(rsp);
        });
    };
  }

  isCEO() {
    return this.authenticationService.roles?.includes(EnumRole.ROLE_CEO.toString());
  }

  mapResponseToCalendarEvents(rsp: any) {
    let eventsArray: CalendarEventBaseModel[] = [];
    for (let i = 0; i < rsp.length; i++) {
      eventsArray.push({
        id: rsp[i].id,
        title: rsp[i].title,
        start: new Date(rsp[i].start),
        end: new Date(rsp[i].end!),
        calendarEventColorName: rsp[i].calendarEventColor.colorName,
        calendarEventColorId: rsp[i].calendarEventColor.id,
        color: {
          primary: rsp[i].calendarEventColor.primaryColor,
          secondary: rsp[i].calendarEventColor.secondaryColor,
        },
        invitedEmployees: rsp[i].invitedEmployees,
        invitedEmployeesIds: rsp[i].invitedEmployeesIds
      })
    }
    this.calendarEvents = eventsArray;
  }

  startMeeting(event: any) {
    window.location.href = `http://localhost:3030/${event.row.data.id}`;
  }

  hasPermissions() {
    return this.authenticationService.roles?.includes(EnumRole.ROLE_CEO.toString()) ||
      this.authenticationService.roles?.includes(EnumRole.ROLE_HRMANAGER.toString()) ||
      this.authenticationService.roles?.includes(EnumRole.ROLE_MANAGER.toString());
  }
}
