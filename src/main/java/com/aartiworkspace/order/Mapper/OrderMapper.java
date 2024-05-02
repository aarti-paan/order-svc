package com.aartiworkspace.order.Mapper;

import com.aartiworkspace.order.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.aartiworkspace.order.entity.Order;
@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);

}
