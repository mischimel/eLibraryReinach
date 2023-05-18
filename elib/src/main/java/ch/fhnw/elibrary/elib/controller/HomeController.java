package ch.fhnw.elibrary.elib.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

import java.security.Principal;

@Hidden
@RestController
public class HomeController {

    // TODO: Check if this is needed, if yes update the Mapping
    /*
    @GetMapping("/home")
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }
    */

    @GetMapping("/")
    public String getHello() {  

        return "Hey there, welcome to the eLibrary of Reinach :)!";

    }

}