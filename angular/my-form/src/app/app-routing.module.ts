import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from '@angular/router';
import { HeroesComponent } from './components/heroes/heroes.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {HeroDetailComponent} from './components/hero-detail/hero-detail.component';

//path用来匹配浏览器地址栏中URL的字符串
//component导航到该路由时,路由器应该创建的组件
//如果网址类似于 localhost:4200/heroes 就显示 HeroesComponent
const routes: Routes = [{
  path: '', redirectTo: '/dashboard', pathMatch: 'full'
},{
  path: 'heroes', component: HeroesComponent
},{
  path: 'dashboard', component: DashboardComponent
},{
  path: 'detail/:id', component: HeroDetailComponent
}]

@NgModule({
  //declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
