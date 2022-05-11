import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { routerConfig } from './configurations/router-config';


@NgModule({
  imports: [RouterModule.forRoot(routerConfig)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
