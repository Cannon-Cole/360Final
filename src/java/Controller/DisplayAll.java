/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PassAround;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cole
 */
public class DisplayAll implements Handler {

    @Override
    public void handleIt() {
        
        CountDownLatch latch = new CountDownLatch(1);
        PassAround.latchDisplay = latch;
        PassAround.threadPool.execute(new DisplayAllThread());
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(DisplayAll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
