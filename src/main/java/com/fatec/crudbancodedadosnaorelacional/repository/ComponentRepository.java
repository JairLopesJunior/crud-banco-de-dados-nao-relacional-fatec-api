package com.fatec.crudbancodedadosnaorelacional.repository;

import com.fatec.crudbancodedadosnaorelacional.domain.entities.ComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends JpaRepository<ComponentEntity, Long> {

}
