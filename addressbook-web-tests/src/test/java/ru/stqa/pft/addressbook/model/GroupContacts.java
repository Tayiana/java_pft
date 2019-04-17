package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupContacts {


  private int id =Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private  String nick;
  private  String company;
  private  String address;
  private  String phone;

  public GroupContacts withId(int id) {
    this.id = id;
    return this;
  }

  public GroupContacts withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public GroupContacts withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public GroupContacts withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public GroupContacts withNick(String nick) {
    this.nick = nick;
    return this;
  }

  public GroupContacts withCompany(String company) {
    this.company = company;
    return this;
  }

  public GroupContacts withAddress(String address) {
    this.address = address;
    return this;
  }

  public GroupContacts withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public GroupContacts withEmail(String email) {
    this.email = email;
    return this;
  }

  private  String email;

  public void setId(int id) {
    this.id = id;
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
