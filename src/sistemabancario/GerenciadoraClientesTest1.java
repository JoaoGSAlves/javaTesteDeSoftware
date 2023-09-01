package sistemabancario;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;;


/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre clinetes, realizadas pela classe {@link GerenciadoraClientes}
 * 
 * @author Clayton Chagas
 * @date 18/08/2023
 * 
 */
public class GerenciadoraClientesTest1 {
	
	/**
	 * Teste basico da pesquisa de um cliente a partir do seu ID
	 * 
	 * @author Clayton Chagas
	 * @date 18/08/2023
	 */
	
	@Test
	public void testPesquisaCliente() {
		/*=====Montagem do cenário de teste=====*/
		//criando alguns clientes
		Cliente cliente01 = new Cliente(1, "João da Silva", 20, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Maria da Silva", 18, "mariadasilva@gmail.com", 1, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/*=====Execução do Teste=====*/
		
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		/*=====Verificação e Avaliação do Teste=====*/
		
		assertThat(cliente.getId(),is(1));
		
	}
	
	public void testRemoveCliente() {
		
		Cliente cliente01 = new Cliente(1,"João da Silva",20,"joaadasilva@gmail.com",1,true);
		Cliente cliente02 = new Cliente(2,"Maria de Souza",19,"mdesouza@gmail.com",1,true);
		
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		boolean resultadoRemocaoCliente= gerClientes.removeCliente(2);
			
		assertThat(resultadoRemocaoCliente, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
		
		
	}
	
}

