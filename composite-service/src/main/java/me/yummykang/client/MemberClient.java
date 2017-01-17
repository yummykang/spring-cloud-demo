package me.yummykang.client;

import me.yummykang.model.Member;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/4 14:26
 */
@FeignClient(name="member-service")
public interface MemberClient {
    @RequestMapping(value = "/members/{memberId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Member currentMember(@PathVariable("memberId") int memberId);
}
