package com.yee.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.yee.entities.Veiculo;

@DataJpaTest
class VeiculoRepositoryTest {


	@Autowired
	private VeiculoRepository VeiculoRepository;
	
	@DisplayName("Tenstando Save")
	@Test
	void testSalvarRepositry() {
		
		//given / Arrange
		Veiculo Veiculo1 = new Veiculo(null, "marca","modelo","ano","cor");
		
		//when / act
		Veiculo saveVeiculo = VeiculoRepository.save(Veiculo1);
		
		//Then / Assert
		assertNotNull(saveVeiculo);
		assertTrue(saveVeiculo.getId() > 0);
		
	}
	
	@DisplayName("Tenstando Save")
	@Test
	void testGetAllRepository() {
		
		//given / Arrange
		Veiculo Veiculo1 = new Veiculo(null, "marca","modelo","ano","cor");
		Veiculo Veiculo2 = new Veiculo(null, "marca","modelo","ano","cor");
		
		//when / act
		VeiculoRepository.save(Veiculo1);
		VeiculoRepository.save(Veiculo2);
		
		List<Veiculo> VeiculoList = VeiculoRepository.findAll();
		
		//Then / Assert
		assertNotNull(VeiculoList);
		assertEquals(2, VeiculoList.size());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testGetById() {
		
		//given / Arrange
		Veiculo Veiculo1 = new Veiculo(null, "marca","modelo","ano","cor");
				
		//when / act
		VeiculoRepository.save(Veiculo1);
		
		Veiculo saveVeiculo = VeiculoRepository.findById(Veiculo1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveVeiculo);
		assertEquals(Veiculo1.getId(),saveVeiculo.getId());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testUpdateVeiculo() {
		
		//given / Arrange
		Veiculo Veiculo1 = new Veiculo(null, "marca","modelo","ano","cor");
				
		//when / act
		VeiculoRepository.save(Veiculo1);
		
		Veiculo saveVeiculo = VeiculoRepository.findById(Veiculo1.getId()).get();
		Veiculo1.setMarca("2D");
		Veiculo1.setModelo("15");
		Veiculo1.setAno("15");
		Veiculo1.setCor("15");
		
		Veiculo updateVeiculo = VeiculoRepository.save(saveVeiculo);
		//Then / Assert
		assertNotNull(updateVeiculo);
		assertEquals("2D", updateVeiculo.getMarca());
		assertEquals("15", updateVeiculo.getModelo());
		assertEquals("15", updateVeiculo.getAno());
		assertEquals("15", updateVeiculo.getCor());
		
	}
	@DisplayName("Tenstando By ID")
	@Test
	void testDeleteVeiculo() {
		
		//given / Arrange
		Veiculo Veiculo1 = new Veiculo(null, "marca","modelo","ano","cor");
				
		//when / act
		VeiculoRepository.save(Veiculo1);
		
		VeiculoRepository.deleteById(Veiculo1.getId());
		
		Optional<Veiculo> VeiculoOptional = VeiculoRepository.findById(Veiculo1.getId());
		//Then / Assert
		assertNotNull(VeiculoOptional);

	}
	
	
	
	

}
