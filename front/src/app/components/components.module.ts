import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { RouterModule } from '@angular/router';
import { ContactItemComponent } from './contact-item/contact-item.component';
import { GroupItemComponent } from './group-item/group-item.component';

@NgModule({
  declarations: [ NavbarComponent, ContactItemComponent, GroupItemComponent ],
  imports: [ CommonModule, RouterModule ],
  exports: [ NavbarComponent, ContactItemComponent, GroupItemComponent ]
})
export class ComponentsModule { }
