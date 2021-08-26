package com.andreas.filippatos.dreamclassbackend.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "dreamClassUsers")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    public String role;

    @ManyToMany(mappedBy = "authorities")
    private Set<DreamClassUser> dreamClassUsers;
}
