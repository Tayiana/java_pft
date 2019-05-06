package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")

public class GroupContacts {

  @XStreamOmitField
  private int id =Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nick;
  private String company;
  private String address;
  private String home;
  private String mobile;
  private String work;
  private String allPhones;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;

  public File getPhoto() {
    return photo;
  }

  public GroupContacts withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  private File photo;

  public String getAllEmails() {
    return allEmails;
  }

  public GroupContacts withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public GroupContacts withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

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

  public GroupContacts withHomephone(String home) {
    this.home = home;
    return this;
  }
  public GroupContacts withMobilphone(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public GroupContacts withWorkphone(String work) {
    this.work = work;
    return this;
  }

  public GroupContacts withEmail(String email) {
    this.email = email;
    return this;
  }

  public GroupContacts withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public GroupContacts withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() { return id;
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

  public String getHome() { return home; }

  public String getMobile() { return mobile; }

  public String getWork() { return work; }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
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
