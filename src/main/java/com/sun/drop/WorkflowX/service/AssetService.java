package com.sun.drop.WorkflowX.service;

import com.sun.drop.WorkflowX.dto.AssetResponseDto;
import com.sun.drop.WorkflowX.dto.CreateAssetRequestDto;
import com.sun.drop.WorkflowX.entities.Asset;
import com.sun.drop.WorkflowX.mapper.AssetMapper;
import com.sun.drop.WorkflowX.repository.AssetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    // get a list of Assets
    @Transactional(readOnly = true)
    public List<AssetResponseDto> getAllAssets() {
        return assetRepository.findAll().stream().map(AssetMapper::toDTO).toList();
    }

    // create an asset
    public AssetResponseDto createAsset(CreateAssetRequestDto assetDto) {

        Asset asset = new Asset();
        asset.setName(assetDto.getName());
        asset.setType(assetDto.getType());
        asset.setLocation(assetDto.getLocation());
        asset.setStatus(assetDto.getStatus());
        Asset newAsset = assetRepository.save(asset);
        return AssetMapper.toDTO(newAsset);
    }
}
