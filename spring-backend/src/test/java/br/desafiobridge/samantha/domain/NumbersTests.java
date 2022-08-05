package br.desafiobridge.samantha.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NumbersTests {
	@Test
	public void TestOne() {
		Numbers number = new Numbers(Integer.valueOf(5));
		Integer resultNumber = number.CalculateResultNumber();
		assertThat(resultNumber).isEqualTo(Integer.valueOf(1));
	}
}
