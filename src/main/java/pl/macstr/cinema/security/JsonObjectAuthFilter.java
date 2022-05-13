package pl.macstr.cinema.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonObjectAuthFilter extends UsernamePasswordAuthenticationFilter {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            BufferedReader reader = request.getReader();
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                builder.append(line);
            }
            LoginCredentials credentials = mapper.readValue(builder.toString(), LoginCredentials.class);
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(
                            credentials.getUsername(), credentials.getPassword()
                    );
            setDetails(request, token);
            return this.getAuthenticationManager().authenticate(token);
        }catch (IOException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
