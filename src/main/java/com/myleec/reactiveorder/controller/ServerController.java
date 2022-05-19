package com.myleec.reactiveorder.controller;

import com.myleec.reactiveorder.model.Dish;
import com.myleec.reactiveorder.service.KitchenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ServerController {

    private final KitchenService kitchenService;

    @GetMapping(value = "/orders", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> getDishes() {
        return kitchenService.getAllDishes();
    }

    @GetMapping(value = "/served-orders", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> getServedDishes() {
        return kitchenService.getAllDishes().map(Dish::deliver);
    }

}
