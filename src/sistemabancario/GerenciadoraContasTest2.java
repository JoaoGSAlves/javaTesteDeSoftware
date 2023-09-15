package sistemabancario;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest2 {

	@Test
	public void testTransfereValor() {

		ContaCorrente conta01 = new ContaCorrente(1, 200, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);

		List<ContaCorrente> contasDoBanco = new ArrayList<ContaCorrente>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contasDoBanco);

		boolean resultadoTransferencia = gerContas.transfereValor(1, 200, 2);

		assertTrue(resultadoTransferencia);

	}

	@Test
	public void testCriarNegativo() {

		ContaCorrente conta01 = new ContaCorrente(1, -100, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);

		List<ContaCorrente> contasDoBanco = new ArrayList<ContaCorrente>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);

		GerenciadoraContas gerContas = new GerenciadoraContas(contasDoBanco);

		boolean resultadoTransferencia = gerContas.transfereValor(1, 200, 2);

		assertTrue(resultadoTransferencia);

	}
	@Test
	public void testCriarNegativoDuplo() {
		
		ContaCorrente conta01 = new ContaCorrente(1, -100, true);
		ContaCorrente conta02 = new ContaCorrente(2, -100, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<ContaCorrente>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contasDoBanco);
		
		boolean resultadoTransferencia = gerContas.transfereValor(1, 200, 2);
		
		assertTrue(resultadoTransferencia);
		
	}

}
