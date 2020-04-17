package br.com.alura.subscriber;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import br.com.alura.model.NotaFiscal;

public class NotaFiscalSubscriber implements Subscriber<NotaFiscal> {

	@Override
	public void onSubscribe(Subscription subscription) {
	}

	@Override
	public void onNext(NotaFiscal notaFiscal) {
	}

	@Override
	public void onError(Throwable throwable) {
	}

	@Override
	public void onComplete() {
	}
}
