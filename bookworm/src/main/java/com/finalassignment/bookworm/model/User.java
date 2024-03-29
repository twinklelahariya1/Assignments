package com.finalassignment.bookworm.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@SequenceGenerator(initialValue = 1, name = "sequence")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    @Size(max = 50)
    private String userName;

    @Column(name = "user_number")
    @NotNull
    private Long userContactNumber;


    @Column(name = "user_email", unique = true)
    @Size(max = 50)
    @Email
    private String userEmail;

    @Column(name = "user_password")
    @Size(max = 50)
    private String userPassword;

    @Column(name = "fine")

    int userTotalFineAmount;
}
