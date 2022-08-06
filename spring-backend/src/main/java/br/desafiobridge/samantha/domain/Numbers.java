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
	
	public Numbers(int inputNumber) {
		this.inputNumber = inputNumber;
	}
	
	@Id
	private int inputNumber;
	
	@Column
	private int resultNumber;
	
	private long calculationTime;
	
	public int CalculateResultNumber() {
		int auxiliar = 0;
		for(int n = 2; n < this.inputNumber; n++ ) {
			int numberDivisorsOne = CalculatePositiveDivisors(n);
			int numberDivisorsTwo = CalculatePositiveDivisors(n+1);
			
			if(numberDivisorsOne == numberDivisorsTwo) {
				auxiliar++;
			}
		}
		setResultNumber(auxiliar);
		return auxiliar;
	}
	
	private int CalculatePositiveDivisors(int n) {
		int auxiliar = 0;
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
	public int getInputNumber() {
		return inputNumber;
	}
	public void setInputNumber(int inputNumber) {
		this.inputNumber = inputNumber;
	}
	public int getResultNumber() {
		return resultNumber;
	}
	public void setResultNumber(int resultNumber) {
		this.resultNumber = resultNumber;
	}

	public long getCalculationTime() {
		return calculationTime;
	}

	public void setCalculationTime(long calculationTime) {
		this.calculationTime = calculationTime;
	}
}

