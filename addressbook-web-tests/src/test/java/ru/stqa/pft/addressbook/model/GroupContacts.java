package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupContacts {
  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nick;
  private final String company;
  private final String address;
  private final String phone;
  private final String email;

  public GroupContacts(int id,String firstname, String middlename, String lastname, String nick, String company, String address, String phone, String email) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = nick;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  public GroupContacts( String firstname, String middlename, String lastname, String nick, String company, String address, String phone, String email) {
    this.id = 0;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = nick;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNick() {
    return nick;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }


  @Override
  public String toString() {
    return "GroupContacts{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupContacts that = (GroupContacts) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

}
