import { Component, ChangeDetectionStrategy, ViewChild, TemplateRef, OnInit, } from '@angular/core';
import { startOfDay, endOfDay, subDays, addDays, endOfMonth, isSameDay, isSameMonth, addHours, } from 'date-fns';
import { lastValueFrom, Subject } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CalendarEvent, CalendarEventAction, CalendarEventTimesChangedEvent, CalendarView, } from 'angular-calendar';
import { AuthenticationService } from 'src/app/service/authentication/authentication.service';
import { EmployeeModelExtended } from 'src/app/models/employee-models/employee-model-extended';
import { EnumRole } from 'src/app/models/role-models/enum-roles';
import { CalendarEventService } from './service/calendar-event.service';
import { CalendarEventBaseModel } from 'src/app/models/calendar-models/calendar-event-base-model';
import { ToastrService } from 'ngx-toastr';
import { HexColors } from 'src/app/models/color-models/color-hex-codes';
import { CalendarEventColor } from 'src/app/models/calendar-models/calendar-event-color-model';

@Component({
  selector: 'app-calendar',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrls: ['./calendar.component.scss'],
  templateUrl: 'calendar.component.html',
})
export class CalendarComponent implements OnInit {
  @ViewChild('modalContent', { static: true }) modalContent: TemplateRef<any>;
  loggedInUser: EmployeeModelExtended;
  view: CalendarView = CalendarView.Month;
  CalendarView = CalendarView;
  viewDate: Date = new Date();
  availableColors = HexColors;
  calendarEventColors: CalendarEventColor[] = [
    { id: 1, colorName: 'Red', primaryColor: '#FF0000', secondaryColor: '#FFE5E5' },
    { id: 2, colorName: 'Blue', primaryColor: '#0000CC', secondaryColor: '#CCE5FF' },
    { id: 3, colorName: 'Green', primaryColor: '#009900', secondaryColor: '#E5FFCC' },
    { id: 4, colorName: 'Purple', primaryColor: '#9933FF', secondaryColor: '#E5CCFF' }
  ];

  refresh = new Subject<void>();

  calendarEvents: CalendarEventBaseModel[] = [];

  activeDayIsOpen: boolean = true;

  constructor(private modal: NgbModal, private authenticationService: AuthenticationService, private toastr: ToastrService, private calendarEventService: CalendarEventService) { }

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

  dayClicked({ date, events }: { date: Date; events: CalendarEvent[] }): void {
    if (isSameMonth(date, this.viewDate)) {
      if (
        (isSameDay(this.viewDate, date) && this.activeDayIsOpen === true) ||
        events.length === 0
      ) {
        this.activeDayIsOpen = false;
      } else {
        this.activeDayIsOpen = true;
      }
      this.viewDate = date;
    }
  }

  addCalendarEvent(event: any) {
    delete event.data.__KEY__;
    event.data.invitedEmployeesIds; // as string, wont get all users by id, ex "1, 2, 5";
    event.data.calendarEventColor = this.calendarEventColors.find(calendarEventColor => calendarEventColor.id === event.data.calendarEventColorId);
    this.calendarEventService.addCalendarEvent(event.data).subscribe({
      next: () => this.toastr.success("Event added"),
      error: err => this.toastr.error(err.message)
    })
  }

  updateCalendarEvent(event: any) {
    // delete unnecessary attributes
    this.prepareModelForBackend(event);
    this.calendarEventService.updateCalendarEvent(event.data).subscribe(
      {
        next: () => this.toastr.success("Event updated"),
        error: err => this.toastr.error(err.message)
      }
    );
  }

  deleteCalendarEvent(event: any) {
    this.calendarEventService.deleteCalendarEvent(event.data.id).subscribe(
      {
        next: () => this.toastr.success("Event deleted"),
        error: err => this.toastr.error(err.message)
      }
    )
  }

  hasPermissionToManageRows() {
    return this.authenticationService.roles?.includes(EnumRole.ROLE_CEO.toString()) ||
      this.authenticationService.roles?.includes(EnumRole.ROLE_MANAGER.toString());
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
    this.refresh.next();
  }

  prepareModelForBackend(event: any) {
    delete event.data.color;
    delete event.data.calendarEventColorName;
    delete event.data.invitedEmployees;
    event.data.calendarEventColor = this.calendarEventColors.find(calendarEventColor => calendarEventColor.id === event.data.calendarEventColorId);
  }
}
