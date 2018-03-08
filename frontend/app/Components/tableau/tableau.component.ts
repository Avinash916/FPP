import { Component, OnInit,AfterViewInit,ElementRef,Renderer2,Input,SimpleChanges,AfterContentChecked,ChangeDetectorRef } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Http } from '@angular/http';
declare var tableau: any;
declare var $: any;
@Component({
  selector: 'app-tableau',
  templateUrl: './tableau.component.html',
  styleUrls: ['./tableau.component.css']
})
export class TableauComponent implements OnInit,AfterViewInit,AfterContentChecked {
  tableauViz:any;
  @Input() viewUrl:string;
  @Input() configTableau:Array<string>[]=[];
  data:string;
  myTemplate: any = "";
  constructor(public elementRef:ElementRef,public renderer2: Renderer2,
    public sanitizer: DomSanitizer,public cd : ChangeDetectorRef,public http:Http) { }

  ngAfterViewInit()
  {
    /*var scriptTableau = document.createElement("script");
    scriptTableau.type = "text/javascript";
    scriptTableau.src = "https://tableau.pilotcorp.net/javascripts/api/viz_v1.js";
    this.elementRef.nativeElement.appendChild(scriptTableau);*/
  }
  ngOnInit() {

  }

  ngAfterContentChecked()
  {
    if(this.viewUrl!=null && this.viewUrl!="" && this.configTableau.length>0)
    {
      this.configTableau.forEach(c=>{
        this.viewUrl += "&:"+c;
      });
    }
    //this.data = this.viewUrl.split('?')[0].split('//')[1].split('/')[5];

  }
}
