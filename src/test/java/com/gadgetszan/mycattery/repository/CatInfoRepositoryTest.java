package com.gadgetszan.mycattery.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CatInfoRepositoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatInfoRepositoryTest.class);

    @Autowired
    private CatInfoRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    @Disabled
    void itshouldCheckFindCatInfoByOwnerId(){
        int size = 0;
        assertThat(size).isEqualTo(0);
    }

}