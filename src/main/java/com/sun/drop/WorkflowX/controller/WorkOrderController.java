package com.sun.drop.WorkflowX.controller;

import com.sun.drop.WorkflowX.dto.CreateUserRequestDto;
import com.sun.drop.WorkflowX.dto.CreateWorkOrderRequestDto;
import com.sun.drop.WorkflowX.dto.WorkOrderResponseDto;
import com.sun.drop.WorkflowX.entities.WorkOrder;
import com.sun.drop.WorkflowX.entities.enums.WorkOrderStatus;
import com.sun.drop.WorkflowX.service.WorkOrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workOrder")
public class WorkOrderController {
    private final WorkOrderService workOrderService;
    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }
    // get All work orders
    @GetMapping
    public ResponseEntity<List<WorkOrderResponseDto>>  getAllWorkOrders() {
        List<WorkOrderResponseDto> workOrders = workOrderService.getAllWorkOrders();
        return ResponseEntity.ok().body(workOrders);
    }
    @PostMapping
    public ResponseEntity<WorkOrderResponseDto> createWorkOrder(@Valid @RequestBody CreateWorkOrderRequestDto createWorkOrderRequestDto) {
        WorkOrderResponseDto workOrder = workOrderService.createWorkOrder(createWorkOrderRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(workOrder);
    }
    @GetMapping("{id}")
    public ResponseEntity<WorkOrderResponseDto> getWorkOrderById(@PathVariable Long id) {
        WorkOrderResponseDto workOrder = this.workOrderService.getWorkOrderById(id);
        return ResponseEntity.ok().body(workOrder);
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> setWorkOrderStatus(@RequestParam WorkOrderStatus status, @PathVariable Long id) {
        this.workOrderService.updateWorkOrderStatus(status,id);
        return ResponseEntity.noContent().build();
    }
}
