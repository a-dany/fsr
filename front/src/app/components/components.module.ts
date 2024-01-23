import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { RouterModule } from '@angular/router';
import { ContactItemComponent } from './contact-item/contact-item.component';
import { GroupItemComponent } from './group-item/group-item.component';
import { ContactModalComponent } from './contact-modal/contact-modal.component';

@NgModule({
  declarations: [ NavbarComponent, ContactItemComponent, GroupItemComponent, ContactModalComponent ],
  imports: [ CommonModule, RouterModule ],
  exports: [ NavbarComponent, ContactItemComponent, GroupItemComponent, ContactModalComponent ]
})
export class ComponentsModule { }
