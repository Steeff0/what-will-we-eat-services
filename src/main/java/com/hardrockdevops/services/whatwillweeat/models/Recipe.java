package com.hardrockdevops.services.whatwillweeat.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length=80, nullable=false, unique=false)
    private String name;

    @OneToMany(mappedBy="recipe")
    private List<Ingredient> ingredients;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private User creator;

    @Column(nullable=false)
    private ZonedDateTime created;

    private int feedPeople;

    @Basic
    private Duration prepTime;

    @Enumerated(EnumType.STRING)
    private Kitchen kitchen;
}
