import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Contact } from 'src/app/interfaces/contact.interface';

@Component({
  selector: 'app-contact-item',
  templateUrl: './contact-item.component.html',
  styleUrls: ['./contact-item.component.scss']
})
export class ContactItemComponent implements OnInit {

  
  @Input() contact?:Contact;

  @Output() clickEvent  = new EventEmitter<number>();
  @Output() deleteEvent = new EventEmitter<number>();

  
  constructor() { }
  ngOnInit(): void {
  }


  public onClick() {
    (this.contact) && this.clickEvent.emit(this.contact.idContact)
  }
  public onDelete() {
    (this.contact) && this.deleteEvent.emit(this.contact.idContact)
  }


}
