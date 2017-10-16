package com.stackroute.hackathon.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.stackroute.hackathon.domain.UserProfile;
import com.stackroute.hackathon.repository.UserProfileRepository;
import com.stackroute.hackathon.service.UserProfileService;

public class UserProfileMockService {
	
	
      UserProfile updatedUser;
      private UserProfileService userProfileService;
	    @Mock
	    private UserProfileRepository productrepository;
	    @Mock
	    private UserProfile product;
	    @Before
	    public void setupMock() {
	        MockitoAnnotations.initMocks(this);
	       userProfileService=new UserProfileService();
	        userProfileService.setUserprofileRepository(productrepository);
	    }
	    public UserProfileService getUsermockservice() {
			return userProfileService;
		}
		public void setUsermockservice(UserProfileService userProfileService) {
			this.userProfileService = userProfileService;
		}
		public UserProfileRepository getUserprofileRepository() {
			return productrepository;
		}
		public void setUserprofileRepository(UserProfileRepository productrepository) {
			this.productrepository = productrepository;
		}
		public UserProfile getProduct() {
			return product;
		}
		public UserProfile setProduct(UserProfile product2) {
			return this.product = product2;
		}
		@Test
	    public void shouldReturnProduct_whenGetProductByIdIsCalled() throws Exception {
	        // Arrange
	        when(productrepository.findOne(5)).thenReturn(product);
	        // Act
	        UserProfile retrievedProduct = userProfileService.getProductById(5);
	        // Assert
	        

	  }
	    private UserProfile getProductById(int i) {
			// TODO Auto-generated method stub
			return product;
		}
		@Test
	    public void shouldReturnProduct_whenSaveProductIsCalled() throws Exception {
	        // Arrange
	        when(productrepository.save(product)).thenReturn(product);
	        // Act
	        UserProfile savedProduct = userProfileService.setProduct(product);
	        // Assert
	       
	    }
	    @Test
	    public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
	        // Arrange
	        doNothing().when(productrepository).delete(5);
	        UserProfileRepository my = Mockito.mock(UserProfileRepository.class);
	        // Act
	        userProfileService.setProduct(updatedUser);
	        // Assert
	       
	    }
	}