package com.stackroute.hackathon.test;

import static org.junit.Assert.*;

import org.apache.catalina.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.hackathon.HackathonSpringApplication;
import com.stackroute.hackathon.domain.UserProfile;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HackathonSpringApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserProfileControllerTest {
    String user1;
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    UserProfile user;
    UserProfile updatedUser;
    @Before
    public void setUp() throws Exception {
          user = new UserProfile(3,"Paul Dawson","Paul.Dawson@gmail.com");
          updatedUser = new UserProfile(3,"Paul Lawson","Paul.Lawson@gmail.com");
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSaveUser() throws Exception {
        HttpEntity<UserProfile> entity = new HttpEntity<UserProfile>(user, headers);
        
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/userprofile"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("user profile successfully added !",actual);
    }
    @Test
    public void testUserProfileList() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/userprofile"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
    @Test
    public void testGetUserProfile() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/userprofile/1"),
        HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
    @Test
    public void testUpdateUser() throws Exception {
    	 HttpEntity<UserProfile> entity = new HttpEntity<UserProfile>(updatedUser, headers);
         
         ResponseEntity<String> response = restTemplate.exchange(
         createURLWithPort("/userprofile/3"),
         HttpMethod.PUT, entity, String.class);
         assertNotNull(response);
         String actual = response.getBody();
         assertEquals(actual,"user profile successfully updated !");
        
    }
    @Test
    public void testDeleteUser() throws Exception {
    	HttpEntity<UserProfile> entity = new HttpEntity<UserProfile>(updatedUser, headers);
        
        ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/userprofile/3"),
        HttpMethod.DELETE, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        assertEquals(actual,"user successfully deleted !");
    	
    }
}