 package sistemabancario;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;;

public class GerenciadoraClientesTest3 {

	private GerenciadoraClientes gerClientes;

	private int idCliente01 = 1;
	private int idCliente02 = 2;

	@Before
	public void setUp() {
		Cliente cliente01 = new Cliente(idCliente01, "João da Silva", 20, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 18, "mariadasilva@gmail.com", 1, true);

		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@After
	public void tearDown() {
		gerClientes.limpa();
	}

	@Test
	public void testPesquisaCliente() {

		Cliente cliente = gerClientes.pesquisaCliente(1);

		assertThat(cliente.getId(), is(1));

	}

	public void testRemoveCliente() {

		boolean resultadoRemocaoCliente = gerClientes.removeCliente(2);

		assertThat(resultadoRemocaoCliente, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));

	}

	@Test
	public void testRemoveClienteInexistente() {

		boolean resultadoRemocaoCliente = gerClientes.removeCliente(10);

		assertThat(resultadoRemocaoCliente, is(false));
		assertFalse(resultadoRemocaoCliente);
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));

	}

	@Test
	public void testPesquisaClienteInexistente() {
		Cliente cliente = gerClientes.pesquisaCliente(13);

		assertNull(cliente);
	}
	
	@Test
	public void testClienteIdadePermitida1() throws IdadeNaoPermitidaException{
		//Montagem
		Cliente cliente = new Cliente(3, "Daniel", 30, "daniel@gmail.com", 3, true);
		//Execução
		boolean resultado = gerClientes.validaIdade(cliente.getIdade());
		//Verificação
		assertTrue(resultado);
	}
	
	@Test
	public void testClienteIdadePermitida2() throws IdadeNaoPermitidaException{
		//Montagem
		Cliente cliente = new Cliente (2, "Marcos", 15, "marcos@gmail.com", 2, true );
		//Execução
		boolean resultado = gerClientes.validaIdade(cliente.getIdade());
		//Verificação
		assertTrue(resultado);
		
	}
	@Test
	public void testClienteIdadePermitida3() throws IdadeNaoPermitidaException{
		//Montagem
		Cliente cliente = new Cliente (3, "Leandro", 15, "leandroFigueiras@outlook.com", 3, true );
		//Execução
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
		
	}
	@Test
	public void testClienteIdadePermitida4() throws IdadeNaoPermitidaException{
		//Montagem
		Cliente cliente = new Cliente (4, "Aldenor", 95, "aldenorFarias1234@gmail.com", 4, true );
		//Execução
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
		
	}

}
