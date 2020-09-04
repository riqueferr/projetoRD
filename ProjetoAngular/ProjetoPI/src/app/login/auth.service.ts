import { Injectable, EventEmitter } from '@angular/core';
import { Usuario } from './usuario';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public usuarioAutenticado = false;

  mostrarMenuEmitter = new EventEmitter<boolean>();
  constructor(private router: Router) { }

  // tslint:disable-next-line: typedef
  fazerLogin(user: any) {

    return new Promise((resolve) => {
      window.localStorage.setItem('token', 'meu-token');
      resolve(true);
    });
    // // tslint:disable-next-line: triple-equals
    // if (usuario.nome == '166534' &&
    //   // tslint:disable-next-line: triple-equals
    //   usuario.senha == '123456') {

    //   this.usuarioAutenticado = true;
    //   this.mostrarMenuEmitter.emit(true);
    //   this.router.navigate(['/abastecimento-dashboard']);

    // } else {
    //   this.usuarioAutenticado = false;
    //   this.mostrarMenuEmitter.emit(false);
    // }
  }

  // tslint:disable-next-line: typedef
  // usuarioEstaAutenticado() {
  //   return this.usuarioAutenticado;
  // }
}
