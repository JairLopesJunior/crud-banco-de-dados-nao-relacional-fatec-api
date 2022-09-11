package com.fatec.crudbancodedadosnaorelacional.controller;

import com.fatec.crudbancodedadosnaorelacional.domain.entities.ComponentEntity;
import com.fatec.crudbancodedadosnaorelacional.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/components")
public class ComponentController {

    private final ComponentService componentService;

    @PostMapping
    public ComponentEntity save(@RequestBody ComponentEntity entity) {
        return this.componentService.save(entity);
    }

    @GetMapping
    public List<ComponentEntity> getAll() {
        return this.componentService.findAll();
    }
}
