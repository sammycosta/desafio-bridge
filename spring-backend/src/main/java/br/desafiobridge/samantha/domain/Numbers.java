package br.desafiobridge.samantha.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Numbers")
public class Numbers {
	
	public Numbers() {
	}
	
	public Numbers(Integer inputNumber) {
		this.inputNumber = inputNumber;
	}
	
	@Id
	private Integer inputNumber;
	
	@Column
	private Integer resultNumber;
	
	public Integer CalculateResultNumber() {
		Integer auxiliar = 0;
		for(int n = 2; n < this.inputNumber; n = n+2 ) {
			Integer numberDivisorsOne = CalculatePositiveDivisors(n);
			Integer numberDivisorsTwo = CalculatePositiveDivisors(n+1);
			
			if(numberDivisorsOne == numberDivisorsTwo) {
				auxiliar++;
			}
		}
		setResultNumber(auxiliar);
		return auxiliar;
	}
	
	private Integer CalculatePositiveDivisors(Integer n) {
		Integer auxiliar = 0;
        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) {
                // If divisors are equal,
                // count only one
                if (n / i == i)
                    auxiliar++;
                else // Otherwise count both
                    auxiliar = auxiliar + 2;
            }
        }
		return auxiliar;
	}
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

