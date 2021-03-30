package com.gadgetszan.mycattery.services;

import com.gadgetszan.mycattery.exception.ResourceNotFoundException;
import com.gadgetszan.mycattery.model.CatInfo;

import java.util.List;

public interface CatInfoService {
    List<CatInfo> getAllCatInfo();
    CatInfo getCatInfoById(Long id) throws ResourceNotFoundException;
    CatInfo createCatInfo(Long ownerId,CatInfo catInfo) throws ResourceNotFoundException;
    List<CatInfo> getAllByOwner(Long ownerId)throws ResourceNotFoundException;
    CatInfo updateCatInfo(Long catInfoId,CatInfo catInfo) throws ResourceNotFoundException;
    void deleteCatInfo(Long catInfoId) throws ResourceNotFoundException;
}
