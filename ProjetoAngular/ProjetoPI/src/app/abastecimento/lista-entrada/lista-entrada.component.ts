import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { NgForm, Form, FormGroup, FormControl } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';

import { Entradas, ResponseEntradas } from '../entrada-de-produto/shared/entrada.model';
import { EntradasService } from '../entrada-de-produto/shared/entrada.service';
import { Itens } from 'src/app/financeiro/cupom-de-venda/shared/documentofiscal.model';

@Component({
  selector: 'app-lista-entrada',
  templateUrl: './lista-entrada.component.html',
  styleUrls: ['./lista-entrada.component.css']
})
export class ListaEntradaComponent implements OnInit {
  
  loading: boolean;

  public paginaAtual = 1;

  responseEntradas: ResponseEntradas[];

    idDF: any;

  constructor(
    private entradasService: EntradasService,
    private http: HttpClient,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.loading = true;
    this.listarTodasEntradas();
  }

  listarTodasEntradas() {
    this.entradasService.getEntradas().subscribe(response => {
      this.responseEntradas = response;
      this.loading = false;
    });
  }

  register(): void {
      console.log(this.idDF);
      this.entradasService.getEntrada(this.idDF).subscribe();
      this.router.navigate(['/listaEntradaProdutos', this.idDF]);
  }

}
