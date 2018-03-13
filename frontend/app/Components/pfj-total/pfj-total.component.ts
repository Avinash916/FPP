import { Component, OnInit, Input } from '@angular/core';
import { PFJTotal } from '../../Models/pfj-tiles';
import { UtilityService } from '../../Helper/utility-service';

@Component({
  selector: 'app-pfj-total',
  templateUrl: './pfj-total.component.html',
  styleUrls: ['./pfj-total.component.css']
})
export class PfjtotalComponent implements OnInit {
  @Input() pfjTotal : PFJTotal;
  constructor(public utility:UtilityService) { }

  ngOnInit() {
  }
}
