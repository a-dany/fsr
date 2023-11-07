import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contact } from 'src/app/interfaces/contact.interface';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.scss']
})
export class ContactListComponent implements OnInit {

  public list!:Contact[];

  constructor( 
    private _contacts:ContactService, private _router:Router
  ) { }
  ngOnInit(): void {
    this._contacts.get().subscribe(
      l => this.list = l
    )
  }

  public redirect(evt:number) {
    this._router.navigate(['contacts/id', evt]);
  }

}
