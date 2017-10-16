package com.stackroute.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.hackathon.domain.UserProfile;
import com.stackroute.hackathon.repository.UserProfileRepository;

@Service
public class UserProfileService {
	@Autowired
	UserProfileRepository userProfileRepository;
	
	public List<UserProfile> getAllUserProfile() throws Exception{
		
		List<UserProfile> userProfile  = new ArrayList<>();
		userProfileRepository.findAll().forEach(userProfile::add);
		return userProfile;
		
	}
	public UserProfile getUserProfileById(int id) throws Exception{
		UserProfile user = userProfileRepository.findOne(id);
		if(user==null)
			throw new Exception();
		else
		 return userProfileRepository.findOne(id);
		
	}
	public void UpdateUserProfile(int id,UserProfile userProfile) throws Exception{
		UserProfile user = userProfileRepository.findOne(id);
		if(user==null)
			throw new Exception();
		else
		userProfileRepository.save(userProfile);
	}
	public void saveUserProfile(UserProfile userProfile) throws Exception{
		UserProfile user = userProfileRepository.findOne(userProfile.getId());
		if(user==null)
		userProfileRepository.save(userProfile);
		else throw new Exception();
	}
	public void deleteUserProfile(int id) throws Exception{
		UserProfile user = userProfileRepository.findOne(id);
		if(user==null) {
			throw new Exception();
		}
		else
		userProfileRepository.delete(id);
	}
	public void setUserprofileRepository(UserProfileRepository productrepository) {
		// TODO Auto-generated method stub
		
	}
	public UserProfile getProductById(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	public UserProfile setProduct(UserProfile product) {
		// TODO Auto-generated method stub
		return null;
	}
}
