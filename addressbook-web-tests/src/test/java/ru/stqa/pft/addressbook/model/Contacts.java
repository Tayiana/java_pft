package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<GroupContacts> {

  private Set<GroupContacts> delegate;

  public Contacts (Contacts groups) {
    this.delegate = new HashSet<GroupContacts>(groups.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<GroupContacts>();
  }

  public Contacts(Collection<GroupContacts> contacts) {
    this.delegate = new HashSet<GroupContacts>(contacts);
  }


  @Override
  protected Set<GroupContacts> delegate() {
    return delegate;
  }


  public Contacts withAdded(GroupContacts contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts without(GroupContacts contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }

}
