import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Group } from 'src/app/interfaces/group.interface';
import { GroupService } from 'src/app/services/group.service';

@Component({
  selector: 'app-group-detail',
  templateUrl: './group-detail.component.html',
  styleUrls: ['./group-detail.component.scss']
})
export class GroupDetailComponent implements OnInit {


  /***| ATTRIBUTES |***/

  public group!:Group;
  public search!:string;


  /***| INIT METHODS |***/

  constructor(private _groups:GroupService, private _route:ActivatedRoute, private _router:Router) { }

  ngOnInit(): void { this.resetGroup(); }

  private resetGroup() {
    let id = this._route.snapshot.paramMap.get('id');
    id && this._groups.getId(id).subscribe(
      data => this.group = data
    )
  }


  /***| MISCELLANEOUS |***/

  public updateSearch() {
    alert('Unimplemented yet.')
  }


  /***| MAIN METHODS |***/

  public redirect(evt:number) {
    this._router.navigate(['contacts/id', evt]);
  }
  public delete(e:any) { // remove contacts
    (confirm('Remove this contact from the group ?')) && this._groups.removeContact(`${this.group.idGroup}`, [e]).subscribe(
      data => console.log(data)
    ).add( () => this.resetGroup() )
  }
  // TODO : Fix contact selection
  public addContacts() {
    let values = [];
    let id = prompt('Contact id');
    if (id) {
      values.push(id)
      this._groups.addContact(`${this.group.idGroup}`, values).subscribe(
        data => console.log(data)
      ).add( () => this.resetGroup() )
    }
  }


}
