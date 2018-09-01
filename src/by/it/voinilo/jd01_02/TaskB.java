package by.it.voinilo.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String args[]) {
        step1();

        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        step2(month);

        Scanner scanner1 = new Scanner(System.in);
        double a = scanner1.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        double b = scanner2.nextInt();
        Scanner scanner3 = new Scanner(System.in);
        double c = scanner3.nextInt();
        step3(a, b, c);
    }


    static void step1() {
        for (int i = 1; i <= 25; i++) {
            if (i % 5 != 0) {
                System.out.print(i + " ");
            } else {
                System.out.println(i);
            }
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }


    private static void step3(double a, double b, double c) {
        double d = ((Math.pow(b, 2)) - (4 * a * c));
        if (d < 0) System.out.println("корней нет");
        else if (d!=0) {
                double x1 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println(x1);
                double x2 = (-b + Math.sqrt(d)) / (2 * a);
                System.out.println(x2);
        }
        else{
            double x = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println(x);
        }

    }


}
