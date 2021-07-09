import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  ngOnInit() {  
  this.loadJsFile("../assets/dashboard/plugins/jquery/jquery.min.js");  
  this.loadJsFile("../assets/dashboard/dist/js/adminlte.min.js");  
  }  
  public loadJsFile(url:string) {  
    let node = document.createElement('script');  
    node.type = 'application/javascript';
    node.src=url;
    node.async = false;
    node.charset = 'utf-8';
    document.getElementsByTagName('head')[0].appendChild(node);  
  }  

}
