package br.com.animati.gestao.security;

import br.com.animati.gestao.DAO.UsuarioDAO;
import br.com.animati.gestao.entity.Usuario;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthByTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuarioDAO usuarioDAO;

    public AuthByTokenFilter(TokenService tokenService, UsuarioDAO usuarioDAO) {
        this.tokenService = tokenService;
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(httpServletRequest);
        boolean valido = tokenService.isTokenValido(token);
        System.out.println(token);
        System.out.println(valido);
        if(valido){
            autenticarCliente(token);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void autenticarCliente(String token) {
        Long idUsuario = tokenService.getIsUsuario(token);
        Usuario usuario = usuarioDAO.findById(idUsuario).get();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }

}
