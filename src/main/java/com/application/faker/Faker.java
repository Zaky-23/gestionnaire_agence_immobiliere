package com.application.faker;

import com.application.entities.Agent;
import com.application.entities.Client;
import com.application.entities.RealEstate;
import com.application.entities.Transaction;

import java.util.Vector;

public final class Faker {
  public static Vector<RealEstate> realEstates = new Vector<>();
  public static Vector<Client> clients = new Vector<>();
  public static Vector<Transaction> transactions = new Vector<>();
  public static Vector<Agent> agents = new Vector<>();

  static {
    agents.add(new Agent(0, "Zakarya", "Meddad", "0553997277"));
    agents.add(new Agent(1, "Mehdi", "Abane", "0532463943"));
    agents.add(new Agent(2, "Abdelhadi", "Kaddour", "053234697054"));
    agents.add(new Agent(3, "Walid", "Belkhir", "0523967402"));

    clients.add(new Client(1, "John", "Doe", "123-456-7890", "Regular"));
    clients.add(new Client(2, "Emily", "Chen", "555-123-4567", "Premium"));
    clients.add(new Client(3, "Michael", "Brown", "987-654-3210", "Regular"));
    clients.add(new Client(4, "Sarah", "Lee", "111-222-3333", "Premium"));
    clients.add(new Client(5, "William", "Davis", "444-555-6666", "Regular"));
    clients.add(new Client(6, "Olivia", "Miller", "777-888-9999", "Premium"));
    clients.add(new Client(7, "Benjamin", "Wilson", "222-333-4444", "Regular"));
    clients.add(new Client(8, "Ava", "Moore", "666-777-8888", "Premium"));
    clients.add(new Client(9, "Lucas", "Taylor", "999-111-2222", "Regular"));
    clients.add(new Client(10, "Isabella", "Anderson", "333-444-5555", "Premium"));

  }
}
