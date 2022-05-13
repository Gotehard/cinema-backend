package pl.macstr.cinema.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.macstr.cinema.service.TokenService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Value("${jwt.token.key}")
    String key;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        clearAuthenticationAttributes(request);
        UserDetails pricipal = (UserDetails) authentication.getPrincipal();
        String token = TokenService.createToken(pricipal.getUsername(), key);
        String refreshToken = TokenService.createRenewToken(pricipal.getUsername(), key);
        response.setHeader("Content-Type", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.getOutputStream().print("{\"token\":\"" + token + "\",\"refreshToken\":\"" + refreshToken + "\"}");
    }
}
