package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.GroupContacts;
import ru.stqa.pft.addressbook.model.GroupData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Group count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }
    catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }
  

  private void run() throws IOException {
    List<GroupContacts> contacts = generateGroups(count);
      if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
        saveAsJson(contacts, new File(file));
      } else {
      System.out.println("Неподходящий формат " + format);
    }
  }

  private void saveAsJson(List<GroupContacts> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json =gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
    writer.write(json);}

  }

  private void saveAsXml(List<GroupContacts> groups, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(GroupContacts.class);
    String xml = xStream.toXML(groups);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml); }
  }

  private void saveAsCsv(List<GroupContacts> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    try (Writer writer = new FileWriter(file)) {
    for (GroupContacts group : groups) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", group.getFirstname(), group.getMiddlename(), group.getLastname(),group.getNick(), group.getCompany(), group.getAddress(),group.getHome(),group.getMobile(), group.getWork(), group.getEmail(),group.getEmail2(), group.getEmail3()));
    } }
    }

  private List<GroupContacts> generateGroups(int count) {
    List<GroupContacts> groups = new ArrayList<GroupContacts>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupContacts().withFirstname(String.format("Name %s", i))
              .withMiddlename(String.format("middlename %s", i)).withLastname(String.format("NameLast %s", i)).withNick(String.format("nick %s", i)).withCompany(String.format("company %s", i)).withAddress(String.format("address %s", i)).withHomephone(String.format("phone %s", i)).withMobilphone(String.format("mobilephone %s", i)).withWorkphone(String.format("workphone %s", i)).withEmail(String.format("email %s", i)).withEmail2(String.format("email2 %s", i)).withEmail3(String.format("email3 %s", i)));
    }
    return groups;
  }
}
