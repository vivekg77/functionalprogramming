package com.functionalprogramming.funcprog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/users")
public class UserRestController {

    @GetMapping(path="/mainuser")
    public String getUsers(@RequestBody User user){

        System.out.println(user.getName() + ":" + user.getGender());

return "Vivek";
    }
}
