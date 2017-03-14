package com.pedroaugust8.usercrud;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pedroaugust8.usercrud.User;
import com.pedroaugust8.usercrud.ErrorResponse;
import com.pedroaugust8.usercrud.UserException;

/**
 * @author Pedro Barros
 */
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserRest {
    private final UserRepository userRepository;

    @Autowired
    public UserRest(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> list() {
        return userRepository.list();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) throws UserException {
    		userRepository.save(user);
    		return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") final String id) throws UserException {
		userRepository.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") final String id) {
        return userRepository.get(id);
    }
    
    @ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}