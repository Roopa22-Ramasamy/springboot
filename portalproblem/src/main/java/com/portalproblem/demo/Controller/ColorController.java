package com.portalproblem.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController 
{
        @GetMapping("/color")
        public String color(@RequestParam String color)
        {
        	return "My favorite color is "+color;
        }
}
