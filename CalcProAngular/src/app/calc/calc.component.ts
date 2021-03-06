import { Component, OnInit } from '@angular/core';
import {HttpService} from './http.service';
import {Request} from './request';

@Component({
  selector: 'app-calc',
  templateUrl: './calc.component.html',
  styleUrls: ['./calc.component.css'],
  providers: [HttpService]
})

export class CalcComponent implements OnInit {
  private isMobileResolution: boolean;
  // tslint:disable-next-line:variable-name
  public _value = '';
  // tslint:disable-next-line:variable-name
  public integral_state = '∫(';
  // tslint:disable-next-line:variable-name
  public fmod = 0;
  // @ts-ignore
  req: Request = new Request(); // данные вводимого пользователя
  done = false;
  constructor(private httpService: HttpService){if (window.innerWidth < 768) {
    this.isMobileResolution = true;
  } else {
    this.isMobileResolution = false;
  }}
  onClk2(): void{
    this.req.numbers = this._value;
    this.req.fmod = this.fmod;
    this.httpService.postData(this.req)
      .subscribe((data: any) => {
        this._value = data; this.done = true;
      });
  }
  ngOnInit(): void {
  }
  onClk(param: string): void{
    if (param === '∫') {param = this.integral_state;
      if (param === '∫(') { this.integral_state = ')dX lowd = ('; }
      else if (param === ')dX lowd = ('){this.integral_state = '), highd = ('; }
      else if (param === '), highd = ('){this.integral_state = ')'; }
      else if (param === ')'){this.integral_state = '∫('; this.fmod = 2; this.onClk2(); }}
    if (param === '′') {this.fmod = 1; }
    if (this._value === '') {
      this._value = param;
    } else if ((param === 'DEL') && (this._value !== '')) {
      this._value = this._value.slice(0, -1);
    } else if (param === 'CLR') {
      this._value = '';
    } else if (param !== 'DEL') {
      if ((param === '-') || (param === '+') || (param === '*') || (param === '/')) {
        this._value += ' '; }
      this._value += param;
      if ((param === '-') || (param === '+') || (param === '*') || (param === '/')) {
        this._value += ' ';
      }
    }
  }
  /*onClk2(): void {
    const url = new URL('http://localhost:8080/home');
    url.searchParams.set('req', this._value);
    url.searchParams.set('fmod', '0');
    const xhr = new XMLHttpRequest();
    const urlBased = url.toString();
    xhr.open('POST', urlBased, true);
    xhr.send();
    this.delay(300);
    // tslint:disable-next-line:only-arrow-functions
    this._value =  + ' ';
  }*/
  public getIsMobileResolution(): boolean {
    return this.isMobileResolution;
  }

}
