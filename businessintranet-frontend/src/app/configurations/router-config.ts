import { Routes } from "@angular/router";
import { EmployeesComponent } from "../components/employees/employees.component";
import { HomeComponent } from "../components/home/home.component";

export const routerConfig: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'employees',
    component: EmployeesComponent
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