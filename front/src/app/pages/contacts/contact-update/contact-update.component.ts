import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Contact } from 'src/app/interfaces/contact.interface';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-update',
  templateUrl: './contact-update.component.html',
  styleUrls: ['./contact-update.component.scss']
})
export class ContactUpdateComponent implements OnInit {

  public contact!:Contact;

  constructor(private _route:ActivatedRoute, private _contacts:ContactService) { }
  ngOnInit(): void {
    this.initContact();
  }

  public initContact() {
    let idContact = this._route.snapshot.paramMap.get("id");
    (idContact) && this._contacts.getId(idContact).subscribe(
      data => this.contact = data
    )
  }

  public submit() {
    console.log(this.contact);
  }

}
