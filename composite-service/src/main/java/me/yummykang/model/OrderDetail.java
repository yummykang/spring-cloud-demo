package me.yummykang.model;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/16 17:02
 */
public class OrderDetail {
    private Member member;

    private Order order;

    public OrderDetail() {
    }

    public OrderDetail(Member member, Order order) {
        this.member = member;
        this.order = order;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
