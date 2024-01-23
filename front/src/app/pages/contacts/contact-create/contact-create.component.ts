import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { PostContact } from 'src/app/interfaces/contact.interface';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-create',
  templateUrl: './contact-create.component.html',
  styleUrls: ['./contact-create.component.scss']
})
export class ContactCreateComponent implements OnInit {


  public phones!:FormGroup;
  private fb = new FormBuilder();

  constructor(
    private _contacts: ContactService, private route:Router
  ) { }
  ngOnInit(): void {
    this.phones = this.fb.group({
      items: this.fb.array([])
    })
  }

  public addPhone() {
    const item = this.fb.control('')
    this.items.push(item);
  }
  get items():FormArray {
    return this.phones.get('items') as FormArray
  }



  public submit(identityForm:any, addressForm:any, phonesForm:any) {

    // let phonesForm = this.phones;
    let identity = identityForm.form.value; 
    let address = addressForm.form.value;
    let phones = phonesForm.form.value

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
    this._contacts.save(c).subscribe( 
      data => {
         this.route.navigate(['/contacts'])
      }
    )
  }

}
