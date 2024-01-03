import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Group } from 'src/app/interfaces/group.interface';
import { GroupService } from 'src/app/services/group.service';

@Component({
  selector: 'app-group-list',
  templateUrl: './group-list.component.html',
  styleUrls: ['./group-list.component.scss']
})
export class GroupListComponent implements OnInit {


  private groups?:Group[];
  public  displayGroups?:Group[];
  public  search!:string;

  constructor(private _groups:GroupService, private _router:Router) { }
  ngOnInit(): void {
    this.getGroups();
  }

  public create() {
    // this._router.navigate(['groups/create']);
    let name = prompt('Group Name');
    (name && name.length > 0) && this._groups.save(name).subscribe().add(() => this.getGroups())
  }

  public getGroups() {
    this._groups.get().subscribe( data => this.groups = data )
      .add(
        () => this.displayGroups = this.groups
      )
  }

  public updateSearch() {
    this.displayGroups = this.groups?.filter(e => e.name.trim().toUpperCase().includes(this.search.trim().toUpperCase()))
  }

  public delete(id:number) {
    confirm('Delete this group ?') && this._groups.delete(id).subscribe().add(
      () => this.getGroups()
    )
  }
  public click(id: number) {
    this._router.navigate(['groups/id/', id])
  }

}
