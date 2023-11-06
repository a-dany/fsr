import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactListComponent } from './pages/contacts/contact-list/contact-list.component';
import { HomeComponent } from './pages/home/home.component';
import { ContactDetailComponent } from './pages/contacts/contact-detail/contact-detail.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'contacts', component:ContactListComponent},
  {path:'contacts/:id', component:ContactDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
