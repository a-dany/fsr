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

@NgModule({
  declarations: [
    AppComponent,
    ContactListComponent,
    HomeComponent,
    ContactDetailComponent,
    ContactCreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ComponentsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
