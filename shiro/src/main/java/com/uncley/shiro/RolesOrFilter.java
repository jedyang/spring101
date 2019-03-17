package com.uncley.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 和授权相关的继承AuthorizationFilter
// 和用户认证相关的继承AuthenticatingFilter

/**
 * 自定义过滤器
 * 使用或的功能
 * 默认的roles=[xx,yy]是且的要求
 */
public class RolesOrFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        String[] roles = (String[]) o;//o就是传进来的roles=[xx,yy]中的权限列表
        if (roles == null || roles.length == 0){
            return true;
        }
        for (String role : roles){
            if (subject.hasRole(role)){
                return true;
            }
        }

        return false;
    }
}
