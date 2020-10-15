import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { FormComponent } from './components/form/form.component';
import { SearchComponent } from './components/search/search.component';
import {HttpClientModule, HttpClientJsonpModule} from '@angular/common/http';
import { Logger } from './logger.service';
import { HeroesComponent } from './components/heroes/heroes.component';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    SearchComponent,
    HeroesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpClientJsonpModule
  ],
  providers: [
    Logger
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
