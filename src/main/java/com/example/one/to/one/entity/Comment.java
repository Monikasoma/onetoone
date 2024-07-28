package com.example.one.to.one.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank
    @Size(max = 1000)
    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}