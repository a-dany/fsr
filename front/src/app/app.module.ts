import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactListComponent } from './pages/contacts/contact-list/contact-list.component';
import { HomeComponent } from './pages/home/home.component';
import { ComponentsModule } from './components/components.module';
import { HttpClientModule } from '@angular/common/http';
import { ContactDetailComponent } from './pages/contacts/contact-detail/contact-detail.component';
import { ContactCreateComponent } from './pages/contacts/contact-create/contact-create.component';
import { FormsModule } from '@angular/forms';
import { GroupListComponent } from './pages/groups/group-list/group-list.component';
import { GroupDetailComponent } from './pages/groups/group-detail/group-detail.component';
import { GroupCreateComponent } from './pages/groups/group-create/group-create.component';
import { ContactUpdateComponent } from './pages/contacts/contact-update/contact-update.component';

@NgModule({
  declarations: [
    AppComponent,
    ContactListComponent,
    HomeComponent,
    ContactDetailComponent,
    ContactCreateComponent,
    GroupListComponent,
    GroupDetailComponent,
    GroupCreateComponent,
    ContactUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ComponentsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
