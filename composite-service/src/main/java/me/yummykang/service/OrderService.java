package me.yummykang.service;

import me.yummykang.client.MemberClient;
import me.yummykang.client.OrderClient;
import me.yummykang.model.Member;
import me.yummykang.model.Order;
import me.yummykang.model.OrderDetail;
import me.yummykang.util.ServiceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/17 9:02
 */
@RestController
@RequestMapping("/order-details")
public class OrderService {
    private Logger LOG = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    OrderIntegration integration;

    @Autowired
    ServiceUtils utils;

    @Autowired
    MemberClient memberClient;

    @Autowired
    OrderClient orderClient;

    @PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
    @RequestMapping("/{memberId}/{orderId}")
    public ResponseEntity<OrderDetail> getOrderAsync(@PathVariable int memberId, @PathVariable int orderId) throws ExecutionException, InterruptedException {
        LOG.info("Asynch start...");

        CompletableFuture<Order> orderFuture = CompletableFuture.supplyAsync(() -> orderClient.getOrderDetail(orderId));
        CompletableFuture<Member> memberFuture = CompletableFuture.supplyAsync(() -> memberClient.currentMember(memberId));

        LOG.info("Asynch, allOf.join...");
        CompletableFuture.allOf(orderFuture, memberFuture).join();

        LOG.info("Asynch, create result and return...");
        return utils.createOkResponse(new OrderDetail(memberFuture.get(), orderFuture.get()));
    }

//    private Order getOrderInfo(@PathVariable int orderId) {
//        Order order = null;
//        try {
//            ResponseEntity<Order> orderResult = integration.getOrder(orderId);
//            if (!orderResult.getStatusCode().is2xxSuccessful()) {
//                LOG.debug("call to getOrder failed:{}", orderResult.getStatusCode());
//            } else {
//                order = orderResult.getBody();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return order;
//    }
//
//    private Member getMember(int memberId) {
//        Member member = null;
//        try {
//            ResponseEntity<Member> memberResult = integration.getMember(memberId);
//            if (!memberResult.getStatusCode().is2xxSuccessful()) {
//                LOG.debug("call to getOrder failed:{}", memberResult.getStatusCode());
//            } else {
//                member = memberResult.getBody();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return member;
//    }
}
