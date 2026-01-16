package com.sun.drop.WorkflowX.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String type;

    private String location;

    private String status;

    private LocalDateTime createdAt;
}
