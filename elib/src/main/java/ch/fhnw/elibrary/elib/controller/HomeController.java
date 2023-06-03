package ch.fhnw.elibrary.elib.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Hidden;
//import java.security.Principal;

/* HomeController class copied from crm webservice project and adapted to elib
 author @michimel  */

@Hidden
@RestController
public class HomeController {

    // only for testing the apis, not implemented in budibase
    @GetMapping("/")
    public String getHello() {

        return "Hey there, welcome to the eLibrary of Reinach :)!";

    }

}