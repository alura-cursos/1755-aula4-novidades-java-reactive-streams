package br.com.alura;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

import br.com.alura.model.NotaFiscal;
import br.com.alura.subscriber.NotaFiscalSubscriber;

public class TesteProcessor {

	public static void main(String[] args) {

		NotaFiscalSubscriber nfs = new NotaFiscalSubscriber();
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<NotaFiscal>();

		publisher.subscribe(nfs);

		NotaFiscal notaFiscal = new NotaFiscal("João", 39.99, LocalDate.now());
		NotaFiscal notaFiscalMag = new NotaFiscal("Mag", 40.00, LocalDate.now());

		publisher.submit(notaFiscal);
		publisher.submit(notaFiscalMag);
		publisher.close();

		System.out.println("Parabéns pela compra!!");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
	}
}
