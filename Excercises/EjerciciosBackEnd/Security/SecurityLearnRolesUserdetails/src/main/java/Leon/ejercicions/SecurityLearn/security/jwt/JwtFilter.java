package Leon.ejercicions.SecurityLearn.security.jwt;

import Leon.ejercicions.SecurityLearn.security.user.UserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private  JwtUtils jwtUtils;
    @Autowired
    private  UserDetailService userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            //getting the token from the request
            String token = parseJwt(request);
//validate if the token isn't null and if it's a valid token
            if (token != null && jwtUtils.validateToken(token)) {
                String username = jwtUtils.extractUsername(token);
                //creating a userDetails with the username of the token
                UserDetails userDetails = userDetailService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, userDetails.getPassword(), userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        //first getting the header
        String headerAuth = request.getHeader("Authorization");
        //looking if it isn't empty and starts with 'Bearer'
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            //skipping the first 7 chars('Bearer ')
            return headerAuth.substring(7);
        }
        return null;
    }
}
