package me.yummykang.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.yummykang.model.Order;
import me.yummykang.util.ServiceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.io.IOException;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/16 16:57
 */
@Component
public class OrderIntegration {

    private static final Logger LOG = LoggerFactory.getLogger(OrderIntegration.class);

    @Autowired
    ServiceUtils serviceUtils;

    @Autowired
    private RestOperations restTemplate;

    @HystrixCommand(fallbackMethod = "defaultOrder")
    public ResponseEntity<Order> getOrder(int orderId) throws IOException {

        ObjectReader objectReader = new ObjectMapper().readerFor(Order.class);

        LOG.debug("Will call getOrder with Hystrix protection");

        String url = "http://order-service/orders/" + orderId;
        LOG.debug("GetOrder from URL: {}", url);

        ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
        LOG.debug("GetOrder http-status: {}", resultStr.getStatusCode());
        LOG.debug("GetOrder body: {}", resultStr.getBody());

        Order order = objectReader.readValue(resultStr.getBody());
        LOG.debug("GetOrder.id: {}", order.getOrderId());

        return serviceUtils.createOkResponse(order);
    }

    /**
     * Fallback method for getOrder()
     *
     * @param orderId
     * @return
     */
    public ResponseEntity<Order> defaultOrder(int orderId) {
        LOG.warn("Using fallback method for product-service");
        return null;
    }
}
