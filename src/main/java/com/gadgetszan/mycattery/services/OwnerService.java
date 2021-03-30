package com.gadgetszan.mycattery.services;

import com.gadgetszan.mycattery.exception.ResourceNotFoundException;
import com.gadgetszan.mycattery.model.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> getAllOwner();
    Owner getOwnerById(Long id) throws ResourceNotFoundException;
    Owner createOwner(Owner owner);
    Owner updateOwner(Long ownerId,Owner owner) throws ResourceNotFoundException;
    void deleteOwner(Long id) throws ResourceNotFoundException;
}
