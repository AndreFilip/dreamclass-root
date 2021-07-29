package com.andreas.filippatos.dreamclassbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @NotBlank(message = "Not empty date")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Not valid date")
    private String date;

    @NotBlank(message = "Not empty description")
    @Size(max = 100, message = "Max size description 100")
    private String description;

}
