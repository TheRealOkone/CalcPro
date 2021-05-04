import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Request} from './request';

@Injectable()
export class HttpService{

  constructor(private http: HttpClient){ }

  // tslint:disable-next-line:typedef
  postData(request: Request){

    const body = {req: request.numbers, fmod: 0};
    return this.http.post('http://localhost:8080/', body);
  }
}
