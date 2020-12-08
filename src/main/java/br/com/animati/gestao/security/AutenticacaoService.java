package br.com.animati.gestao.security;

import br.com.animati.gestao.DAO.UsuarioDAO;
import br.com.animati.gestao.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioDAO.findByLogin(login);

        if (usuario.isPresent())
            return usuario.get();

        throw new UsernameNotFoundException("Dados Inválidos");
    }


}
