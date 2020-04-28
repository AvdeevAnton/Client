package net.javaguides.springboot.tutorial.controller;


import jdk.nashorn.internal.parser.Token;
import net.javaguides.springboot.tutorial.entity.User;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import javax.servlet.http.Cookie;

@RestController
@RequestMapping("/restUsers/")
@CrossOrigin(origins = "*")
public class RestUserController {


    @GetMapping("/userRestList")
    public ResponseEntity<List<User>> getRestUserList(RestTemplate restTemplate,@RequestHeader (name="Authorization") String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<List<User>> rateResponse =
                restTemplate.exchange("http://localhost:8090/userRestList",
                        HttpMethod.GET, entity, new ParameterizedTypeReference<List<User>>() {
                        });
        List<User> result = rateResponse.getBody();
        return new ResponseEntity<List<User>>(result, HttpStatus.OK);
    }


    @GetMapping("/userRest/{id}")
    public ResponseEntity<User> getRestUserById(@PathVariable long id,User user, RestTemplate restTemplate,@RequestHeader (name="Authorization") String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<User> requestEntity = new HttpEntity<>(user,headers);
        ResponseEntity<User> rateResponse =
                restTemplate.exchange("http://localhost:8090/userRest/" + id,
                        HttpMethod.GET, requestEntity, new ParameterizedTypeReference<User>() {
                        });
        return new ResponseEntity<User>(rateResponse.getBody(), HttpStatus.OK);
    }

    @PostMapping("/userRest/save")
    public ResponseEntity<User> saveOrUpdateRestUser(@RequestBody User user, RestTemplate restTemplate,@RequestHeader (name="Authorization") String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<User> requestEntity = new HttpEntity<>(user,headers);
        ResponseEntity<User> rateResponse =
                restTemplate.exchange("http://localhost:8090/userRest/save",
                        HttpMethod.POST, requestEntity, new ParameterizedTypeReference<User>() {
                        });
        return new ResponseEntity<User>(rateResponse.getBody(), HttpStatus.OK);
    }


    @PutMapping("/userRest/update/{id}")
    public ResponseEntity<User> updateRestUser(@PathVariable("id") long id, @RequestBody User user, RestTemplate restTemplate,@RequestHeader (name="Authorization") String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<User> requestEntity = new HttpEntity<>(user,headers);
        ResponseEntity<User> rateResponse =
                restTemplate.exchange("http://localhost:8090/userRest/update/" + id,
                        HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<User>() {
                        });
        return new ResponseEntity<User>(rateResponse.getBody(), HttpStatus.OK);
    }

    @DeleteMapping("/userRest/delete/{id}")
    public ResponseEntity<Void> deleteRestUser(@PathVariable long id, User user, RestTemplate restTemplate,@RequestHeader (name="Authorization") String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<User> requestEntity = new HttpEntity<>(user,headers);
        ResponseEntity<User> rateResponse =
                restTemplate.exchange("http://localhost:8090/userRest/delete/" + id,
                        HttpMethod.DELETE, requestEntity, new ParameterizedTypeReference<User>() {
                        });
        return new ResponseEntity<Void>(HttpStatus.OK);

    }


    @PostMapping("/loginToken")
    public ResponseEntity<String> loginRestUser(@RequestBody User user, RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("username", user.getUsername());
        map.add("password", user.getPassword());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( "http://localhost:8090/login", request, String.class );
        return new ResponseEntity<String>(response.getHeaders(),HttpStatus.OK);
    }
}
