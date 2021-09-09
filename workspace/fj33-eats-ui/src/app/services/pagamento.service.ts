import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PagamentoService {

  private API = environment.baseUrl + '/pagamentos';

  constructor(private http: HttpClient) {
  }

  cria(pagamento): Observable<any> {
    this.ajusteIds(pagamento);
    return this.http.post(`${this.API}`, pagamento);
  }

  confirma(pagamento): Observable<any> {
    const linkConfirma = pagamento._links.confirma;
    return this.http.request(linkConfirma.method, linkConfirma.href);
  }

  cancela(pagamento): Observable<any> {
    const linkCancela = pagamento._links.cancela;
    return this.http.request(linkCancela.method, linkCancela.href);
  }

  private ajusteIds = (pagamento) => {
    pagamento.formaDePagamentoId = pagamento.formaDePagamentoId || pagamento.formaDePagamento.id;
    pagamento.pedidoId = pagamento.pedidoId || pagamento.pedido.id;
  }

}
