package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.ToOne;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Range(min = 1, max = 20)
    @NotNull
    private Integer quantity;

    @NotEmpty
    @ManyToMany
    private List<Category> categories;

    @NotNull
    @ManyToOne
    private Institution institution;

    @NotBlank(message = "{street.message}")
    private String street;

    @NotBlank
    private String city;

    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    @NotNull
    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    @NotNull
    private LocalDate pickUpDate;

    @NotNull
    private LocalTime pickUpTime;

    private String pickUpComment;


}
