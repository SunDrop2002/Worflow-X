package com.sun.drop.WorkflowX.repository;

import com.sun.drop.WorkflowX.dto.WorkOrderResponseDto;
import com.sun.drop.WorkflowX.entities.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkOrderRepository extends CrudRepository<WorkOrder, Long> {
    List<WorkOrder> findAll();
}
