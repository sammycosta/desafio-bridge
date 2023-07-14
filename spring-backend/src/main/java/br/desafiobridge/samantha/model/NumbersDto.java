package br.desafiobridge.samantha.model;

import lombok.Data;

@Data
public class NumbersDto {

	private Long id;
	private Integer inputNumber;
	private Integer resultNumber;
	private Long calculationTime;

}
