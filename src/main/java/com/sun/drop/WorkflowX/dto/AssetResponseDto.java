package com.sun.drop.WorkflowX.dto;

import com.sun.drop.WorkflowX.entities.User;
import com.sun.drop.WorkflowX.entities.enums.AssetStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AssetResponseDto {
    private Long id;
    private String name;
    private String type;
    private String location;
    private AssetStatus status;
    private LocalDateTime createdAt;
    private Long createdById;
}
