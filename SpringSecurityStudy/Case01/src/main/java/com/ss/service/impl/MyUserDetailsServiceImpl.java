package com.ss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ss.entity.UserEntity;
import com.ss.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", s);
        UserEntity userEntity = userMapper.selectOne(wrapper);

        if(userEntity == null) {
            throw  new UsernameNotFoundException("找不到User");
        }



        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(userEntity.getUserName(), new BCryptPasswordEncoder().encode(userEntity.getUserPassword()), auths);
    }
}
