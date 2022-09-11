package com.fatec.crudbancodedadosnaorelacional.service;

import com.fatec.crudbancodedadosnaorelacional.domain.entities.ComponentEntity;
import com.fatec.crudbancodedadosnaorelacional.exceptions.NotFoundException;
import com.fatec.crudbancodedadosnaorelacional.repository.ComponentRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComponentService {

    private final ComponentRepository componentRepository;

    public ComponentEntity save(ComponentEntity entity) {
        String convertedComponent = this.convertJsonToString(entity.getComponent());
        entity.setComponent(convertedComponent);
        return this.componentRepository.save(entity);
    }

    public List<ComponentEntity> findAll() {
        return this.componentRepository.findAll();
    }

    public void deleteById(Long id) {
        ComponentEntity componentEntityFound = findById(id);
        this.componentRepository.deleteById(componentEntityFound.getId());
    }

    public ComponentEntity update(ComponentEntity entity) {
        ComponentEntity componentEntityFound = findById(entity.getId());
        String convertedJson = this.convertJsonToString(entity.getComponent());
        componentEntityFound.setComponent(convertedJson);
        ComponentEntity savedComponent = this.componentRepository.save(componentEntityFound);
        String convertedString = this.convertStringToJson(savedComponent.getComponent());
        savedComponent.setComponent(convertedString);
        return savedComponent;
    }

    private ComponentEntity findById(Long id) {
        return this.componentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Component not found."));
    }

    private String convertJsonToString(String component) {
        return new Gson().toJson(component);
    }

    private String convertStringToJson(String component) {
        return new Gson().fromJson(component, String.class);
    }
}
