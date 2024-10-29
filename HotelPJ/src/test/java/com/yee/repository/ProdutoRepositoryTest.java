package com.yee.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.yee.entities.Produto;

@DataJpaTest
class ProdutoRepositoryTest {


	@Autowired
	private ProdutoRepository ProdutoRepository;
	
	@DisplayName("Tenstando Save")
	@Test
	void testSalvarRepositry() {
		
		//given / Arrange
		Produto Produto1 = new Produto(null, "Joao","15");
		
		//when / act
		Produto saveProduto = ProdutoRepository.save(Produto1);
		
		//Then / Assert
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);
		
	}
	
	@DisplayName("Tenstando Save")
	@Test
	void testGetAllRepository() {
		
		//given / Arrange
		Produto Produto1 = new Produto(null, "Joao","15");
		Produto Produto2 = new Produto(null, "Joao","15");
		
		//when / act
		ProdutoRepository.save(Produto1);
		ProdutoRepository.save(Produto2);
		
		List<Produto> ProdutoList = ProdutoRepository.findAll();
		
		//Then / Assert
		assertNotNull(ProdutoList);
		assertEquals(2, ProdutoList.size());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testGetById() {
		
		//given / Arrange
		Produto Produto1 = new Produto(null, "Joao","15");
				
		//when / act
		ProdutoRepository.save(Produto1);
		
		Produto saveProduto = ProdutoRepository.findById(Produto1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveProduto);
		assertEquals(Produto1.getId(),saveProduto.getId());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testUpdateProduto() {
		
		//given / Arrange
		Produto Produto1 = new Produto(null, "Joao","15");
				
		//when / act
		ProdutoRepository.save(Produto1);
		
		Produto saveProduto = ProdutoRepository.findById(Produto1.getId()).get();
		Produto1.setNome("Joao");
		Produto1.setPreco("15");
		
		Produto updateProduto = ProdutoRepository.save(saveProduto);
		//Then / Assert
		assertNotNull(updateProduto);
		assertEquals("Joao", updateProduto.getNome());
		assertEquals("15", updateProduto.getPreco());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testDeleteProduto() {
		
		//given / Arrange
		Produto Produto1 = new Produto(null, "Joao","joao@gmail.com");
				
		//when / act
		ProdutoRepository.save(Produto1);
		
		ProdutoRepository.deleteById(Produto1.getId());
		
		Optional<Produto> ProdutoOptional = ProdutoRepository.findById(Produto1.getId());
		//Then / Assert
		assertNotNull(ProdutoOptional);

	}
	
	
	
	

}
