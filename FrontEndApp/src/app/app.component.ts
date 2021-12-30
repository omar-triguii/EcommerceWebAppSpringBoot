import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FrontEndApp';
  display = "none";
  ngOnInit() {
   }
openModal() {
    this.display = "block";
  }
  onCloseHandled() {
    this.display = "none";
  }
}
