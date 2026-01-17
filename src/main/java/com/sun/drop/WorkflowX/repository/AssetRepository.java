package com.sun.drop.WorkflowX.repository;

import com.sun.drop.WorkflowX.entities.Asset;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssetRepository extends CrudRepository<Asset,Long> {
    List<Asset> findAll();
    Asset findById(long id);
}
