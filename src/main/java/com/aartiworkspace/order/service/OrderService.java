package com.aartiworkspace.order.service;

import com.aartiworkspace.order.Mapper.OrderMapper;
import com.aartiworkspace.order.dto.OrderDTO;
import com.aartiworkspace.order.dto.OrderDTOFromFE;
import com.aartiworkspace.order.dto.UserDTO;
import com.aartiworkspace.order.entity.Order;
import com.aartiworkspace.order.repository.OrderRepo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;
    public OrderDTO saveOrderInDB(OrderDTOFromFE oderDetails) {

        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDetails = fetchUserDetailsFromUserId(oderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderId,oderDetails.getFoodItemList(), oderDetails.getRestaurant(), userDetails);
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId , UserDTO.class);
    }
}
