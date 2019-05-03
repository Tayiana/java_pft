package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.GroupContacts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<GroupContacts> groups = generateGroups(count);
    save(groups, file);
  }

  private static void save(List<GroupContacts> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (GroupContacts group : groups) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", group.getFirstname(), group.getMiddlename(), group.getLastname(),group.getNick(), group.getCompany(), group.getAddress(),group.getHome(),group.getMobile(), group.getWork(), group.getEmail(),group.getEmail2(), group.getEmail3()));
    }
    writer.close();
  }

  private static List<GroupContacts> generateGroups(int count) {
    List<GroupContacts> groups = new ArrayList<GroupContacts>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupContacts().withFirstname(String.format("firstname %s", i))
              .withMiddlename(String.format("middlename %s", i)).withLastname(String.format("lastname %s", i)).withNick(String.format("nick %s", i)).withCompany(String.format("company %s", i)).withAddress(String.format("address %s", i)).withHomephone(String.format("phone %s", i)).withMobilphone(String.format("mobilephone %s", i)).withWorkphone(String.format("workphone %s", i)).withEmail(String.format("email %s", i)).withEmail2(String.format("email2 %s", i)).withEmail3(String.format("email3 %s", i)));
    }
    return groups;
  }
}
