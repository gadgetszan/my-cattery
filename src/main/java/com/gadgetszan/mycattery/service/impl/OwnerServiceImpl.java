package com.gadgetszan.mycattery.service.impl;

import com.gadgetszan.mycattery.exception.ResourceNotFoundException;
import com.gadgetszan.mycattery.model.Owner;
import com.gadgetszan.mycattery.repository.OwnerRepository;
import com.gadgetszan.mycattery.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerService.class);

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public List<Owner> getAllOwner() {
        LOGGER.debug("SERVICE: Getting All Owner");
        return ownerRepository.findAll();
    }

    @Override
    public Owner getOwnerById(Long id) throws ResourceNotFoundException {
        LOGGER.info("SERVICE: Getting Owner By Id: " + id);
        return ownerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                "Owner not found for this id: " + id));
    }

    @Override
    public Owner createOwner(Owner owner) {
        LOGGER.info("SERVICE: creating owner: " + owner.toString() );
        return ownerRepository.save(owner);
    }

    @Override
    public Owner updateOwner(Long ownerId,Owner owner) throws ResourceNotFoundException {
        LOGGER.debug("SERVICE: updating owner: " + owner.toString() );
        Owner newOwner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found for this id :: " + ownerId));
        newOwner.setAddress(owner.getAddress());
        newOwner.setContactNo(owner.getContactNo());
        newOwner.setFirstName(owner.getFirstName());
        newOwner.setLastName(owner.getLastName());
        newOwner.setMiddleName(owner.getMiddleName());
        LOGGER.info("SERVICE: updated owner: " + owner.toString() );
        return ownerRepository.save(newOwner);
    }

    @Override
    public void deleteOwner(Long ownerId) throws ResourceNotFoundException {
        LOGGER.debug("SERVICE: deleting owner: " + ownerId );
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found for this id :: " + ownerId));
        ownerRepository.delete(owner);
        LOGGER.info("SERVICE: deleted owner: " + ownerId );
    }
}
