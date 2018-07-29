/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeria;

/**
 *
 * @author silvi
 */
public class ThreadCustomer extends Thread {

    private Pizzeria pizzeria;
    

    public ThreadCustomer(String name, Pizzeria pizzeria) {
        super(name);
        this.pizzeria = pizzeria;
    }

    @Override
    public void run() {
        System.out.println(Colors.AZUL + Thread.currentThread().getName() + " enter in pizzeria");
            while (pizzeria.hasAnyPizzaForEating()) {

                pizzeria.getChair();
                pizzeria.eatPizza();
                //When he ups try to take another pizza and another chair
                System.out.println(Colors.AZUL + Thread.currentThread().getName() + " -- Try to eat another pizza :)\n");
            }
            //When pizzas over, customer leaving
            System.out.println(Colors.AZUL+"\t"+Thread.currentThread().getName() + " Says: Okey, I'm leaving.\n");

    }

}
