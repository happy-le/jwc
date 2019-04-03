package com.ld.jwc.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author miaoguangqiang on 2019-04-03
 * @version 1.0
 */
@Getter
@Setter
public class User implements UserDetails {

    private Integer uid;

    private String username;

    private String password;

    private String college;

    private String major;

    private Integer userType;

    private Integer recordStatus;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        if (recordStatus == 0) {
            return true;
        }
        return false;
    }
}
