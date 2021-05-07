import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { CalcComponent } from './calc/calc.component';
import { InfoComponent } from './info/info.component';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path:  '', pathMatch:  'full', redirectTo:  'home'},
  {path: 'home', component: CalcComponent},
  {path: 'info', component: InfoComponent},
];
@NgModule({
  declarations: [
    AppComponent,
    CalcComponent,
    FooterComponent,
    HeaderComponent,
    InfoComponent,

  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    [RouterModule.forRoot(routes)],
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
