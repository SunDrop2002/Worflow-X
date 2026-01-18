package com.sun.drop.WorkflowX.dto;

import com.sun.drop.WorkflowX.entities.enums.WorkOrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkOrderResponseDto {
    private Long assetId;
    private String description;
    private Long assignedToUserId;
    private WorkOrderStatus workOrderStatus;
}
