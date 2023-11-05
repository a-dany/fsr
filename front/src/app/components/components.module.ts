import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { RouterModule } from '@angular/router';
import { ContactItemComponent } from './contact-item/contact-item.component';

@NgModule({
  declarations: [ NavbarComponent, ContactItemComponent ],
  imports: [ CommonModule, RouterModule ],
  exports: [ NavbarComponent, ContactItemComponent ]
})
export class ComponentsModule { }
