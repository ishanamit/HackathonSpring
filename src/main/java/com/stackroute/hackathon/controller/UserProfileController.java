package com.stackroute.hackathon.controller;


import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.hackathon.domain.UserProfile;
import com.stackroute.hackathon.service.UserProfileService;
import com.stackroute.hackathon.validation.UserProfileValidator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;
    
    UserProfileValidator validator;
   @GetMapping("/userprofile")  /*mapping url to retrieve the userprofiles of the users*/
    public ResponseEntity<?> getAllUserProfile() {
        try
        {
        
        return new  ResponseEntity<List<UserProfile>>(userProfileService.getAllUserProfile(), HttpStatus.OK);
        }  
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<String>("No Content Found",HttpStatus.NO_CONTENT);
         }
        }
    @GetMapping("/userprofile/{id}")/*mapping url to retrieve the userprofiles of the users by id*/
    public ResponseEntity<?> getUser(@PathVariable int id) {
        try
        {
        return new ResponseEntity<UserProfile>(userProfileService.getUserProfileById(id), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<String>("No User Found",HttpStatus.NO_CONTENT);
        }
    }

     
   @PostMapping("/userprofile")/*mapping url to add the userprofiles of the users*/
    public ResponseEntity<String> addUser(@RequestBody UserProfile userProfile) {
        try
        {
        validator.validateUserEmail(userProfile.getEmailId());/*validation performed to check for null useremail and name*/
        validator.ValidateName(userProfile.getUserName());
        userProfileService.saveUserProfile(userProfile);
        return new ResponseEntity("user profile successfully added !", HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity("User already exist ",HttpStatus.CONFLICT);
        }
    }
        
   @PutMapping("/userprofile/{id}")/*mapping url to update/*mapping url to add the userprofiles of the users*/ 
    public ResponseEntity<String> updateRepos(@RequestBody UserProfile userProfile, @PathVariable int id) {
        try
        {
        validator.validateUserEmail(userProfile.getEmailId());
        validator.ValidateName(userProfile.getUserName());
        userProfileService.UpdateUserProfile(id, userProfile);
        return new ResponseEntity("user profile successfully updated !", HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity("No User Found",HttpStatus.NO_CONTENT);
        }
    }
        
       
   
   @DeleteMapping("/userprofile/{id}")/*mapping url to delete the userprofiles of the users*/
    public ResponseEntity<String> deleteUsers(@PathVariable int id,@RequestBody UserProfile userProfile) {
        try
        {
        userProfileService.deleteUserProfile(id);
        return new ResponseEntity("user successfully deleted !", HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity("No User Found",HttpStatus.NO_CONTENT);
        }
}
}