import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactListComponent } from './pages/contacts/contact-list/contact-list.component';
import { HomeComponent } from './pages/home/home.component';
import { ContactDetailComponent } from './pages/contacts/contact-detail/contact-detail.component';
import { ContactCreateComponent } from './pages/contacts/contact-create/contact-create.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'contacts', component:ContactListComponent},
  {path:'contacts/id/:id', component:ContactDetailComponent},
  {path:'contacts/create', component:ContactCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
