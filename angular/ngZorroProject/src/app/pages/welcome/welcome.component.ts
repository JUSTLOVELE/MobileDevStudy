import { Component, OnInit } from '@angular/core';
interface Person {
  key: string;
  name: string;
  age: number;
  address: string;
}



@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
 
})


export class WelcomeComponent implements OnInit {

  listOfData: Person[] = [
    {
      key: '1',
      name: 'John Brown',
      age: 32,
      address: 'New York No. 1 Lake Park'
    },
    {
      key: '2',
      name: 'Jim Green',
      age: 42,
      address: 'London No. 1 Lake Park'
    },
    {
      key: '3',
      name: 'Joe Black',
      age: 32,
      address: 'Sidney No. 1 Lake Park'
    }
  ];

  constructor() { }

  ngOnInit() {
  }

}
