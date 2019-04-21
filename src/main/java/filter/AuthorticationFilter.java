package filter;

import model.Role;
import model.User;
import service.IRoleService;
import service.impl.RoleService;
import utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorticationFilter implements Filter {

    private ServletContext context;
    private IRoleService roleService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        roleService = new RoleService();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        if (url.startsWith("/admin")) {
            User user = (User) SessionUtil.getSessionUtilIntance().getValue(request, "MODEL");
            if (user != null) {
                Role role = roleService.findRoleById(user.getRoleId());
                if (role.getRoleName().equals("ADMIN")) {
                    filterChain.doFilter(request, response);
                } else if (role.getRoleName().equals("USER")) {
                    response.sendRedirect(request.getContextPath() + "/login?message=notPermission");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "login?message=notLogin");
            }
        }else{
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
