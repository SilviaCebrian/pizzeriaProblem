/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeria;

import java.util.Random;

/**
 *
 * @author silvi
 */
public class PizzeriaProblem {

    private static int numberOfPizzas;
    private static int numberOfCustomers = 10;
    private static final int SEATS = 5;
    private static ThreadCustomer[] customers = new ThreadCustomer[numberOfCustomers];
    private static Pizzeria p;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creating a random number of pizzas max 100 min 10;
        //Random r = new Random();
        //numberOfPizzas = r.nextInt((100 - 10) + 1) + 10;
        numberOfPizzas = 15;
        System.out.println(Colors.MAGENTA + "Silvia's free pizzeria its open!\n");
        p = new Pizzeria(numberOfPizzas, SEATS);
        System.out.println(Colors.MAGENTA + "*** Today we have to offer " + numberOfPizzas + " pizzas!!\n\t\t " + Colors.MAGENTA + "and only we have " + SEATS + " seats!! ***\n");
        creatingCustomers();
        startCustomers();

    }

    private static void creatingCustomers() {
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new ThreadCustomer("Customer " + i, p);
        }
    }

    private static void startCustomers() {

        for (int i = 0; i < customers.length; i++) {
            customers[i].start();
        }
    }

}
