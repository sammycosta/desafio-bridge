package br.desafiobridge.samantha.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Numbers {
	
	public Numbers() {
	}
	
	public Numbers(Integer inputNumber, Integer resultNumber) {
		super();
		this.inputNumber = inputNumber;
		this.resultNumber = resultNumber;
	}
	
	@Id
	private Integer inputNumber;
	
	@Column
	private Integer resultNumber;

	public Integer getInputNumber() {
		return inputNumber;
	}
	public void setInputNumber(Integer inputNumber) {
		this.inputNumber = inputNumber;
	}
	public Integer getResultNumber() {
		return resultNumber;
	}
	public void setResultNumber(Integer resultNumber) {
		this.resultNumber = resultNumber;
	}
}
