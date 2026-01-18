package com.sun.drop.WorkflowX.mapper;

import com.sun.drop.WorkflowX.dto.WorkOrderResponseDto;
import com.sun.drop.WorkflowX.entities.WorkOrder;

public class WorkOrderMapper {
    public static WorkOrderResponseDto toDto(WorkOrder workOrder) {
        WorkOrderResponseDto workOrderResponseDto = new WorkOrderResponseDto();
        workOrderResponseDto.setAssetId(workOrder.getId());
        workOrderResponseDto.setDescription(workOrder.getDescription());
        workOrderResponseDto.setAssignedToUserId(workOrder.getAssignedTo().getId());
        workOrderResponseDto.setWorkOrderStatus(workOrder.getWorkOrderStatus());
        return workOrderResponseDto;
    }
}
