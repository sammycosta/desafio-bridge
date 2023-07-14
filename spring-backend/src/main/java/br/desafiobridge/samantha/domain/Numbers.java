package br.desafiobridge.samantha.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Numbers")
@Getter
@Setter
@NoArgsConstructor
public class Numbers {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Integer inputNumber;
	
	@Column
	private Integer resultNumber;
	
	@Column
	private Long calculationTime;

}

