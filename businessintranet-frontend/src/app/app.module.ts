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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavigationMenuComponent,
    HomeComponent,
    EmployeesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    DevExtremeModule,
    DxButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
