package ru.stqa.pft.sandbox;

public class Point {

  public double x;
  public double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
    }

    public double distance(Point p) {
      return Math.round (( Math.sqrt((p.x - x) * ((p.x - x)) + (p.y - y) * (p.y - y))) * 100) / 100D;
    }
}

