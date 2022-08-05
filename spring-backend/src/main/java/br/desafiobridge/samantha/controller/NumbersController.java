package br.desafiobridge.samantha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private NumbersRepository numbersRepository;
	
	@GetMapping
	public List<Numbers> getAll() {
		return numbersRepository.findAll();
	}
	
	@PostMapping
	public Numbers insertNumber(@RequestBody Numbers newNumbers) {
		newNumbers.CalculateResultNumber();
		numbersRepository.save(newNumbers);
		return newNumbers;
	}
	
	
}
