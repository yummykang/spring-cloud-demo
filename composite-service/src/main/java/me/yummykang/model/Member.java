package me.yummykang.model;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/4 14:27
 */
public class Member {
    private Integer memberId;

    private String memberName;

    public Member() {
    }

    public Member(Integer memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
