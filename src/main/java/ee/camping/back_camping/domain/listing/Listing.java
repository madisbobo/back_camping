package ee.camping.back_camping.domain.listing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "listing")
public class Listing {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 500)
    @NotNull
    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Size(max = 500)
    @Column(name = "additional_info", length = 500)
    private String additionalInfo;

    @NotNull
    @Column(name = "price", nullable = false)
    private Integer price;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

}