package com.sun.drop.WorkflowX.mapper;

import com.sun.drop.WorkflowX.dto.AssetResponseDto;
import com.sun.drop.WorkflowX.entities.Asset;
import com.sun.drop.WorkflowX.entities.User;
import com.sun.drop.WorkflowX.repository.AssetRepository;
import com.sun.drop.WorkflowX.repository.UserRepository;

import java.util.Optional;

public class AssetMapper {
    public static AssetResponseDto toDTO(Asset asset) {
        AssetResponseDto  assetResponseDto = new AssetResponseDto();
        assetResponseDto.setId(asset.getId());
        assetResponseDto.setName(asset.getName());
        assetResponseDto.setType(asset.getType());
        assetResponseDto.setLocation(asset.getLocation());
        assetResponseDto.setStatus(asset.getStatus());
        assetResponseDto.setCreatedAt(asset.getCreatedAt());
        assetResponseDto.setCreatedById(asset.getId());
        return assetResponseDto;
    }

}
