package ee.camping.back_camping.domain.listing;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @Size(max = 255)
    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Column(name = "longitude", nullable = false, precision = 8, scale = 6)
    private BigDecimal longitude;

    @NotNull
    @Column(name = "latitude", nullable = false, precision = 8, scale = 6)
    private BigDecimal latitude;

}