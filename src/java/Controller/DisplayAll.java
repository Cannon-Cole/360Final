/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PassAround;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Cole
 */
public class DisplayAll implements Handler{
    @Override
    public void handleIt(){
        ThreadPoolExecutor pool = PassAround.getThreadPool();
        pool.execute(new DisplayAllThread());
    }
}