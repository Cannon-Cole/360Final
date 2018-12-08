/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Cole
 */
public class PassAround {
    public static String table;
    public static ThreadPoolExecutor threadPool;
    public static String message;

    public static String getTable() {
        return table;
    }

    public static void setTable(String table) {
        PassAround.table = table;
    }

    public static ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    public static void setThreadPool(ThreadPoolExecutor threadPool) {
        PassAround.threadPool = threadPool;
    }
    
}
