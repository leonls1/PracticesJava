package Leon.ejercicions.SecurityLearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controller-basic")
public class TestController {

    @GetMapping("/ejemplo1")
    public String showExample(){
        return "example 1";
    }
}
