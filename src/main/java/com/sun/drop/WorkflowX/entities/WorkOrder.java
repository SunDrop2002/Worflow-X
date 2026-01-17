package com.sun.drop.WorkflowX.entities;

import com.sun.drop.WorkflowX.audits.Auditable;
import com.sun.drop.WorkflowX.entities.enums.WorkOrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class WorkOrder extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "work_order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private User assignedTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "work_order_status")
    @NotNull
    private WorkOrderStatus workOrderStatus;
}
