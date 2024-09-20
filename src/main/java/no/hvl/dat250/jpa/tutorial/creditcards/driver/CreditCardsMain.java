package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
      em.clear();
    }

  }

  private static void createObjects(EntityManager em) {

    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    Bank bank = new Bank();
    bank.setName("Pengebank");

    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    CreditCard creditCard1 = new CreditCard();
    creditCard1.setPincode(pincode);
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10000);
    creditCard1.setBank(bank);

    CreditCard creditCard2 = new CreditCard();
    creditCard2.setPincode(pincode);
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);
    creditCard2.setBank(bank);

    address.addOwner(customer);

    customer.addCreditCard(creditCard1);
    customer.addCreditCard(creditCard2);

    em.persist(customer);
    em.persist(bank);
    em.persist(pincode);
    em.persist(creditCard1);
    em.persist(creditCard2);
    em.persist(address);

  }
}
