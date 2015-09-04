/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examprep.pkg1prodcosumer;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Computer
 */
public class ExamPrep1ProdCosumer {

    private ArrayBlockingQueue S1;
    private ArrayBlockingQueue S2;
    public ArrayList<Thread> ThreadList;

    public ExamPrep1ProdCosumer() {
        S1 = new ArrayBlockingQueue(20);
        S2 = new ArrayBlockingQueue(20);
        ThreadList = new ArrayList<>();
    }

    public void addValue(int n) {
        S1.add(n);
        System.out.println(n + " added til S1");
    }

    public Object getNextNumber() {
        return S1.poll();
    }

    public void addFibNumber(int n) throws InterruptedException {
        S2.put(n);
    }

    public Object getNextFib() throws InterruptedException {
        return S2.take();
    }

    public boolean s2isEmpty() {
        return S2.isEmpty();
    }

    public void addRandomValues() {
        addValue(4);
        addValue(5);
        addValue(8);
        addValue(12);
        addValue(21);
        addValue(22);
        addValue(34);
        addValue(35);
        addValue(36);
        addValue(37);
        addValue(42);
    }
    
    public void addThread(Thread t){
        ThreadList.add(t);
    }
    
    public int numberOfActiveThreads(){
        return ThreadList.size();
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExamPrep1ProdCosumer EPC = new ExamPrep1ProdCosumer();
        EPC.addRandomValues();
        
        Thread t1 = new Thread(new Producer(EPC));
        Thread t2 = (new Thread(new Producer(EPC)));
        Thread t3 =(new Thread(new Producer(EPC)));
        Thread t4 = (new Thread(new Producer(EPC)));
        
        EPC.addThread(t1); EPC.addThread(t2); EPC.addThread(t3); EPC.addThread(t4);
        
        Thread t5 = new Thread(new Consumer(EPC));
        EPC.addThread(t5);
        
        for(Thread t : EPC.ThreadList){
            t.start();
        }
        
        while(t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive() || !EPC.s2isEmpty()){
        }
        t5.interrupt();
        
    }

}
