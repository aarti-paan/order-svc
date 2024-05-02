package com.aartiworkspace.order.entity;

import com.aartiworkspace.order.dto.FoodItemDTO;
import com.aartiworkspace.order.dto.Restaurant;
import com.aartiworkspace.order.dto.UserDTO;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemList;
    private Restaurant restaurant;
    private UserDTO userDTO;
}
