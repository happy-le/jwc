package com.ld.jwc.util;

import com.ld.jwc.bean.UserDTO;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author miaoguangqiang on 2019-04-03
 * @version 1.0
 */
public class Util {
    public static UserDTO getCurrentUser() {
        UserDTO user = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
