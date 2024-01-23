import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { Contact } from 'src/app/interfaces/contact.interface';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-modal',
  templateUrl: './contact-modal.component.html',
  styleUrls: ['./contact-modal.component.scss']
})
export class ContactModalComponent implements OnInit {

  @ViewChild('contactList') contactList!:ElementRef;

  public contacts!:Contact[];
  public idList:number[] = [];

  @Output() public onClose  = new EventEmitter<any>();
  @Output() public onSubmit = new EventEmitter<number[]>();

  constructor(private _contacts:ContactService) { }
  ngOnInit(): void {
    this.initContacts();
  }

  private initContacts() {
    this._contacts.get().subscribe(
      data => { 
        this.contacts = data
        this.idList = [];
      }
    )
  }

  public closeModal() { 
    this.onClose.emit(); this.idList = [];
  }

  public toggleContact(id:number) {
    this.idList.includes(id) ? (this.idList = this.idList.filter(e => e != id)) : this.idList.push(id)
    this.updateStyle(id);
  }

  public submit() {
    this.onSubmit.emit(this.idList);
    this.idList = [];
  }

  public updateStyle(id:number) {
    this.contactList.nativeElement.querySelector(`[contact-id="${id}"]`)?.classList.toggle("selected")
  }

}
