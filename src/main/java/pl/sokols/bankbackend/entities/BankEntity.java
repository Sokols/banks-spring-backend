package pl.sokols.bankbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "swift_code", nullable = false)
    private String swiftCode;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "bank_image_url")
    private String bankImageUrl;
}
