package com.symatique.SmartSoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symatique.SmartSoft.models.Utilisateur;
import com.symatique.SmartSoft.repository.UtilisateurRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UtilisateurRepository userRepository;

	@Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Utilisateur user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        
        if (!user.isActiver()) {
            throw new DisabledException("Ce compte utilisateur est désactivé.");
        }
        
        return UserDetailsImpl.build(user);
    }
}
