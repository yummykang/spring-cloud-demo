package me.yummykang.controller;

import me.yummykang.bean.Order;
import me.yummykang.client.MemberClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/4 11:30
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private MemberClient memberClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object findOrders() {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Order order = new Order(i + 1, "O201701040000" + i, "订单" + i, new BigDecimal(new Random().nextDouble()));
            orders.add(order);
        }
        return orders;
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public Object orderDetail(@PathVariable("orderId") int orderId) {
        if (orderId == -1) {
            return "You just passed the error param!";
        } else {
            Map<Object, Object> result = new HashMap<>();
            result.put(memberClient.currentMember(1), new Order(1, "O2017010400001", "测试feign订单", new BigDecimal(1000)));
            return result;
        }
    }
}
