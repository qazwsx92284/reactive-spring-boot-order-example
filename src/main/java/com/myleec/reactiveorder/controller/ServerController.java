package com.myleec.reactiveorder.controller;

import com.myleec.reactiveorder.model.Dish;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ServerController {

    public Flux<Dish> getDishes() {

    }

}
