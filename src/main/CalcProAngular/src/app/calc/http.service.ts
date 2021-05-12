import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Request} from './request';

@Injectable()
export class HttpService{

  constructor(private http: HttpClient){ }

  // tslint:disable-next-line:typedef
  postData(request: Request){
    const chars = [...request.numbers];
    chars.forEach((c, i) => {if (chars[i] === '+') {chars[i] = '%2B'; }});
    request.numbers = chars.join('');
    return this.http.get('http://localhost:8080/?req=' + request.numbers + '&fmod=' + request.fmod);
  }
}
