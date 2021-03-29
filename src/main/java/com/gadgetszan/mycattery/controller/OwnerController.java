package com.gadgetszan.mycattery.controller;

import com.gadgetszan.mycattery.exception.ResourceNotFoundException;
import com.gadgetszan.mycattery.model.Owner;
import com.gadgetszan.mycattery.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerController.class);

    @Autowired
    OwnerService ownerService;

    @GetMapping("")
    public List<Owner> getOwner(){
      LOGGER.info("Controller: Getting All Owners");
      return ownerService.getAllOwner();
    };

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable(value="id")
                                              Long ownerId) throws ResourceNotFoundException{
        LOGGER.info("Controller: Getting by ID " + ownerId);
        Owner owner = ownerService.getOwnerById(ownerId);
        return ResponseEntity.ok().body(owner);
    };

    @PostMapping("")
    public Owner createOwner(@RequestBody Owner owner){
        LOGGER.info("Controller: CreatingOwner " + owner.toString());
        return ownerService.createOwner(owner);
    };

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable(value="id") Long ownerId,
                                             @RequestBody Owner ownerDetails) throws ResourceNotFoundException{
        LOGGER.info("Controller: updateOwner " + ownerDetails.toString());
        return ResponseEntity.ok().body( ownerService.updateOwner(ownerId,ownerDetails));
    };


    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteOwner(@PathVariable(value="id")
                                                       Long ownerId) throws ResourceNotFoundException{
        ownerService.deleteOwner(ownerId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    };

    @GetMapping("test")
    public void testLogging(){
        System.out.println("Test Rest ");
        LOGGER.info("Displaying in Console");
        LOGGER.trace("Testing Trace");
        LOGGER.warn("Testing logger in spring boot");
        LOGGER.debug("Debug Log");
    }
}
