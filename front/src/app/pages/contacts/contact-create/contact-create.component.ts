import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Contact } from 'src/app/interfaces/contact.interface';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-create',
  templateUrl: './contact-create.component.html',
  styleUrls: ['./contact-create.component.scss']
})
export class ContactCreateComponent implements OnInit {

  constructor(
    private _contacts: ContactService
  ) { }
  ngOnInit(): void {
  }

  public submit(identityForm:any, addressForm:any, phonesForm:any) {

    let identity = identityForm.form.value; 
    let address = addressForm.form.value;
    let phones = phonesForm.form.value;

    console.table(identity)
    console.table(address)
    console.log(phones)

    let contact:Contact = {
      idContact: 0,
      lastName: identity.lname, firstName: identity.fname, email:identity.mail,
      address: { city: address.city, country: address.country, street: address.street, zip: address.zip },
      phoneNumbers: [
        { id: 0, phoneKind: 'mobile', phoneNumber: phones.phoneNumber }
      ]
    }

    this.save(contact);

  }
  private save(c:Contact) {
    this._contacts.save(c).subscribe( data => console.table(data) )
  }

}

/*
let list = ["First","LastName","mail@gmail.com","123 Street View","NY","82000","Country","0789012345"]; document.querySelectorAll('form input').forEach(e => { e.value = list[0]; console.log(list[0]); list = list.slice(1,list.length); let event = new Event('input', { bubbles: true }); e.dispatchEvent(event); })
*/