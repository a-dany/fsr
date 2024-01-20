import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Contact } from 'src/app/interfaces/contact.interface';
import { PhoneNumber } from 'src/app/interfaces/phone-number.interface';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-detail',
  templateUrl: './contact-detail.component.html',
  styleUrls: ['./contact-detail.component.scss']
})
export class ContactDetailComponent implements OnInit {

  public contact?:Contact;
  private id ?: string | null;

  constructor(
    private _contacts:ContactService, private route:ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.loadContact();
  }

  public addPhoneNumber() {
    let value = prompt('PhoneNumber');
    if (value && value.trim() != '' && this.contact) {

      let pn = { phoneKind: 'smartphone', phoneNumber: value } as PhoneNumber;
      this._contacts.addPhoneNumber(this.contact?.idContact, pn).subscribe( data => console.log(data) )
        .add( () => this.loadContact() )

    }
  }

  public removePhoneNumber(id:number) {
    if(this.contact && confirm('Delete this phone number ?')) {
      this._contacts.removePhoneNumber(this.contact?.idContact, id).subscribe( data => console.log(data) )
        .add( () => this.loadContact() )
    }
  }

  private loadContact() {
    (this.id) && this._contacts.getId(this.id).subscribe( c => this.contact = c )
  }

}
