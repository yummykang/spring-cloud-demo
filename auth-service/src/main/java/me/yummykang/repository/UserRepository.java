package me.yummykang.repository;

import me.yummykang.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/17 10:43
 */
@Repository
public interface UserRepository extends CrudRepository<UserInfo, Integer> {
    UserInfo findByUsername(String userName);
}
