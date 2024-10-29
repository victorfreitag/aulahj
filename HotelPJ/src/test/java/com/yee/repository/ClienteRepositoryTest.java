package com.yee.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.yee.entities.Cliente;

@DataJpaTest
class ClienteRepositoryTest {


	@Autowired
	private ClienteRepository ClienteRepository;
	
	@DisplayName("Tenstando Save")
	@Test
	void testSalvarRepositry() {
		
		//given / Arrange
		Cliente Cliente1 = new Cliente(null, "Joao","telefone","cpf","rg");
		
		//when / act
		Cliente saveCliente = ClienteRepository.save(Cliente1);
		
		//Then / Assert
		assertNotNull(saveCliente);
		assertTrue(saveCliente.getId() > 0);
		
	}
	
	@DisplayName("Tenstando Save")
	@Test
	void testGetAllRepository() {
		
		//given / Arrange
		Cliente Cliente1 = new Cliente(null, "Joao","telefone","cpf","rg");
		Cliente Cliente2 = new Cliente(null, "Joao","telefone","cpf","rg");
		
		//when / act
		ClienteRepository.save(Cliente1);
		ClienteRepository.save(Cliente2);
		
		List<Cliente> ClienteList = ClienteRepository.findAll();
		
		//Then / Assert
		assertNotNull(ClienteList);
		assertEquals(2, ClienteList.size());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testGetById() {
		
		//given / Arrange
		Cliente Cliente1 = new Cliente(null, "Joao","telefone","cpf","rg");
				
		//when / act
		ClienteRepository.save(Cliente1);
		
		Cliente saveCliente = ClienteRepository.findById(Cliente1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveCliente);
		assertEquals(Cliente1.getId(),saveCliente.getId());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testUpdateCliente() {
		
		//given / Arrange
		Cliente Cliente1 = new Cliente(null, "Joao","telefone","cpf","rg");
				
		//when / act
		ClienteRepository.save(Cliente1);
		
		Cliente saveCliente = ClienteRepository.findById(Cliente1.getId()).get();
		Cliente1.setNome("Joao");
		Cliente1.setTelefone("telrfone");
		Cliente1.setCpf("cpf");
		Cliente1.setRg("rg");
		
		Cliente updateCliente = ClienteRepository.save(saveCliente);
		//Then / Assert
		assertNotNull(updateCliente);
		assertEquals("2D", updateCliente.getNome());
		assertEquals("15", updateCliente.getTelefone());
		assertEquals("15", updateCliente.getCpf());
		assertEquals("15", updateCliente.getRg());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testDeleteCliente() {
		
		//given / Arrange
		Cliente Cliente1 = new Cliente(null, "Joao","telefone","cpf","rg");
				
		//when / act
		ClienteRepository.save(Cliente1);
		
		ClienteRepository.deleteById(Cliente1.getId());
		
		Optional<Cliente> ClienteOptional = ClienteRepository.findById(Cliente1.getId());
		//Then / Assert
		assertNotNull(ClienteOptional);

	}
	
	
	
	

}
