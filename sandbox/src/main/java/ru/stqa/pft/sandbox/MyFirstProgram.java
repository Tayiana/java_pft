package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Alexei");

    Point p = new Point(1, 12, 5, 26);
    System.out.println("Задание 2.Потренироваться использовать функции, классы, объекты и методы. Решение:");
    System.out.println("Координаты точки А (" + p.xa + ";" + p.ya + ") ");
    System.out.println("Координаты точки B (" + p.xb + ";" + p.yb + ") ");
    System.out.println("Расстояние между точками А и B = " + area(p));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(Point p) {
    return Math.round((Math.sqrt((p.xb - p.xa)*(p.xb - p.xa)+(p.yb - p.ya)*(p.yb - p.ya)))*100)/100D;
  }
}



