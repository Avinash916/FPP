import { Component, OnInit, Input } from '@angular/core';
import { BetterOf } from '../../Models/pfj-tiles';
import { UtilityService } from '../../Helper/utility-service';
@Component({
  selector: 'app-pfj-data-sub-tile-better-of',
  templateUrl: './pfj-data-sub-tile-better-of.component.html',
  styleUrls: ['./pfj-data-sub-tile-better-of.component.css']
})
export class PfjDataSubTileBetterOfComponent implements OnInit {
  @Input() betterOf : BetterOf;
  constructor(public utility:UtilityService) { }

  ngOnInit() {
  }
 }
