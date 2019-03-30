package ru.stqa.pft.addressbook.model;

public class GroupContacts {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nick;
  private final String company;
  private final String address;
  private final String phone;
  private final String email;

  public GroupContacts(String firstname, String middlename, String lastname, String nick, String company, String address, String phone, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = nick;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.email = email;
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
}
