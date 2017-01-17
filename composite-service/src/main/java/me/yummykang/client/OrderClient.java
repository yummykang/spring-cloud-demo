package me.yummykang.client;

import me.yummykang.model.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/17 15:50
 */
@FeignClient(name="order-service")
public interface OrderClient {
    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Order getOrderDetail(@PathVariable("orderId") int orderId);
}
