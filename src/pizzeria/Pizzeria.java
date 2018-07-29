/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author silvi
 */
public class Pizzeria {

    private static int numberOfPizzas;
    private final int totalSeats;
    private  int takenSeats;

    public Pizzeria(int numberOfPizzas, int seats) {
        this.numberOfPizzas = numberOfPizzas;
        this.totalSeats = seats;
    }

    public int getNumberOfPizzas() {
        return numberOfPizzas;
    }

    public synchronized void eatPizza(){
            if(numberOfPizzas>0){
            takenSeats++; 
            System.out.println(Colors.MAGENTA+Thread.currentThread().getName()+" takes a seat ->>"+" Current seats taken "+takenSeats+" to "+totalSeats);
            numberOfPizzas--;
            if(numberOfPizzas>0){
                 System.out.println("\tPizzeria says: We have "+numberOfPizzas+ " pizzas !!");
            }else{
                  System.out.println(Colors.RED+"\tPizzeria says: The pizzas are over!!!!");
            }
           
            System.out.println(Colors.VERDE+Thread.currentThread().getName() + " is eating pizza.");
            Random r = new Random();
                try {
                    wait(r.nextInt((5000 - 1000) + 1) + 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null, ex);
                } 
            System.out.println("*** "+Thread.currentThread().getName() + " has finished to eating pizza.");
            //When finish add new seat.
            takenSeats--;  
             System.out.println(Colors.MAGENTA+Thread.currentThread().getName()+" empties a seat ->>"+" Current seats taken "+takenSeats+" to "+totalSeats);
            } 
            notifyAll();
    }

    public boolean hasAnEmptyChair() {
        if (takenSeats < totalSeats) {
            return true;
        }
        return false;
    }

    public synchronized boolean  hasAnyPizzaForEating() {
        if (numberOfPizzas > 0) {
            return true;
        }
        System.out.println(Colors.RED+"\tPizzeria says: The pizzas are over, so sorry!");
        return false;
    }

    public synchronized void getChair() {

        //If not has an empty spot customer waiting;
        while (!hasAnEmptyChair() && numberOfPizzas>0) {
                System.out.println(Colors.RED+Thread.currentThread().getName() + " says: Haven't an empty chair, i'll wait.");
            try {   
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }
    }

}
