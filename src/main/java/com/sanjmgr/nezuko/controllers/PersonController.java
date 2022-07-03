package com.sanjmgr.nezuko.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @GetMapping("/firstname")
    public List<String> firstname() {
        return List.of("Sanjay", "Nisan", "Pranil", "Shailesh", "Bipin", "Puzan");
    }
}
