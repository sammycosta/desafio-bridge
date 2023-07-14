package br.desafiobridge.samantha.service;

import br.desafiobridge.samantha.domain.Numbers;
import br.desafiobridge.samantha.model.NumbersDto;
import br.desafiobridge.samantha.model.NumbersFormDto;
import br.desafiobridge.samantha.repository.NumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class NumbersService {

	@Autowired
	private NumbersRepository numbersRepository;

	public List<NumbersDto> loadNumbers() {
		List<Numbers> numbers = numbersRepository.findAll();
		List<NumbersDto> numbersDtos = new ArrayList<NumbersDto>();

		numbers.forEach((number) -> {
			// TODO: ESTUDAR MAPPING
			var numberDto = new NumbersDto();
			numberDto.setId(number.getId());
			numberDto.setInputNumber(number.getInputNumber());
			numberDto.setResultNumber(number.getResultNumber());
			numberDto.setCalculationTime(number.getCalculationTime());
			numbersDtos.add(numberDto);
		});

		return numbersDtos;
	}

	public NumbersDto saveNumber(NumbersFormDto numbersFormDto) {
		StopWatch timeMeasure = new StopWatch();
		timeMeasure.start("calculationTime");
		Integer result = calculateResultNumber(numbersFormDto.getNumber());
		timeMeasure.stop();

		Numbers number = new Numbers();
		number.setInputNumber(numbersFormDto.getNumber());
		number.setResultNumber(result);
		number.setCalculationTime(timeMeasure.getLastTaskTimeNanos());
		numbersRepository.save(number);

		var numberDto = new NumbersDto();
		numberDto.setId(number.getId());
		numberDto.setInputNumber(number.getInputNumber());
		numberDto.setResultNumber(number.getResultNumber());
		numberDto.setCalculationTime(number.getCalculationTime());
		return numberDto;
	}

	protected Integer calculateResultNumber(Integer inputNumber) {
		int auxiliar = 0;
		for(int n = 2; n < inputNumber; n++ ) {
			int numberDivisorsOne = calculatePositiveDivisors(n);
			int numberDivisorsTwo = calculatePositiveDivisors(n+1);

			if(numberDivisorsOne == numberDivisorsTwo) {
				auxiliar++;
			}
		}
		return auxiliar;
	}

	private Integer calculatePositiveDivisors(Integer n) {
		int auxiliar = 0;
		for (int i = 1; i <= Math.sqrt(n); i++)
		{
			if (n % i == 0) {
				if (n / i == i)
					auxiliar++;
				else
					auxiliar = auxiliar + 2;
			}
		}
		return auxiliar;
	}

}
