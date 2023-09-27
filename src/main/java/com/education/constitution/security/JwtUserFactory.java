package com.education.constitution.security;

import com.education.constitution.model.Role;
import com.education.constitution.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create (User user){
        return new JwtUser(user.getId(), user.getUserName(), user.getPassword(), user.getName(), user.getEmail(), mapToGrantedAuthorities(user.getRoles()));

        }
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles){
        return roles.stream().map(role ->new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }
}
