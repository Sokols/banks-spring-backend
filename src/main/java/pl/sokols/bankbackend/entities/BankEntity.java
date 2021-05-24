package pl.sokols.bankbackend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@Data
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
}
