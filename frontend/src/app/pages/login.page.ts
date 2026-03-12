import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { AuthService } from '../services/auth.service';
@Component({ selector:'app-login-page', standalone:true, imports:[ReactiveFormsModule,MatCardModule,MatFormFieldModule,MatInputModule,MatButtonModule], template:`<mat-card><h2>Login</h2><form [formGroup]="form" (ngSubmit)="submit()"><mat-form-field appearance="outline"><mat-label>Usuario</mat-label><input matInput formControlName="username" /></mat-form-field><mat-form-field appearance="outline"><mat-label>Password</mat-label><input matInput type="password" formControlName="password" /></mat-form-field><button mat-raised-button color="primary">Ingresar</button></form></mat-card>` })
export class LoginPage{form=this.fb.group({username:[''],password:['']});constructor(private fb:FormBuilder,private auth:AuthService){}submit(){if(this.form.valid){this.auth.login(this.form.value).subscribe();}}}
