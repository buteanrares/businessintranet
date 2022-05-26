import { CalendarEvent } from "angular-calendar";
import { EventColor, EventAction } from "calendar-utils";
import { EmployeeBaseModel } from "../employee-models/employee-base-model";
import { CalendarEventColor } from "./calendar-event-color-model";

export class CalendarEventBaseModel implements CalendarEvent {
  id?: string | number | undefined;
  start: Date;
  end?: Date | undefined;
  title: string;
  calendarEventColor?: CalendarEventColor;
  calendarEventColorId: number;
  calendarEventColorName?: string;
  color?: EventColor | undefined;
  invitedEmployees?: EmployeeBaseModel[];
  invitedEmployeesIds?: number[];
}
