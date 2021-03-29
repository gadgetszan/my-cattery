package com.gadgetszan.mycattery.repository;

import com.gadgetszan.mycattery.model.CatInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatInfoRepository extends JpaRepository<CatInfo,Long> {
    List<CatInfo> findCatInfoByOwnerId(Long ownerId);
}
