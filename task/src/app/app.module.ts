import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';



import { OrganizationComponent } from './organization/organization.component';
import { BusinessPlaceComponent } from './business-place/business-place.component';

import { MAT_DIALOG_DEFAULT_OPTIONS, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';



import {MatDividerModule} from '@angular/material/divider';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { ThemePalette } from '@angular/material/core';
import { NgModel, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    OrganizationComponent,
    BusinessPlaceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
     MatDialogModule,
     MatIconModule,
     MatFormFieldModule,
     MatSelectModule,
     MatInputModule,
     MatButtonModule,
    MatSnackBarModule,
    ToastrModule.forRoot(),



  ],
  providers: [],
  bootstrap: [OrganizationComponent]
})
export class AppModule { }
