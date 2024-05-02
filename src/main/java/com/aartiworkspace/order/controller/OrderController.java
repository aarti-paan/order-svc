package com.aartiworkspace.order.controller;

import com.aartiworkspace.order.dto.OrderDTO;
import com.aartiworkspace.order.dto.OrderDTOFromFE;
import com.aartiworkspace.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(path = "/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE oderDetails){
        OrderDTO orderSavedInDb = orderService.saveOrderInDB(oderDetails);
        return new ResponseEntity<>(orderSavedInDb, HttpStatus.CREATED);
    }
}
