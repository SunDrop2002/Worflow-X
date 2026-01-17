package com.sun.drop.WorkflowX.entities;

import com.sun.drop.WorkflowX.entities.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    private String description;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private User assignedTo;

    private Status status;

    private LocalDateTime createdAt;
}
