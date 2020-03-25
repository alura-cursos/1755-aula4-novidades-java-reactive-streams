package br.com.alura.processor;

import br.com.alura.model.NotaFiscal;

public class Processor {

	public static void emitir(NotaFiscal nf) {
		try {
			String name = Thread.currentThread().getName();
			System.out.println("Emitindo nota fiscal");
			Thread.sleep(5000);
			System.out.format("Nota fiscal emitida %nEm nome de %s %nNa data de %s %n",
					nf.getNome(), nf.getData());
			System.out.println("A thread do processor é: " + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
