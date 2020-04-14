package br.com.alura;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

import br.com.alura.model.NotaFiscal;
import br.com.alura.processor.Processor;

public class TesteProcessor {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<NotaFiscal>();

		publisher.consume(Processor::emitir);

		NotaFiscal notaFiscal = new NotaFiscal("Jo�o", 39.99, LocalDate.now());

		publisher.submit(notaFiscal);

		System.out.println("Parab�ns pela compra!!");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
		publisher.close();
	}
}
