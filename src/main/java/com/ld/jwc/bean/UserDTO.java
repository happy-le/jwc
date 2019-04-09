package com.ld.jwc.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @author miaoguangqiang on 2019-04-03
 * @version 1.0
 */
@Getter
@Setter
public class UserDTO implements UserDetails {

    private Long id;

    private String uid;

    private String username;

    private String password;

    private String college;

    private String major;

    private Byte userType;

    private Byte recordStatus;

    private Date createdAt;

    private Date updatedAt;


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
