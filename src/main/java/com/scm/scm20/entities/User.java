package com.scm.scm20.entities;

import jakarta.persistence.*;
import lombok.*;

import com.scm.scm20.entities.Providers;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name="user")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", updatable = false, nullable = false)
    private String userId;

    @Column(name="name", nullable=false)
    private String name;

    @Column(unique = true, nullable=false)
    private String email;
    private String password;

    @Lob
    @Column(columnDefinition="TEXT")
    private String about;

    @Column(length=2048)
    private String profilePic;

    private String phoneNumber;
    
    //information
    private boolean enabled=true;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    @Enumerated(value=EnumType.STRING)
    @Builder.Default
    //SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Contact> contacts = new ArrayList<>();

    //Methods from UserDetails

    @ElementCollection(fetch=FetchType.EAGER)
    private List<String> roleList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // List of roles[USER,ADMIN]
        //collection of SimpleGrantedAuthority[roles{ADMIN,USER}]

        Collection<SimpleGrantedAuthority> roles = roleList.stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toList());

        return Collections.emptyList();
    }

    // for this project:
    // email id is considered as username

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
       return this.email;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return this.enabled;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

}
