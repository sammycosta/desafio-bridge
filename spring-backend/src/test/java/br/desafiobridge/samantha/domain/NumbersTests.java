package br.desafiobridge.samantha.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NumbersTests {
	@Test
	public void TestOne() {
		Numbers number = new Numbers(5);
		int resultNumber = number.CalculateResultNumber();
		assertThat(resultNumber).isEqualTo(1);
	}
	
	@Test
	public void TestTwo() {
		Numbers number = new Numbers(24);
		int resultNumber = number.CalculateResultNumber();
		assertThat(resultNumber).isEqualTo(3);
	}
	
	@Test
	public void TestThree() {
		Numbers number = new Numbers(30);
		int resultNumber = number.CalculateResultNumber();
		assertThat(resultNumber).isEqualTo(4);
	}
}
