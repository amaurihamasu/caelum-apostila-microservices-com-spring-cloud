import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PagamentoService {

  private API = environment.pagamentoUrl + '/pagamentos';

  constructor(private http: HttpClient) {
  }

  cria(pagamento): Observable<any> {
    this.ajusteIds(pagamento);
    return this.http.post(`${this.API}`, pagamento);
  }

  confirma(pagamento): Observable<any> {
    const URL = pagamento._links.confirma.href;
    return this.http.put(URL, null);
  }

  cancela(pagamento): Observable<any> {
    const URL = pagamento._links.cancela.href;
    return this.http.delete(URL);
  }

  private ajusteIds = (pagamento) => {
    pagamento.formaDePagamentoId = pagamento.formaDePagamentoId || pagamento.formaDePagamento.id;
    pagamento.pedidoId = pagamento.pedidoId || pagamento.pedido.id;
  }

}
