package com.sun.drop.WorkflowX.controller;

import com.sun.drop.WorkflowX.dto.AssetResponseDto;
import com.sun.drop.WorkflowX.dto.CreateAssetRequestDto;
import com.sun.drop.WorkflowX.mapper.AssetMapper;
import com.sun.drop.WorkflowX.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private AssetService assetService;
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public ResponseEntity<List<AssetResponseDto>>  getAllAssets() {
        List<AssetResponseDto> assets = this.assetService.getAllAssets();
        return ResponseEntity.ok().body(assets);

    }

    @PostMapping
    public ResponseEntity<AssetResponseDto>  createAsset(@Valid @RequestBody CreateAssetRequestDto createAssetRequestDto) {
        AssetResponseDto assetResponseDto = this.assetService.createAsset(createAssetRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(assetResponseDto);
    }

}
