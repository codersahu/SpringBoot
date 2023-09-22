package com.PMSystemBoot.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PMSystemBoot.Entity.PeopleEntity;

public interface PeopleRepository extends JpaRepository<PeopleEntity,UUID> {	

}

