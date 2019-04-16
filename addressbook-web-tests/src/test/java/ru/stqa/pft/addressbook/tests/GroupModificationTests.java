package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.group().list().size() ==0) {
      app.group().create(new GroupData("test4", "test", "test"));
    }
  }

  @Test
  public void testGroupModificationTests() {
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData(before.get(before.size() -1 ).getId(),"test4", "test", "test");
    int index = before.size() -1;
    app.group().modify(group, index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() );

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }


}
