package com.saturne.redwire.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.saturne.redwire.services.AuthService;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthResource {

	private final AuthService authService;

	@Autowired
	public AuthResource(AuthService authService) {
		this.authService = authService;
	}

    @PostMapping(
        path = "/logout",
        name = "auth.logout",
		consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(@RequestBody HashMap<String, String> data) {
    	System.out.println(data);
    }

	@PostMapping(
        path = "/login",
        name = "auth.login",
		consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, String> login(@RequestBody HashMap<String, String> data) {
		Map<String, String> response = new HashMap<>();
		response.put("token", "SECRET");
		if (data.get("email").contains("admin@redwire.com")) {
			response.put("token", "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJmaXJzdE5hbWUiOiJBZG1pbiIsImxhc3ROYW1lIjoiTm9UaG9yIiwiZXhwIjoxNjY0MzcxNzU0LCJpYXQiOjE2NjE2OTMzNTR9.k05UJ2i35yCB3JL0lHjc7Insg4z_mCl6rfdqJveUEHQ");
		}
		if (data.get("email").contains("stag@redwire.com")) {
			response.put("token", "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiU3RhZ2lhaXJlIiwiZmlyc3ROYW1lIjoiU3RhaiIsImxhc3ROYW1lIjoiWSdhaXJlIiwiZXhwIjoxNjY0MzcxNzU0LCJpYXQiOjE2NjE2OTMzNTR9.Wz1Qze8cgRPpsiS03ji82rKoc0QW4rbV6GJzQCkw1h0");
		}
    	return response;
    }

    @PostMapping(
        path = "/register",
        name = "auth.register",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> register(@RequestBody HashMap<String, String> data) {
    	return data;
    }

    @GetMapping(
        path = "/user",
        name = "auth.user",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<String, String> user(@RequestBody String token) {
    	return Map.of();
    }
}
