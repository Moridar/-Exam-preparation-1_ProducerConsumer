/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examprep.pkg1prodcosumer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Computer
 */
public class Producer implements Runnable {

    ExamPrep1ProdCosumer main;

    public Producer(ExamPrep1ProdCosumer main) {
        this.main = main;
    }

    private int fib(int n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    @Override
    public void run() {
        boolean hasNext = true;
        while (hasNext) {
            Object nextNumber = main.getNextNumber();
            try {
                if (nextNumber == null) {
                    hasNext = false;
                } else {
//                    System.out.println(nextNumber + " fibb'd to " + fib((int) nextNumber));
                    main.addFibNumber(fib((int) nextNumber));
                    
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Producer stopped");
                break;
            }

        }
    }

}
