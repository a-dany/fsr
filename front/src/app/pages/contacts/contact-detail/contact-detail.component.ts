import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Contact } from 'src/app/interfaces/contact.interface';
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
    (this.id) && (
      this._contacts.getId(this.id).subscribe( c => this.contact = c )
    );
  }

}
