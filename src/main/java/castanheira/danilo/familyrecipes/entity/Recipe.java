package castanheira.danilo.familyrecipes.entity;

import castanheira.danilo.familyrecipes.enums.Difficulty;
import castanheira.danilo.familyrecipes.enums.FoodCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private LocalDate registrationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Source source;

    @Enumerated(EnumType.STRING)
    private FoodCategory category;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String ingredients;

    private String makes;

    private String cooksIn;

    private String wayOfDoing;

    private String tips;
}
