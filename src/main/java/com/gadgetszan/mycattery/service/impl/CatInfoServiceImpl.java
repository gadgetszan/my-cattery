package com.gadgetszan.mycattery.service.impl;

import com.gadgetszan.mycattery.exception.ResourceNotFoundException;
import com.gadgetszan.mycattery.model.CatInfo;
import com.gadgetszan.mycattery.model.Owner;
import com.gadgetszan.mycattery.repository.CatInfoRepository;
import com.gadgetszan.mycattery.repository.OwnerRepository;
import com.gadgetszan.mycattery.service.CatInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
@Transactional
public class CatInfoServiceImpl implements CatInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatInfoService.class);

    @Autowired
    CatInfoRepository catInfoRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public List<CatInfo> getAllCatInfo() {
        return catInfoRepository.findAll();
    }

    @Override
    public CatInfo getCatInfoById(Long catInfoId) throws ResourceNotFoundException {
        LOGGER.info("SERVICE: getting CatInfoById: " + catInfoId );
        return catInfoRepository.findById(catInfoId)
                .orElseThrow(()-> new RejectedExecutionException("Cat not found on this id ::" +catInfoId));
    }

    @Override
    public CatInfo createCatInfo(Long ownerId,CatInfo catInfo) throws ResourceNotFoundException {
        Owner owner = getOwnerById(ownerId);
        catInfo.setOwner(owner);
        LOGGER.info("SERVICE: creating catInfo: " + catInfo.toString() );
        return catInfoRepository.save(catInfo);
    }

    @Override
    public List<CatInfo> getAllByOwner(Long ownerId) throws ResourceNotFoundException {
        Owner owner = this.getOwnerById(ownerId);
        return catInfoRepository.findCatInfoByOwnerId(ownerId);
    }

    @Override
    public CatInfo updateCatInfo(Long catInfoId,CatInfo catInfo) throws ResourceNotFoundException {
        CatInfo catInfo1 = catInfoRepository.findById(catInfoId)
                .orElseThrow(() -> new ResourceNotFoundException("Cat not found for this id::" + catInfo.getId()));
        catInfo.setOwner(catInfo1.getOwner());
        return catInfoRepository.save(catInfo);
    }

    @Override
    public void deleteCatInfo(Long catInfoId) throws ResourceNotFoundException {
       CatInfo catInfo1 = catInfoRepository.findById(catInfoId)
                .orElseThrow(() -> new ResourceNotFoundException("Cat not found for this id::" + catInfoId));
        catInfoRepository.delete(catInfo1);
    }

    private Owner getOwnerById(Long ownerId) throws  ResourceNotFoundException{
        return ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found for this id :: " + ownerId));
    };
}
