package com.sun.drop.WorkflowX.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import com.sun.drop.WorkflowX.entities.enums.Status;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    private String location;

    private Status status;

    private LocalDateTime createdAt;
}
