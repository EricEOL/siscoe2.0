package br.com.siscoe.siscoe.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.siscoe.siscoe.entities.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long>{

	Page<Building> findByCia(String cia, Pageable pageable);

}
