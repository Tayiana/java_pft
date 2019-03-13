package ru.stqa.pft.sandbox;

public class Point {

  public double xa;
  public double ya;
  public double xb;
  public double yb;

  public Point (double xa, double ya, double xb, double yb) {
    this.xa = xa;
    this.ya = ya;
    this.xb = xb;
    this.yb = yb;
  }
  public double area() {
    return Math.round((Math.sqrt((this.xb - this.xa)*(this.xb - this.xa)+(this.yb - this.ya)*(this.yb - this.ya)))*100)/100D;
  }

}
