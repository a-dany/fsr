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
  public displayList?:Contact[];
  
  public search!:string;


  constructor( 
    private _contacts:ContactService, private _router:Router
  ) { }
  ngOnInit(): void {
    this.refreshList();
  }

  private refreshList() {
    this._contacts.get().subscribe(
      l => {
        this.list = l;
        this.displayList = l;
      }
    )
  }

  public redirect(evt:number) {
    this._router.navigate(['contacts/id', evt]);
  }
  public delete(evt:number) {
    confirm('Delete this contact ?') && this._contacts.delete(evt).subscribe( data => this.refreshList() );
  }

  public updateSearch() {
    this.displayList = this.list.filter(
      e => `${e.firstName}${e.lastName}`.trim().toUpperCase().includes(this.search.trim().toUpperCase().replace(/\s+/g, ''))
    )
  }

}
