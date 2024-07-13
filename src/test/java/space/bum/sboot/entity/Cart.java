package space.bum.sboot.entity;

import java.util.Set;

import jakarta.persistence.OneToMany;

public class Cart {
  @OneToMany(mappedBy="cart")
  private Set<Item> items;
}
