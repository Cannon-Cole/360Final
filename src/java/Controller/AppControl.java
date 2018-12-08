/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Cole
 */
import Model.PassAround;
import java.util.HashMap;

public class AppControl {

    private static HashMap<String, Handler> handlerMap = new HashMap();

    public static void handleRequest(String command) {
        Handler aCommandHandler = handlerMap.get(command);
        if (aCommandHandler != null) {
            aCommandHandler.handleIt();
        }
        else{
            PassAround.table = "Command Not Found";
        }
    }

    public static void mapCommand(String aCommand, Handler acHandler) {
        handlerMap.put(aCommand, acHandler);
    }
}