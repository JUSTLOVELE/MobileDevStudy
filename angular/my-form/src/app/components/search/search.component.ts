import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  public products = [
    {
      "name": "Products",
      "description": "产品"
    },
    {
      "name": "Phone XL",
      "description": "手机产品"
    },
    {
      "name": "Phone Mini",
      "description": "小手机"
    },
    {
      "name": "Phone Standard",
      "description": "标准型号"
    }];

  constructor() { }

  ngOnInit(): void {
  }

}
