import { Component, OnInit, Input } from '@angular/core';
import { PFJTotal } from '../../Models/pfj-tiles';
import { UtilityService } from '../../Helper/utility-service';

@Component({
  selector: 'app-pfjtotal',
  templateUrl: './pfjtotal.component.html',
  styleUrls: ['./pfjtotal.component.css']
})
export class PfjtotalComponent implements OnInit {
  @Input() pfjTotal : PFJTotal;
  constructor(public utility:UtilityService) { }

  ngOnInit() {
  }
}
