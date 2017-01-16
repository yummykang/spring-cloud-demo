package me.yummykang.model;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/16 17:02
 */
public class Order {
    private int orderId;

    private String memberName;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
