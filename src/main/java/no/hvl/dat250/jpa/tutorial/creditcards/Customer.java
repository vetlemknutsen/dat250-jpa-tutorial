package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    Set<Address> addresses = new HashSet<>();

    @ManyToMany
    Set<CreditCard> creditCards = new HashSet<>();

    public String getName() {
        return name;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }
}
