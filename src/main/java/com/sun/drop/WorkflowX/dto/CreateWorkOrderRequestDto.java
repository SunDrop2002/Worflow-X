package com.sun.drop.WorkflowX.dto;

import com.sun.drop.WorkflowX.entities.Asset;
import com.sun.drop.WorkflowX.entities.User;
import com.sun.drop.WorkflowX.entities.enums.WorkOrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateWorkOrderRequestDto {
    @NotNull
    private Long assetId;

    @NotBlank
    private String description;

    @NotNull
    private Long assignedToUserId;

    @NotNull
    private WorkOrderStatus workOrderStatus;
}
