package me.yummykang.controller;

import me.yummykang.bean.Member;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/4 14:28
 */
@RestController
@RequestMapping("/members")
public class MemberController {

    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET)
    public Object currentMember(@PathVariable("memberId") int memberId) {
        if(memberId == 1) {
            return new Member(1, "demon, good job!!!");
        } else {
            return new Member(-1, "well, this is null guy!");
        }
    }
}
