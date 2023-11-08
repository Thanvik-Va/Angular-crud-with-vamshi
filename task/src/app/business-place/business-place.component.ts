import { Organization } from './../classes/organization';
import { Data } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

import { Component, Inject } from '@angular/core';
import {
  FormBuilder,
  Validators,
  FormControl,
  FormGroup,
} from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { OrgServiceService } from '../services/org-service.service';

@Component({
  selector: 'app-business-place',
  templateUrl: './business-place.component.html',
  styleUrls: ['./business-place.component.css'],
})
export class BusinessPlaceComponent {
  public states: string[] = ['Telanagana', 'Kerala', 'Maharastra', 'Delhi'];
  public countries: string[] = ['India', 'Usa', 'Dubai', 'Uk'];
  bpDetails: any[] = [];
  bpRegister: FormGroup;

  status: string = 'Business Place Added Successfully';
  isButtonDisabled: boolean = false;
  constructor(
    @Inject(MAT_DIALOG_DATA) public bpData:any,
    private fb: FormBuilder,
    private bpService: OrgServiceService,
    private diaRef: MatDialogRef<BusinessPlaceComponent>,
    private snackBar: MatSnackBar
  ) {
    this.bpRegister = this.fb.group({
      businessPlaceLegalName: ['', [Validators.required]],
      businessPlaceLocation: this.fb.control('', [Validators.required]),
      stateName: this.fb.control('', [Validators.required]),
      countryName: this.fb.control('', [Validators.required]),
      businessPlaceContact: this.fb.control('', [
        Validators.required,
        Validators.pattern(/\+91\d{10}/),

      ]),
      businessPlaceZipCode: this.fb.control('', [
        Validators.required,
        Validators.minLength(6),
      ]),
    });
  }

  ngOnInit(): void {

    console.log(this.bpData);
  }

  // FormGroup

  get businessPlaceLegalName(): FormControl {
    return this.bpRegister.get('businessPlaceLegalName') as FormControl;
  }

  get businessPlaceLocation(): FormControl {
    return this.bpRegister.get('businessPlaceLocation') as FormControl;
  }

  get stateName(): FormControl {
    return this.bpRegister.get('stateName') as FormControl;
  }

  get countryName(): FormControl {
    return this.bpRegister.get('countryName') as FormControl;
  }

  get businessPlaceContact(): FormControl {
    return this.bpRegister.get('businessPlaceContact') as FormControl;
  }

  get businessPlaceZipCode(): FormControl {
    return this.bpRegister.get('businessPlaceZipCode') as FormControl;
  }


  onSubmit() {

    if (this.bpRegister.valid) {
      this.bpService.addBusinessPlace(this.bpRegister.value,this.bpData).subscribe({
        next: (val: any) => {
          alert('Business place added successfully');
        },
        error: (err: any) => {
          console.log(err);
        },
      });
    }


    }
  }

