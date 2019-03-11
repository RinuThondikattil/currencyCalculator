import { Component } from '@angular/core';

@Component({
  selector: 'pm-root',
  templateUrl: './app.component.html',
  styleUrls:['./app.component.css']
})
export class AppComponent {
  
  result;
  
  constructor(){}

  getResult($event){
      this.result=$event['USD'].amount;  
      console.log(this.result)      
  }
}
