package com.gadgetszan.mycattery.repository;

import com.gadgetszan.mycattery.model.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OwnerRepositoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerRepositoryTest.class);

    @Autowired
    private OwnerRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckCreatedOwner(){
        //given
        Owner owner = new Owner();
        owner.setFirstName("Rolan");
        owner.setLastName("Daniel");
        owner.setMiddleName("Caperina");
        owner.setAddress("Sta Rosa");
        owner.setContactNo("1234567");

        //when
        underTest.save(owner);
        List<Owner> owners = underTest.findAll();
        int size = owners.size();
        LOGGER.info("Size after Adding is: " + size);

        //then
        assertThat(size).isEqualTo(1);
    }
}
