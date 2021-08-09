package ua.com.mykolapylypenko.cooking_recipes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.mykolapylypenko.cooking_recipes.domain.entity.User;

@RestController
@RequestMapping("api/v1/users")
public class UserApiController {

    @GetMapping("{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId){

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
