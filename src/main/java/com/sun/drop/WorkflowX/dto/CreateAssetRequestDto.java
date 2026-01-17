package com.sun.drop.WorkflowX.dto;

import com.sun.drop.WorkflowX.entities.enums.AssetStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAssetDto {
    @NotBlank
    String name;

    @NotBlank
    String type;

    @NotBlank
    String location;

    @NotNull
    AssetStatus status;
}
