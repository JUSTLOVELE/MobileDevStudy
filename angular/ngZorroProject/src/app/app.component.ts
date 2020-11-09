import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  public menuList = [{
    title: "loopMenu1",
    icon: "Dashboard",
    secMenu:[{
      routerLink: "/welcome",
      menuName: "welcome1"
    },{
      routerLink: "/menus",
      menuName: "menus1"
    }]
  },{
    title: "loopMenu2",
    icon: "form",
    secMenu:[{
      routerLink: "/menus",
      menuName: "menu_2_1"
    },{
      routerLink: "/menus",
      menuName: "menu_2_2"
    }]
  },{
    title: "loopMenu3",
    icon: "form",
    secMenu:[{
      routerLink: "/menus",
      menuName: "menu_3_1"
    },{
      routerLink: "/menus",
      menuName: "menu_3_2"
    }]
  }

]
  isCollapsed = false;
}
