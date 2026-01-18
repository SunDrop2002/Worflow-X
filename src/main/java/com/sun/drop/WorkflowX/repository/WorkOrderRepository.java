package com.sun.drop.WorkflowX.repository;

import com.sun.drop.WorkflowX.dto.WorkOrderResponseDto;
import com.sun.drop.WorkflowX.entities.WorkOrder;
import com.sun.drop.WorkflowX.entities.enums.WorkOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkOrderRepository extends CrudRepository<WorkOrder, Long> {
    List<WorkOrder> findAll();
    @Modifying
    @Query("UPDATE WorkOrder w SET w.workOrderStatus = :status WHERE w.id = :id")
    int setStatus(@Param("status") WorkOrderStatus status,@Param("id") Long id);
}
