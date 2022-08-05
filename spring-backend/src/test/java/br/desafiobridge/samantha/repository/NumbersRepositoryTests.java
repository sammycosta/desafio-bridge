package br.desafiobridge.samantha.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.desafiobridge.samantha.domain.Numbers;

@SpringBootTest
public class NumbersRepositoryTests {
	
	@Autowired
	private NumbersRepository numbersRepository;
	
	@Test
	public void inserir() {
		Numbers number = new Numbers(Integer.valueOf(5));
		number.CalculateResultNumber();
		numbersRepository.save(number);
	}
}
