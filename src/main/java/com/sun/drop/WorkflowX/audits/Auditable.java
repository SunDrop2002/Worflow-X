package com.sun.drop.WorkflowX.audits;

import com.sun.drop.WorkflowX.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class Auditable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="created_by_id",updatable = false)
    @CreatedBy
    protected User createdBy;

    @CreatedDate
    protected LocalDateTime createdAt;
}
