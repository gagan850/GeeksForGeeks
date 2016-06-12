package com.abc;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
public class HelloController {  
    @RequestMapping(value="/greeting")  
    public String helloWorld(Model model) {  
        String message = "HELLO SPRING MVC HOW R U";  
        model.addAttribute("greeting", message);
        return "hello";  
    }  
} 