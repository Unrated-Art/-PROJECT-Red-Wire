package com.saturne.redwire.resources;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.saturne.redwire.services.AuthService;
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

@RestController
@RequestMapping(path = "/api/auth")
public class AuthResource {

  // AIDES: https://www.javainuse.com/jwtgenerator

  private final AuthService authService;

  @Autowired
  public AuthResource(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping(path = "/logout", name = "auth.logout", consumes = MediaType.APPLICATION_JSON_VALUE)
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
    data.put("idStagiaire", "1");
    data.put("role", "STAGIAIRE");
    try {
      Algorithm algorithm = Algorithm.HMAC256("redwire");
      String token = JWT.create().withPayload(data).withIssuer("auth0").sign(algorithm);
      response.put("token", token);
    } catch (JWTCreationException exception) {
      System.out.println("Invalid Signing configuration / Couldn't convert Claims:\n" + exception.getMessage());
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

  @GetMapping(path = "/user", name = "auth.user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Map<String, String> user(@RequestBody String token) {
    //return Map.of();
    return null;
  }
}
