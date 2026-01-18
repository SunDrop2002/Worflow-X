package com.sun.drop.WorkflowX.service;

import com.sun.drop.WorkflowX.dto.CreateWorkOrderRequestDto;
import com.sun.drop.WorkflowX.dto.WorkOrderResponseDto;
import com.sun.drop.WorkflowX.entities.Asset;
import com.sun.drop.WorkflowX.entities.User;
import com.sun.drop.WorkflowX.entities.WorkOrder;
import com.sun.drop.WorkflowX.entities.enums.WorkOrderStatus;
import com.sun.drop.WorkflowX.mapper.WorkOrderMapper;
import com.sun.drop.WorkflowX.repository.AssetRepository;
import com.sun.drop.WorkflowX.repository.UserRepository;
import com.sun.drop.WorkflowX.repository.WorkOrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WorkOrderService {
    private final WorkOrderRepository workOrderRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;
    public WorkOrderService(WorkOrderRepository workOrderRepository, AssetRepository assetRepository, UserRepository userRepository) {
        this.workOrderRepository = workOrderRepository;
        this.assetRepository = assetRepository;
        this.userRepository =  userRepository;
    }
    // Get all work orders
    public List<WorkOrderResponseDto> getAllWorkOrders() {
        return this.workOrderRepository.findAll().stream().map(WorkOrderMapper::toDto).toList();
    }
    // Create a work Order
    public WorkOrderResponseDto createWorkOrder(CreateWorkOrderRequestDto createWorkOrderRequestDto) {
        WorkOrder workOrder = new WorkOrder();
        Asset asset = this.assetRepository
                .findById(createWorkOrderRequestDto.getAssetId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Asset not found"));
        if (createWorkOrderRequestDto.getAssignedToUserId() != null) {
            User user = this.userRepository
                    .findById(createWorkOrderRequestDto.getAssignedToUserId())
                    .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
            workOrder.setAssignedTo(user);
        } else {
            workOrder.setAssignedTo(null);
        }
        workOrder.setAsset(asset);
        workOrder.setDescription(createWorkOrderRequestDto.getDescription());
        workOrder.setWorkOrderStatus(createWorkOrderRequestDto.getWorkOrderStatus());
        WorkOrder newWorkOrder = this.workOrderRepository.save(workOrder);
        return WorkOrderMapper.toDto(newWorkOrder);
    }

    //Get Work order by Id
    @Transactional(readOnly = true)
    public WorkOrderResponseDto getWorkOrderById(Long id) {
        WorkOrder  workOrder = workOrderRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"WorkOrder not found"));
        return WorkOrderMapper.toDto(workOrder);
    }
    // Update Work order status
    @Transactional
    public void updateWorkOrderStatus(WorkOrderStatus status, Long id) {
        int updated = this.workOrderRepository.setStatus(status,id);
        if (updated == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"WorkOrder not found");
        }
    }
}
