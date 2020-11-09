import { NgModule } from '@angular/core';

import { MenusRoutingModule } from './menus-routing.module';

import { MenusComponent } from './menus.component';


@NgModule({
  imports: [MenusRoutingModule],
  declarations: [MenusComponent],
  exports: [MenusComponent]
})
export class MenusModule { }
