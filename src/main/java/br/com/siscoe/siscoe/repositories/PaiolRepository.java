package br.com.siscoe.siscoe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.siscoe.siscoe.entities.Paiol;

@Repository
public interface PaiolRepository extends JpaRepository<Paiol, Long>{

}
