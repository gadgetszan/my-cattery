package com.gadgetszan.mycattery.services.impl;

import com.gadgetszan.mycattery.model.Owner;
import com.gadgetszan.mycattery.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    @Mock private OwnerRepository ownerRepository;
    private OwnerServiceImpl underTest;

    @BeforeEach
    void setUp(){
        underTest = new OwnerServiceImpl(ownerRepository);
    }

    @Test
    void canGetAllOwners(){
        //53.22
        //when
        underTest.getAllOwner();
        //then
        verify(ownerRepository).findAll();
    }

    @Test
    void canAddOwner(){
        //59:38
        //given
        Owner owner = new Owner();
        owner.setFirstName("TestFname");
        owner.setLastName("TestLname");
        owner.setMiddleName("TestMname");
        owner.setAddress("TestAddress");
        owner.setContactNo("testNumber");

        //when
        underTest.createOwner(owner);

        //then
        ArgumentCaptor<Owner> ownerArgumentCaptor =
                ArgumentCaptor.forClass(Owner.class);

        //we want to verify the the repository had been saved
        //we want to capture this value ownerArgumentCaptor.capture()
        verify(ownerRepository).save(ownerArgumentCaptor.capture());
        Owner capturedOwner = ownerArgumentCaptor.getValue();
        assertThat(capturedOwner).isEqualTo(owner);
    }


}