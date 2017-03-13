/* package com.pedroaugust8.usercrud;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pedroaugust8.usercrud.UserRest;

import static org.mockito.Mockito.*;

public class MovieResourceTest {
	private MovieService movieService;
	private List<Movie> mockList;
	private MovieResource target;
	
	@Before
	public void setUp(){
		mockList = (List<Movie>) mock(List.class);
		movieService = mock(MovieService.class);
		
		when(movieService.list()).thenReturn(mockList);
		
		target = new MovieResource(movieService);
	}
	
	@Test
	public void save(){
		Movie movie = new Movie();
		
		target.save(movie);
		
		verify(movieService).addMovie(movie);
	}
	
	@Test
	public void list(){
		List<Movie> actualList = target.list();
		
		Assert.assertEquals(mockList, actualList);
	}
}

*/