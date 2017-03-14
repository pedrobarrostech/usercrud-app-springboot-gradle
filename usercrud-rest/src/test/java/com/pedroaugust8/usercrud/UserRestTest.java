package com.pedroaugust8.usercrud;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pedroaugust8.usercrud.User;
import com.pedroaugust8.usercrud.UserRepository;

public class UserRestTest {
	private UserRest target;
	private List<User> mockList;
	private UserRepository service;
	private List<User> actualList;

	@Before
	public void setup(){
		mockList = mock(List.class);
		
		service = mock(UserRepository.class);
		when(service.list()).thenReturn(mockList);
		
		target = new UserRest(service);
	}
	
	@Test
	public void save(){
		User User = new User();
		
		try {
			target.create(User);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		verify(service).save(User);
	}
	
	@Test
	public void list(){
		actualList = target.list();
		Assert.assertEquals(mockList, actualList);
	}
	
	
	/*@Test
	public void delete(){
		
		try {
			target.delete(actualList.get(0).getid());
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verify(service).delete(actualList.get(0).getid());
		
	}*/
	
	
	
	
	
}