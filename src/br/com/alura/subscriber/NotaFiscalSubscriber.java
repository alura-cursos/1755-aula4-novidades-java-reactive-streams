package br.com.alura.subscriber;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import br.com.alura.model.NotaFiscal;
import br.com.alura.wsclient.NotaFiscalWSClient;

public class NotaFiscalSubscriber implements Subscriber<NotaFiscal> {

	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println("Chamando o onSubscribe!!");
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(NotaFiscal notaFiscal) {
		NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
		nfwsc.enviar(notaFiscal);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Todas as notas foram emitidas!!");
	}
}
