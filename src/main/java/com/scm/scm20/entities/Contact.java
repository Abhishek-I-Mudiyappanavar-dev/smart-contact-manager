package com.scm.scm20.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="contact_id", updatable=false, nullable=false)
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Lob
    @Column(columnDefinition="TEXT")
    private String description;
    private boolean favorite=false;
    @Column(length=2048)
    private String websiteLink;
    @Column(length=2048)
    private String linkedInLink;
    //private List<String> socialLinks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy="contact", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<SocialLink> links = new ArrayList<>();

}
