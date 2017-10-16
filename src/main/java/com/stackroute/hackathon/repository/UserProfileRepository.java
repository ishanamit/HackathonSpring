package com.stackroute.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.hackathon.domain.UserProfile;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile,Integer>{

}
