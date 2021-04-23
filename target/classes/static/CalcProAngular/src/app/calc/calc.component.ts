import { Component, OnInit } from '@angular/core';
import {changeText} from '../../assets/js/changeText.js';
import {getRequest} from '../../assets/js/getRequest.js';
@Component({
  selector: 'app-calc',
  templateUrl: './calc.component.html',
  styleUrls: ['./calc.component.css']
})
export class CalcComponent implements OnInit {

  constructor() { }
  value = 'Введите ваш пример';
  ngOnInit(): void {
  }
  onClk(param: string): void{
    if (this.value === 'Введите ваш пример') {
      this.value = param;
    } else if ((param === 'DEL') && (this.value !== '')) {
      this.value = this.value.slice(0, -1);
    } else if (param === 'CLR') {
      this.value = 'Введите ваш пример';
    } else if (param !== 'DEL') {
      if ((param === '-') || (param === '+') || (param === '*') || (param === '/')) {
        this.value += ' '; }
      this.value += param;
      if ((param === '-') || (param === '+') || (param === '*') || (param === '/')) {
        this.value += ' ';
      }
    }
  }
  onClk2(): void{
    let value = this.value;
    const url = new URL('http://localhost:8080/home');
    url.searchParams.set('req', value);
    url.searchParams.set('fmod', '0');
    const xhr = new XMLHttpRequest();
    const urlBased = url.toString();
    xhr.open('POST', urlBased, true);
    xhr.send();
    // tslint:disable-next-line:only-arrow-functions
    xhr.onload = function(): void {
      if (xhr.status !== 200) {
        alert(`Ошибка ${xhr.status}: ${xhr.statusText}`);
      } else {
        value = xhr.responseText + ' ';
      }
    };
    this.value = value;
  }
}
