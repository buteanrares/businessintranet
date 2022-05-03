import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { DevExtremeModule } from 'devextreme-angular';
import { DxButtonModule } from 'devextreme-angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './models/employee/employee.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { SidemenuComponent } from './components/sidemenu/sidemenu.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    LoginComponent,
    SidemenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    DevExtremeModule,
    DxButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
