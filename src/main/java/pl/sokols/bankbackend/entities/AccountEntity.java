package pl.sokols.bankbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "owner_surname", nullable = false)
    private String ownerSurname;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private BankEntity bank;

    @Column(name = "user_id", nullable = false)
    private int userId;
}
