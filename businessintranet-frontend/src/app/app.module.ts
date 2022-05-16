import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { DevExtremeModule } from 'devextreme-angular';
import { DxButtonModule } from 'devextreme-angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { NavigationMenuComponent } from './components/navigation-menu/navigation-menu.component';
import { HomeComponent } from './components/home/home.component';
import { EmployeesComponent } from './components/employees/employees.component';
import { CalendarComponent } from './components/calendar/calendar.component';
import { MeetingsComponent } from './components/meetings/meetings.component';
import { DiscussionsBoardComponent } from './components/discussions-board/discussions-board.component';
import { CommonModule } from '@angular/common';
import { FlatpickrModule } from 'angularx-flatpickr';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DiscussionMessageComponent } from './components/discussions-board/discussion-message/discussion-message.component';
import { DiscussionSidebarComponent } from './components/discussions-board/discussion-sidebar/discussion-sidebar.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavigationMenuComponent,
    HomeComponent,
    EmployeesComponent,
    CalendarComponent,
    MeetingsComponent,
    DiscussionsBoardComponent,
    DiscussionSidebarComponent,
    DiscussionMessageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    DevExtremeModule,
    DxButtonModule,
    CommonModule,
    FormsModule,
    NgbModalModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),
    FlatpickrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
