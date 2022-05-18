package com.myleec.reactiveorder.service;

import com.myleec.reactiveorder.model.Dish;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class KitchenService {

    public Flux<Dish> getAllDishes() {
        return Flux.<Dish>generate(order -> order.next(randomPickDish())).delayElements(Duration.ofMillis(300));
    }

    private Dish randomPickDish() {
        Random random = new Random();
        int randomInt = random.nextInt(menu.size());
        return menu.get(randomInt);
    }

    private List<Dish> menu = Arrays.asList(
            new Dish("Kimchi ramen", 15.00, Instant.now(), false, 1000L),
            new Dish("Kimchi fried rice", 17.00, Instant.now(), false, 1001L),
            new Dish("Kimchi bulgogi", 25.00, Instant.now(), false, 1002L)
    );
}
