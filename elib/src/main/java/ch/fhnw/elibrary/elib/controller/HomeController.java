package ch.fhnw.elibrary.elib.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Hidden;
//import java.security.Principal;

/* HomeController class copied from crm webservice project and adapted to elib
 author @michimel  */

@Hidden
@RestController
public class HomeController {

    // TODO: Check if this is needed, if yes update the Mapping
    /*
     * @GetMapping("/home")
     * public String home(Principal principal) {
     * return "Hello, " + principal.getName();
     * }
     */

    @GetMapping("/")
    public String getHello() {

        return "Hey there, welcome to the eLibrary of Reinach :)!";

    }

}