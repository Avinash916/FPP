import { Component, OnInit, Input } from '@angular/core';
import { PFJTotal } from '../../Models/pfj-tiles';

@Component({
  selector: 'app-pfjtotal',
  templateUrl: './pfjtotal.component.html',
  styleUrls: ['./pfjtotal.component.css']
})
export class PfjtotalComponent implements OnInit {
  @Input() pfjTotal : PFJTotal;
  constructor() { }

  ngOnInit() {
  }
  roundOffData(data:string)
  {
    data = data.toString().trim().replace("-","");
    return parseFloat(data).toFixed(2);
  }
}
