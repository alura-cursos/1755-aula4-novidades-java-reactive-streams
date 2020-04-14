package br.com.alura;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

import br.com.alura.model.NotaFiscal;
import br.com.alura.processor.Processor;

public class TesteProcessor {

	public static void main(String[] args) {
		
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>();
		publisher.consume(Processor::emitir);

		NotaFiscal notaFiscal = new NotaFiscal("João", 39.99, LocalDate.now());
		publisher.submit(notaFiscal);
		System.out.println("Parabéns pela compra!!");

		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
		publisher.close();
	}
}
