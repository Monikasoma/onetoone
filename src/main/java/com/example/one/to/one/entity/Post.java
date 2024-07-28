package com.example.one.to.one.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @NotBlank
    @Size(max = 5000)
    @Column(name = "description", nullable = false, length = 5000)
    private String description;
}