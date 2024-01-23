import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Contact } from 'src/app/interfaces/contact.interface';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-update',
  templateUrl: './contact-update.component.html',
  styleUrls: ['./contact-update.component.scss']
})
export class ContactUpdateComponent implements OnInit {

  public contact!:Contact;
  private idContact!:string;

  constructor(private _route:ActivatedRoute, private _router:Router, private _contacts:ContactService) { }
  ngOnInit(): void {
    this.initContact();
  }

  public initContact() {
    let idc = this._route.snapshot.paramMap.get("id");
    if (idc) {
      this.idContact = idc
      this._contacts.getId(this.idContact).subscribe(
        data => this.contact = data
      )
    }

  }

  public submit() {
    this._contacts.update(this.idContact, this.contact).subscribe(
      data => {
        this._router.navigate(['contacts/id', this.idContact])
      }
    );
  }

}
