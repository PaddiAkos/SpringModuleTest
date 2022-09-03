package app.services;

import app.models.Officer;
import app.repositories.OfficerRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PrePersist;

@Service
public class OfficerService implements UserDetailsService {

    private final OfficerRepo officerRepo;


    public OfficerService(OfficerRepo officerRepo) {
        this.officerRepo = officerRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Officer officer = officerRepo.findAllByUsername(username);
        if (username == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new Officer();
    }

}

