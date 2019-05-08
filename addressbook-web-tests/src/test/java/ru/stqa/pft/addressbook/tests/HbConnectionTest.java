package ru.stqa.pft.addressbook.tests;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupContacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class HbConnectionTest {



  private SessionFactory sessionFactory;
  private Object SessionFactory;


  @BeforeClass
  public void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      SessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      e.printStackTrace();
      StandardServiceRegistryBuilder.destroy( registry );
    }
  }

  @Test
public void testHbConnectionForGroups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List result = session.createQuery("from GroupData").list();
    for (GroupData group : (List<GroupData>) result) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();
  }


  @Test
  public void testHbConnectionForContacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List result = session.createQuery("from GroupContacts where deprecated = '0000-00-00'").list();
    for (GroupContacts contacts : (List<GroupContacts>) result) {
      System.out.println(contacts);
    }
    session.getTransaction().commit();
    session.close();
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
}

