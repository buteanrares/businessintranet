import { Routes } from "@angular/router";
import { CalendarComponent } from "../components/calendar/calendar.component";
import { DiscussionsBoardComponent } from "../components/discussions-board/discussions-board.component";
import { EmployeesComponent } from "../components/employees/employees.component";
import { HomeComponent } from "../components/home/home.component";
import { LoginComponent } from "../components/login/login.component";
import { MeetingsComponent } from "../components/meetings/meetings.component";

export const routerConfig: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'employees',
    component: EmployeesComponent
  },
  {
    path: 'calendar',
    component: CalendarComponent
  },
  {
    path: 'meetings',
    component: MeetingsComponent
  },
  {
    path: 'discussions-board',
    component: DiscussionsBoardComponent
  },
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  //TODO: uncomment when app is stable
  // {
  //   path: '**',
  //   redirectTo: '/home',
  //   pathMatch: 'full'
  // }
]