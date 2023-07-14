package br.desafiobridge.samantha.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NumbersServiceTest {

	@Autowired  private NumbersService numbersService;

	@Test
	void calculationTests() {
		var resultOne = numbersService.calculateResultNumber(5);
		assertThat(resultOne).isEqualTo(1);

		var resultTwo = numbersService.calculateResultNumber(24);
		assertThat(resultTwo).isEqualTo(3);

		var resultThree = numbersService.calculateResultNumber(30);
		assertThat(resultThree).isEqualTo(4);
	}
}
