package br.com.alura.subscriber;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import br.com.alura.model.NotaFiscal;
import br.com.alura.processor.Processor;

public class NotaFiscalSubscriber implements Subscriber<NotaFiscal>{

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(NotaFiscal nf) {
		Processor.emitir(nf);
		subscription.request(1);
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
