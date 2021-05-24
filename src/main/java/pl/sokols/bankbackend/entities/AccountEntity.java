package pl.sokols.bankbackend.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "owner_surname", nullable = false)
    private String ownerSurname;

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private BankEntity bank;
}
