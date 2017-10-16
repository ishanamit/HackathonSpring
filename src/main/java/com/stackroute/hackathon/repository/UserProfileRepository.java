package com.stackroute.hackathon.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.hackathon.domain.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile,Integer>{

}
