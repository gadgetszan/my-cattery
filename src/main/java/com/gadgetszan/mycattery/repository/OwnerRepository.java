package com.gadgetszan.mycattery.repository;

import com.gadgetszan.mycattery.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {

}
