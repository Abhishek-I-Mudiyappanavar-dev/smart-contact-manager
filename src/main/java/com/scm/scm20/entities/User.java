package com.scm.scm20.entities;

import jakarta.persistence.*;
import lombok.*;
import com.scm.scm20.entities.Providers;
import java.util.*;

@Entity(name="user")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

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
    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    @Enumerated(value=EnumType.STRING)
    @Builder.Default
    //SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Contact> contacts = new ArrayList<>();

}
