package com.sun.drop.WorkflowX.entities;

import com.sun.drop.WorkflowX.audits.Auditable;
import com.sun.drop.WorkflowX.entities.enums.AssetStatus;
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
@Table(name = "assets")
public class Asset extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "asset_id")
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotBlank
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "asset_status")
    @NotNull
    private AssetStatus status;

}
