package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {



  @Test
  public void testArea() {
    Point p = new Point (1, 12, 5, 26);
    assert p.area() == 14.56;
    Assert.assertEquals(p.area(), 14.56);
  }

}
