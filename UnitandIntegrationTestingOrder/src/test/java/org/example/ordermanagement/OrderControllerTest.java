package org.example.ordermanagement;


import org.example.ordermanagement.data.Order;
import org.example.ordermanagement.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void testGetOrders() throws Exception {

        // Create some sample orders for testing
        mockMvc.perform(get("/api/orders/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddNewOrder() throws Exception {

        // Create a sample order for testing
        Order order = new Order();
        order.setOrderName("Test Order");

        mockMvc.perform(post("/api/orders/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderName\":\"Test Order\"}"))
                        .andExpect(status().isOk());
    }
}
