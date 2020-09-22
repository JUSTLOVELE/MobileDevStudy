import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  public peopleInfo:any = {
    username: '',
    sex: '1',
    cityList: ['北京','福建','杭州'],
    city: '福建',
    hobby: [{
      title: '吃饭',
      checked: false
    },{
      title: '睡觉',
      checked: false
    },{
      title: '篮球',
      checked: true
    }],
    mark: ''
  }

  constructor() { }

  ngOnInit(): void {
  }

  doSubmit() {

    /*
    //Dom操作获取表单数据
    let nameDom:any = document.getElementById("username");
    console.log(nameDom.value)
    */
   console.log(this.peopleInfo.username)
  }

}
