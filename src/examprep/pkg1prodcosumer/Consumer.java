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
public class Consumer implements Runnable {

    int total;
    ExamPrep1ProdCosumer main;

    public Consumer(ExamPrep1ProdCosumer main) {
        this.main = main;
        total = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int n = (int) main.getNextFib();
                System.out.println(n + " removed from S2");
                total += n;

            } catch (InterruptedException ex) {
                System.out.println("Total = " + total);
                break;
            }
        }

    }
}
