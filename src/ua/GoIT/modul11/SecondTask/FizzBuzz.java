package ua.GoIT.modul11.SecondTask;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    int n;

    private final Semaphore semFizz;
    private final Semaphore semBuzz;
    private final Semaphore semFizzBuzz;
    private final Semaphore semNumber;

    public FizzBuzz(int n) {
        this.n = n;

        semFizz = new Semaphore(0);
        semBuzz = new Semaphore(0);
        semFizzBuzz = new Semaphore(0);
        semNumber = new Semaphore(1);
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n ; i+= 3) {
            semFizz.acquire();
            printFizz.run();
            semNumber.release();
            if ((i + 3) % 5 == 0) {
                i += 3;
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n ; i += 5) {
            semBuzz.acquire();
            printBuzz.run();
            semNumber.release();
            if ((i + 5) % 3 == 0) {
                i += 5;
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            semFizzBuzz.acquire();
            printFizzBuzz.run();
            semNumber.release();
        }
    }

    public void number(IntConsumer number) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semNumber.acquire();
            if((i % 3 == 0)&& (i % 5 == 0)){
                semFizzBuzz.release();
            }
            else if(i % 5 == 0){
                semBuzz.release();
            }
            else if(i % 3 == 0){
                semFizz.release();
            }
            else{
                number.accept(i);
                semNumber.release();
            }
        }
    }
}
