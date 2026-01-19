package com.sun.drop.WorkflowX.service;

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
}