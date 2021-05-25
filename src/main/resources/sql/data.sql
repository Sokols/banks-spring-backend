INSERT INTO bank (id, bank_name, country_code, swift_code) values (1, "12341234", "PL", "TEST")
INSERT INTO bank (id, bank_name, country_code, swift_code) values (2, "123412341234", "EN", "TEST2")

INSERT INTO account (id, account_number, owner_name, owner_surname, bank_id) values (1, "12341234", "Igor", "Sokół", 1)
INSERT INTO account (id, account_number, owner_name, owner_surname, bank_id) values (2, "56785678", "Adam", "Abacki", 2)
