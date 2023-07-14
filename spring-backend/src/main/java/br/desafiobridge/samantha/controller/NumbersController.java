package br.desafiobridge.samantha.controller;

import java.util.List;

import br.desafiobridge.samantha.model.NumbersDto;
import br.desafiobridge.samantha.model.NumbersFormDto;
import br.desafiobridge.samantha.service.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.desafiobridge.samantha.domain.Numbers;
import br.desafiobridge.samantha.repository.NumbersRepository;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class NumbersController {

	@Autowired private NumbersService numbersService;

	@GetMapping
	public List<NumbersDto> indexNumbers() {
		return numbersService.loadNumbers();
	}
	
	@PostMapping
	public NumbersDto storeNumber(@RequestBody NumbersFormDto numbersFormDto) {
		return numbersService.saveNumber(numbersFormDto);
	}

}
