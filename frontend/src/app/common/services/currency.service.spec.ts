import { TestBed, inject } from '@angular/core/testing';
import {HttpClientTestingModule} from '@angular/common/http/testing'
import {  CurrencyService } from './currency.service';

describe('CurrencyService', () => {
  let service: CurrencyService;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers: [CurrencyService]
    });
    service=TestBed.get(CurrencyService);
  });

 
});
