package org.example.ordermanagement;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.example.ordermanagement.data.Order;
import org.example.ordermanagement.data.OrderRepository;
import org.example.ordermanagement.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testAddNewOrder() {
        // Create a sample order for testing
        Order order = new Order();
        // Assuming some setup for order

        // Mock the behavior of orderRepository.save() to return the saved order
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        // Call the method under test
        orderService.addNewOrder(order);

        // Verify that orderRepository.save() was called exactly once with the provided order
        verify(orderRepository, times(1)).save(order);
    }
}
