package com.yee.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yee.entities.Produto;

class ProdutoTest {

private Produto produto;
	
	//Arrange
	@BeforeEach
	void setUp() {
		produto = new Produto(1L, "2q","15");
	}
	
	
	
	@Test
	@DisplayName("Tstando o getter e setter do campo Id")
	void testId() {
		//Action
		produto.setId(2L);
		
		//Assert
		assertEquals(2L, produto.getId());
	}
	@Test
	@DisplayName("Tstando o getter e setter do campo Nome")
	void testNome() {
		//Action
		produto.setNome("2q");
		produto.setPreco("15");
		
		//Assert
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		//act
		Produto  novoquarto = new Produto(3L, "3q","20");
		//Assert
		assertAll("novoquarto", 
				()-> assertEquals(3L, novoquarto.getId()),
				()-> assertEquals("Matheus", novoquarto.getNome()),
				()-> assertEquals("Matheus", novoquarto.getPreco())
				
				);
		
	}

};
