import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
  <!-- header -->
  <app-header></app-header>
  <!-- routes will be rendered here -->

  <!-- footer-->
  <app-footer></app-footer>
`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front';
}
