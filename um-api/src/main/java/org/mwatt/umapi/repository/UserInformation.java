package org.mwatt.umapi.repository;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user_information")
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "user_type", nullable = false)
    private String userType;

    private Date birthday;

    @Column(nullable = false)
    private boolean deleted;

    @Column(nullable = false)
    private ZonedDateTime created;

    @Column(name = "last_modified", nullable = false)
    private ZonedDateTime lastModified;

    public UserInformation() {
    }

    @PrePersist
    void onPrePersist() {
        ZonedDateTime currentTime = ZonedDateTime.now();
        this.setCreated(currentTime);
        this.setLastModified(currentTime);
    }

    @PreUpdate
    void onPreUpdate() {
        this.setLastModified(ZonedDateTime.now());
    }
}
