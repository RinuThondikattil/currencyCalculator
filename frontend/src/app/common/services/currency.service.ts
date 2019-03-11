import { Injectable } from '@angular/core';
import { Http,Response,RequestOptions,Headers} from '@angular/http';
import { Observable } from 'rxjs';
import { map,catchError} from 'rxjs/operators';
import { inputRate } from '../model/inputRate.interface';
@Injectable()
export class CurrencyService {
  
  _url:string='http://localhost:8080/api/v1/currency';
  _currency:inputRate
  constructor( private _httpService: Http){}

  convertCurrency(amount,currencytype): Observable<JSON> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
   this._currency={
     amount: amount,
      type: currencytype
    }
    this._currency.type=currencytype;
    return this._httpService.post(this._url, this._currency, options).pipe(map((response: Response)=>response.json()),catchError(this.handleError));
  }


  handleError(error:Response){
    return Observable.throw(error);
  }


 
}
