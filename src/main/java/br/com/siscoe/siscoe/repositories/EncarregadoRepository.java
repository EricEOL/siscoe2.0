package br.com.siscoe.siscoe.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.siscoe.siscoe.entities.Encarregado;

@Repository
public interface EncarregadoRepository extends JpaRepository<Encarregado, Long>{

	public Optional<Encarregado> findByName(String name);
	
	public Encarregado getByName(String name);

	public Page<Encarregado> findByCia(String cia, Pageable pageable);
	
}
