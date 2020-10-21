import { Injectable } from '@angular/core';
import {Hero} from './hero';
import {HEROES} from './mock-heroes';
import {Observable, of} from 'rxjs';
import {MessageService} from './message.service';

//@Injectable() 装饰器会接受该服务的元数据对象，就像 @Component() 对组件类的作用一样。
@Injectable({
  providedIn: 'root'
})
export class HeroService {

  getHeroes(): Observable<Hero[]> {
    this.messageService.add('HeroService: fetched heroes');
    return of(HEROES);
  }

  getHero(id: number): Observable<Hero> {
    // TODO: send the message _after_ fetching the hero
    this.messageService.add(`HeroService: fetched hero id=${id}`);
    return of(HEROES.find(hero => hero.id === id));
  }
  //这是一个典型的“服务中的服务”场景： 你把 MessageService 注入到了 HeroService 中，而 HeroService 又被注入到了 HeroesComponent 中。
  constructor(
    private messageService: MessageService
  ) { }
}
