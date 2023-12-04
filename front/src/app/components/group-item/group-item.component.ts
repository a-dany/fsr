import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Group } from 'src/app/interfaces/group.interface';

@Component({
  selector: 'app-group-item',
  templateUrl: './group-item.component.html',
  styleUrls: ['./group-item.component.scss']
})
export class GroupItemComponent implements OnInit {

  @Input () group!:Group;
  @Output() onDelete = new EventEmitter<number>();

  constructor() { }
  ngOnInit(): void {
  }

  public delete() {
    this.onDelete.emit(this.group.idGroup)
  }

}
