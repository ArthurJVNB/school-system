package com.project.schoolsystem.service.old;

import com.project.schoolsystem.model.old.Role;
import com.project.schoolsystem.model.old.User;
import com.project.schoolsystem.repository.old.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IUserRepository IUserRepository;

    @Autowired
    public UserDetailsServiceImpl(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = IUserRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
