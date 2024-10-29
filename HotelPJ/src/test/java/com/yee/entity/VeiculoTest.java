package com.yee.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yee.entities.Veiculo;

class VeiculoTest {

private Veiculo veiculo;
	
	//Arrange
	@BeforeEach
	void setUp() {
		veiculo = new Veiculo(1L, "marca","modelo","ano","cor");
	}
	
	
	
	@Test
	@DisplayName("Tstando o getter e setter do campo Id")
	void testId() {
		//Action
		veiculo.setId(2L);
		
		//Assert
		assertEquals(2L, veiculo.getId());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Nome")
	void testNome() {
		//Action
		veiculo.setMarca("2q");
		veiculo.setModelo("15");
		veiculo.setAno("5");
		veiculo.setCor("5");
		
		//Assert
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		//act
		Veiculo  novocliente = new Veiculo(3L, "cleiton","15996317887","49027741867","96520");
		//Assert
		assertAll("novocliente", 
				()-> assertEquals(3L, novocliente.getId()),
				()-> assertEquals("Matheus", novocliente.getMarca()),
				()-> assertEquals("Matheus", novocliente.getModelo()),
				()-> assertEquals("Matheus", novocliente.getAno()),
				()-> assertEquals("Matheus", novocliente.getCor())
				
				);
		
	}

};
