package com.vavv.web.filter;

import com.vavv.web.Utilz;
import com.vavv.web.model.User;
import com.vavv.web.model.UserRole;
import com.vavv.web.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtCheckFilter implements Filter {

    private String jwtEncryptSecret;

    private UserRepository userRepository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("JwtCheckFilter happening..!!!: " + jwtEncryptSecret);
        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI();
        String authHeaderVal = ((HttpServletRequest) servletRequest).getHeader(Utilz.KR_AUTHORIZATION_HEADER);

        if (requestedUri.equalsIgnoreCase("/login/signin"))
            filterChain.doFilter(servletRequest, servletResponse);
        else if (!StringUtils.hasText(authHeaderVal)) // Auth header does not exist.
            writeErrorResponse(servletResponse, "Please Login");

        else {

            boolean jwtParsed = false;
            User userFromJwt = null;

            try {
                userFromJwt = Utilz.parseJwt(authHeaderVal, jwtEncryptSecret); // Parse JWT
                jwtParsed = true;
            } catch (Exception e) { // Expired or Bad JWT
                System.out.println("Bad JWT: " + e);
                writeErrorResponse(servletResponse, "Please Login");
            }

            if (jwtParsed) { // JWT parsed without errors

                User userFromRepo = userRepository.findFirstByGuid(userFromJwt.getGuid());
                if (userFromRepo == null || !StringUtils.hasText(userFromRepo.getUsername()))
                    writeErrorResponse(servletResponse, "Bad user"); // User does not exist in database.
                else {

                    if (userFromJwt.getRole().equals(UserRole.SUPER_ADMIN) || userFromJwt.getRole().equals(UserRole.GROUP_ADMIN)) {
                        servletRequest.setAttribute(Utilz.JWT_USER_PROP, userFromJwt);
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else if (requestedUri.contains("addOrder")) {
                        writeErrorResponse(servletResponse, "Bad Request");
                    } else {
                        servletRequest.setAttribute(Utilz.JWT_USER_PROP, userFromJwt);
                        filterChain.doFilter(servletRequest, servletResponse);
                    }

                }
            }
        }


    }

    private void writeErrorResponse(ServletResponse response, String error) throws IOException {
        JSONObject jo = new JSONObject();
        jo.put("success", false);
        jo.put("error", error);
        response.getWriter().write(jo.toJSONString());
    }


    @Override
    public void destroy() {

    }

    public void setJwtEncryptSecret(String jwtEncryptSecret) {
        this.jwtEncryptSecret = jwtEncryptSecret;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}

