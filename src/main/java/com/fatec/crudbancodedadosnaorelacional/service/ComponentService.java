package com.fatec.crudbancodedadosnaorelacional.service;

import com.fatec.crudbancodedadosnaorelacional.domain.entities.ComponentEntity;
import com.fatec.crudbancodedadosnaorelacional.exceptions.NotFoundException;
import com.fatec.crudbancodedadosnaorelacional.repository.ComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComponentService {

    private final ComponentRepository componentRepository;

    public ComponentEntity save(ComponentEntity componentEntity) {
        return this.componentRepository.save(componentEntity);
    }

    public List<ComponentEntity> findAll() {
        return this.componentRepository.findAll();
    }

    public void deleteById(Long id) {
        ComponentEntity componentEntityFound = this.componentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Component not found."));
        this.componentRepository.deleteById(componentEntityFound.getId());
    }
}
