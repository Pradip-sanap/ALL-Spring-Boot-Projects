package com.Inazuma.learn.controller;

import com.Inazuma.learn.baens.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
@RequiredArgsConstructor
public class TestController {

    private final OrderService orderService;

    @GetMapping()
    public String testingCode(){
        orderService.placeOrder();
        orderService.check();
        return "Success";
    }

}
