import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Organization } from '../classes/organization';

@Injectable({
  providedIn: 'root',
})
export class OrgServiceService {
  constructor(private http: HttpClient) {}

  addOrganization(data: any): Observable<any> {
    return this.http.post(
      ' http://localhost:8080/org/createOrganization',
      data
    );
  }

  getOrganization(data: any): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/org/getBy/${data}`);
  }

  // add business place
  addBusinessPlace(bp: any, org: any): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/businessplaces/create/${org}`,
      bp
    );
  }

  // get business places
  getBusinessPlace(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/businessplaces/findAll');
  }
}
