package com.sun.drop.WorkflowX.service;

import com.sun.drop.WorkflowX.entities.Asset;
import com.sun.drop.WorkflowX.entities.User;
import com.sun.drop.WorkflowX.entities.WorkOrder;
import com.sun.drop.WorkflowX.entities.enums.WorkOrderStatus;
import com.sun.drop.WorkflowX.repository.AssetRepository;
import com.sun.drop.WorkflowX.repository.UserRepository;
import com.sun.drop.WorkflowX.repository.WorkOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WorkOrderServiceTest {

    @InjectMocks
    private  WorkOrderService workOrderService;
    @Mock
    private  WorkOrderRepository workOrderRepository;
    @Mock
    private  AssetRepository assetRepository;
    @Mock
    private  UserRepository userRepository;

    @Test
    void updateWorkOrderStatus_ShouldNotThrowException() {
       when(workOrderRepository.setStatus(WorkOrderStatus.COMPLETED,1L)).thenReturn(1);
       Assertions.assertDoesNotThrow(() -> {
           this.workOrderService.updateWorkOrderStatus(WorkOrderStatus.COMPLETED,1L);
       });
       verify(workOrderRepository).setStatus(WorkOrderStatus.COMPLETED,1L);
    }

    @Test
    void updateWorkOrderStatusShouldThrowResponseStatusException() {
        when(workOrderRepository.setStatus(WorkOrderStatus.COMPLETED,100L)).thenReturn(0);
        Assertions.assertThrows(ResponseStatusException.class, () -> this.workOrderService.updateWorkOrderStatus(WorkOrderStatus.COMPLETED,100L));
        verify(workOrderRepository).setStatus(WorkOrderStatus.COMPLETED,100L);
    }

    //getWorkOrderById
    @Test
    void getWorkOrderById_ShouldReturnWorkOrderResponseDto() {
        User user = new User();
        user.setId(10L);
        Asset asset = new Asset();
        asset.setId(20L);
        WorkOrder workOrder = new WorkOrder();
        workOrder.setAsset(asset);
        workOrder.setAssignedTo(user);
        when(workOrderRepository.findById(1L)).thenReturn(Optional.of(workOrder));
        Assertions.assertNotNull(this.workOrderService.getWorkOrderById(1L));
        verify(workOrderRepository).findById(1L);
    }
    @Test
    void getWorkOrderById_ShouldThrowResponseStatusException() {
        when(workOrderRepository.findById(500L)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResponseStatusException.class, () -> this.workOrderService.getWorkOrderById(500L));
    }
}