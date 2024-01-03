import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-group-create',
  templateUrl: './group-create.component.html',
  styleUrls: ['./group-create.component.scss']
})
export class GroupCreateComponent implements OnInit {

  constructor() { }
  ngOnInit(): void {
  }

  public submit(f:any) {
    alert('Unimplemented Yet.')
  }

}
