package me.yummykang.service.security;

import me.yummykang.domain.UserInfo;
import me.yummykang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2017/1/17 10:45
 */
@Service
public class MySQLUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        return user;
    }
}
