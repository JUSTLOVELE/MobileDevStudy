import { Component, Input, OnInit } from '@angular/core';
import {Hero} from '../../hero';

@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.scss']
})
export class HeroDetailComponent implements OnInit {
  //@input的作用是定义模块输入，是用来让父级组件向子组件传递内容
  @Input() hero: Hero;

  constructor() { }

  ngOnInit(): void {
  }

}
