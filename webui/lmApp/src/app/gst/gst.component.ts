import { Component, OnInit } from '@angular/core';
import { VendorService} from 'src/app/Vendor.service';
import { Gst } from '../model/Gst';

@Component({
  selector: 'app-gst',
  templateUrl: './gst.component.html',
  styleUrls: ['./gst.component.css']
})
export class GstComponent implements OnInit {
  vendorService:VendorService;
  private month:any;
  private Gst1;
  private state:any;

  constructor(vendorService:VendorService ) {
    this.vendorService = vendorService;
   }

  ngOnInit() {
  }
  calulateTotalPrice(selected) {
    this.month=selected;
    console.log(this.month);
    let venId = localStorage.getItem('venId');
    console.log(venId);
    this.vendorService.totaltax(this.month, venId)
    .subscribe(response=> {
        this.Gst1 =response;
        console.log(this.Gst1)
        //this.state=Gst1.stateGst;
    });
    }

  }
