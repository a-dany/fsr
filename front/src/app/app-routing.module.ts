import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactListComponent } from './pages/contacts/contact-list/contact-list.component';
import { HomeComponent } from './pages/home/home.component';
import { ContactDetailComponent } from './pages/contacts/contact-detail/contact-detail.component';
import { ContactCreateComponent } from './pages/contacts/contact-create/contact-create.component';
import { GroupListComponent } from './pages/groups/group-list/group-list.component';
import { GroupDetailComponent } from './pages/groups/group-detail/group-detail.component';
import { GroupCreateComponent } from './pages/groups/group-create/group-create.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'contacts', component:ContactListComponent},
  {path:'contacts/id/:id', component:ContactDetailComponent},
  {path:'contacts/create', component:ContactCreateComponent}, 
  {path:'groups', component:GroupListComponent}, 
  {path:'groups/id/:id', component:GroupDetailComponent}, 
  {path:'groups/create', component:GroupCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
