import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { Contact, PostContact } from 'src/app/interfaces/contact.interface';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-create',
  templateUrl: './contact-create.component.html',
  styleUrls: ['./contact-create.component.scss']
})
export class ContactCreateComponent implements OnInit {

  public headers!:HttpHeaders;
  constructor(
    private _contacts: ContactService, private route:Router
  ) { }
  ngOnInit(): void {
  }

  public submit(identityForm:any, addressForm:any, phonesForm:any) {

    let identity = identityForm.form.value; 
    let address = addressForm.form.value;
    let phones = phonesForm.form.value;

    let contact:PostContact = {
      lastName: identity.lname, firstName: identity.fname, email:identity.mail,
      address: { city: address.city, country: address.country, street: address.street, zip: address.zip },
      phoneNumbers: [
        { phoneKind: 'mobile', phoneNumber: phones.phoneNumber }
      ]
    }

    this.save(contact);

  }
  private save(c:PostContact) {
    // console.log(JSON.stringify(c))
    this._contacts.save(c).subscribe( 
      data => {
         this.route.navigate(['/contacts'])
      }
    )
  }

}

/*
let list = ["Jack","LeFou","mail@gmail.com","123 Street View","NY","82000","Country","0789012345"]; document.querySelectorAll('form input').forEach(e => { e.value = list[0]; console.log(list[0]); list = list.slice(1,list.length); let event = new Event('input', { bubbles: true }); e.dispatchEvent(event); })
*/