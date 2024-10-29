package com.yee.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yee.entities.Cliente;

class ClienteTest {

private Cliente cliente;
	
	//Arrange
	@BeforeEach
	void setUp() {
		cliente = new Cliente(1L, "marcelo","telefone","cpf","rg");
	}
	
	
	
	@Test
	@DisplayName("Tstando o getter e setter do campo Id")
	void testId() {
		//Action
		cliente.setId(2L);
		
		//Assert
		assertEquals(2L, cliente.getId());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Nome")
	void testNome() {
		//Action
		cliente.setNome("2q");
		cliente.setTelefone("15");
		cliente.setCpf("5");
		cliente.setRg("5");
		
		//Assert
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		//act
		Cliente  novoquarto = new Cliente(3L, "cleiton","15996317887","49027741867","96520");
		//Assert
		assertAll("novoquarto", 
				()-> assertEquals(3L, novoquarto.getId()),
				()-> assertEquals("Matheus", novoquarto.getNome()),
				()-> assertEquals("Matheus", novoquarto.getTelefone()),
				()-> assertEquals("Matheus", novoquarto.getCpf()),
				()-> assertEquals("Matheus", novoquarto.getRg())
				
				);
		
	}

};
