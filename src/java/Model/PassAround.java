/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Cole
 */
public class PassAround {

    public static String table;
    public static String message;
    public static int howManyCores = Runtime.getRuntime().availableProcessors();
    public static ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(howManyCores);
    public static CountDownLatch latchDisplay;
    public static CountDownLatch latchAdd;
    public static CountDownLatch latchJSON;

    public static String FirstName;
    public static String LastName;
    public static String ClassStanding;
    public static String Building;
    public static int ApartmentNumber;

    public static String form = "<form name=\"send-name\" action=\"MainControl\" method=\"post\">\n"
        + "  First Name:<br>\n"
        + "  <input type=\"text\" name=\"FirstName\">\n"
        + "  <br>\n"
        + "  Last Name:<br>\n"
        + "  <input type=\"text\" name=\"LastName\">\n"
        + "  <br>\n"
        + "  Class Standing:<br>\n"
        + "  <input type=\"text\" name=\"ClassStanding\">\n"
        + "  <br>\n"
        + "  Building:<br>\n"
        + "  <input type=\"text\" name=\"Building\">\n"
        + "  <br>\n"
        + "  Apartment Number:<br>\n"
        + "  <input type=\"text\" name=\"ApartmentNumber\">\n"
        + "  <br>\n"
        + "  <input type=\"submit\" name=\"action\" value=\"Save\">\n"
        + "</form> ";
    public static String first = "<!DOCTYPE html><html><body>";
    public static String last = "</body></html>";
    public static String nav = "<form name=\"send-name\" action=\"MainControl\" method=\"post\">\n"
        + "            <input type=\"submit\" name=\"action\" value=\"All\" />\n"
        + "        </form>\n"
        + "        <form name=\"send-name\" action=\"MainControl\" method=\"post\">\n"
        + "            <input type=\"submit\" name=\"action\" value=\"Add\" />\n"
        + "        </form>";
    public static String css = "<style>\n"
        + "ul {\n"
        + "  list-style-type: none;\n"
        + "  margin: 0;\n"
        + "  padding: 0;\n"
        + "  overflow: hidden;\n"
        + "  background-color: #333;\n"
        + "}\n"
        + "\n"
        + "li {\n"
        + "  float: left;\n"
        + "}\n"
        + "\n"
        + "li a {\n"
        + "  display: block;\n"
        + "  color: white;\n"
        + "  text-align: center;\n"
        + "  padding: 14px 16px;\n"
        + "  text-decoration: none;\n"
        + "}\n"
        + "\n"
        + "li a:hover:not(.active) {\n"
        + "  background-color: #111;\n"
        + "}\n"
        + "\n"
        + ".active {\n"
        + "  background-color: #4CAF50;\n"
        + "}\n"
        + "</style>";

    public static String getTable() {
        return table;
    }

    public static void setTable(String table) {
        PassAround.table = table;
    }

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        PassAround.message = message;
    }

    public static int getHowManyCores() {
        return howManyCores;
    }

    public static void setHowManyCores(int howManyCores) {
        PassAround.howManyCores = howManyCores;
    }

    public static ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    public static void setThreadPool(ThreadPoolExecutor threadPool) {
        PassAround.threadPool = threadPool;
    }

    public static CountDownLatch getLatchDisplay() {
        return latchDisplay;
    }

    public static void setLatchDisplay(CountDownLatch latchDisplay) {
        PassAround.latchDisplay = latchDisplay;
    }

    public static CountDownLatch getLatchAdd() {
        return latchAdd;
    }

    public static void setLatchAdd(CountDownLatch latchAdd) {
        PassAround.latchAdd = latchAdd;
    }

    public static String getForm() {
        return form;
    }

    public static void setForm(String form) {
        PassAround.form = form;
    }

    public static String getFirst() {
        return first;
    }

    public static void setFirst(String first) {
        PassAround.first = first;
    }

    public static String getLast() {
        return last;
    }

    public static void setLast(String last) {
        PassAround.last = last;
    }

    public static String getNav() {
        return nav;
    }

    public static void setNav(String nav) {
        PassAround.nav = nav;
    }

    public static String getCss() {
        return css;
    }

    public static void setCss(String css) {
        PassAround.css = css;
    }

}
