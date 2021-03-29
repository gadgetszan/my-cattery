package com.gadgetszan.mycattery.controller;

import com.gadgetszan.mycattery.exception.ResourceNotFoundException;
import com.gadgetszan.mycattery.model.CatInfo;
import com.gadgetszan.mycattery.service.CatInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/catinfo/{ownerId}")
public class CatInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatInfoController.class);

    @Autowired
    CatInfoService catInfoService;

    //create
    @PostMapping("")
    public CatInfo createCatInfo(@PathVariable("ownerId") Long ownerId,
                                 @RequestBody CatInfo catInfo) throws ResourceNotFoundException {
        LOGGER.info("Controller: Creating Cat Info " + catInfo.toString());
        return catInfoService.createCatInfo(ownerId,catInfo);
    };


    //getById
    @GetMapping("/{id}")
    public ResponseEntity<CatInfo> getCatInfoById(
            @PathVariable(value="id") Long catInfoId) throws ResourceNotFoundException{
        LOGGER.info("Controller: Getting CatInfo by ID " + catInfoId);
        CatInfo catInfo = catInfoService.getCatInfoById(catInfoId);
        return ResponseEntity.ok().body(catInfo);
    }

    //getAll
    @GetMapping("/all")
    public List<CatInfo> getAllCatInfo(){
      return catInfoService.getAllCatInfo();
    };
    //getAllByOwner
    @GetMapping("")
    public List<CatInfo> getAllByOwner(@PathVariable("ownerId")
                                                   Long ownerId) throws ResourceNotFoundException{
        return catInfoService.getAllByOwner(ownerId);
    };

    //update
    @PutMapping("/{id}")
    public ResponseEntity<CatInfo> updateCatInfo(@PathVariable(value="id")
                                                    Long catInfoId
                                                    ,@RequestBody CatInfo catInfo )
                                                    throws  ResourceNotFoundException{
        return ResponseEntity.ok().body(catInfoService.updateCatInfo(catInfoId,catInfo));
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteCatInfo(@PathVariable(value="id") Long catInfoId)
            throws ResourceNotFoundException{
        catInfoService.deleteCatInfo(catInfoId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    };
}
