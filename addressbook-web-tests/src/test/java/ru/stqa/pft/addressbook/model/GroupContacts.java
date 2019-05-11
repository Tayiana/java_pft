package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class GroupContacts {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id =Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private String firstname;
  @Expose
  @Column(name = "middlename")
  private String middlename;
  @Expose
  @Column(name = "lastname")
  private String lastname;
  @Expose
  @Column(name = "nickname")
  private String nick;
  @Expose
  @Column(name = "company")
  private String company;
  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String home;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobile;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String work;
  @Expose
  @Transient
  private String allPhones;
  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;
  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;
  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;
  @Expose
  @Transient
  private String allEmails;
  @Transient
  private String photo;


  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setMiddlename(String middlename) {
    this.middlename = middlename;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setHome(String home) {
    this.home = home;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public void setWork(String work) {
    this.work = work;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setEmail2(String email2) {
    this.email2 = email2;
  }

  public void setEmail3(String email3) {
    this.email3 = email3;
  }



  public File getPhoto() {
    return new File(photo);
  }

  public GroupContacts withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }


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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupContacts contacts = (GroupContacts) o;
    return id == contacts.id &&
            Objects.equals(firstname, contacts.firstname) &&
            Objects.equals(middlename, contacts.middlename) &&
            Objects.equals(lastname, contacts.lastname) &&
            Objects.equals(nick, contacts.nick) &&
            Objects.equals(company, contacts.company) &&
            Objects.equals(address, contacts.address) &&
            Objects.equals(home, contacts.home) &&
            Objects.equals(mobile, contacts.mobile) &&
            Objects.equals(work, contacts.work) &&
            Objects.equals(email, contacts.email) &&
            Objects.equals(email2, contacts.email2) &&
            Objects.equals(email3, contacts.email3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, middlename, lastname, nick, company, address, home, mobile, work, email, email2, email3);
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
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", middlename='" + middlename + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nick='" + nick + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", home='" + home + '\'' +
            ", mobile='" + mobile + '\'' +
            ", work='" + work + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            '}';
  }
}
