package ua.GoIT.modul11.SecondTask;

import java.util.function.IntConsumer;

class Number {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Runnable printFizz = () -> System.out.print("fizz ");
        Runnable printBuzz = () -> System.out.print("buzz ");
        Runnable printFizzBuzz = () -> System.out.print("fizzbuzz ");
        IntConsumer printNumber = number -> System.out.print(number + "," + " ");

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(printFizz);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //        System.out.println("поток А завершен");
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //       System.out.println("поток B завершен");
        });
        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //        System.out.println("поток C завершен ");
        });
        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //        System.out.println("поток D завершен");
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
