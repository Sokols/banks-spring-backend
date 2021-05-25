package pl.sokols.bankbackend.configurations;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sokols.bankbackend.entities.UserEntity;
import pl.sokols.bankbackend.repositories.UserRepository;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity entity = userRepository.findByUsername(s);

        if (entity == null) {
            throw new UsernameNotFoundException("User " + s + " not found.");
        }

        return new AuthUser(entity);
    }
}
