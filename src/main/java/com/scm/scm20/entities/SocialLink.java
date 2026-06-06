package com.scm.scm20.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="social_links")
public class SocialLink {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="social_link_id")
    private Long id;

    @Column(length=2048)
    private String link;

    private String title;

    @ManyToOne
    private Contact contact;
}
