import { CalendarEvent } from "angular-calendar";
import { EventColor, EventAction } from "calendar-utils";
import { CalendarEventColor } from "./calendar-event-color-model";

export class CalendarEventBaseModel {
  id?: string | number | undefined;
  start: Date;
  end?: Date | undefined;
  title: string;
  calendarEventColor?: CalendarEventColor;
  invitedEmployeesIds?: number[] | undefined;
}