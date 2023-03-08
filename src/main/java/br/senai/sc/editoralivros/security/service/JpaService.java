package br.senai.sc.editoralivros.security.service;

import br.senai.sc.editoralivros.model.entities.Pessoa;
import br.senai.sc.editoralivros.repository.PessoaRepository;
import br.senai.sc.editoralivros.security.users.UserJpa;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JpaService implements UserDetailsService {
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("chegou aq " + username);
        Optional<Pessoa> pessoaOptional = pessoaRepository.findByEmail(username);
        if (pessoaOptional.isPresent()) {
            System.out.println("a " + pessoaOptional.get());
            return new UserJpa(pessoaOptional.get());
        } else {
            pessoaOptional = pessoaRepository.findById(Long.parseLong(username));

            if (pessoaOptional.isPresent()) {
                return new UserJpa(pessoaOptional.get());
            }

            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
    }
}