package com.dashboard.backend.security;//package com.example.dashboard.employeedashboard.security;
//
//import com.example.dashboard.employeedashboard.util.UserUtils;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Service
//public class CustomLogoutHandler implements LogoutHandler {
//
//    private final UserCache userCache;
//
//    public CustomLogoutHandler(UserCache userCache) {
//        this.userCache = userCache;
//    }
//
//    @Override
//    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//        String userName = UserUtils.getAuthenticatedUserName();
//        userCache.evictUser(userName);
//    }
//}