package br.desafiobridge.samantha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.desafiobridge.samantha.domain.Numbers;

@Repository
public interface NumbersRepository extends JpaRepository<Numbers, Long>{

}
