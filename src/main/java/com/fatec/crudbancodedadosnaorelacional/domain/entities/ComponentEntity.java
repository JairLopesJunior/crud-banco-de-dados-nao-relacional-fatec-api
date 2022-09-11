package com.fatec.crudbancodedadosnaorelacional.domain.entities;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "tb_component")
@TypeDef(
        name = "json",
        typeClass = JsonType.class
)
public class ComponentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "json")
    @Column(name = "component", columnDefinition = "json")
    private String component;
}
