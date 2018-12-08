package Controller;

import Model.Hibernate;
import Model.PassAround;
import Model.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.ehcache.search.parser.CustomParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Cole
 */
public class MainControl extends HttpServlet {

    private String dataOutput;

    public MainControl() {

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("index.html");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

//        String action = request.getParameter("action");
//
//        PassAround.threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        AppControl.mapCommand("All", new DisplayAll());
//
//        AppControl.handleRequest(action);
//
//        PassAround.threadPool.shutdown();

        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

//            SessionFactory fac = factory;
//            Session ses = fac.openSession();
//
//            String hql = "SELECT * FROM Person";
//            Query query = ses.createQuery(hql);
//
//            List<Person> results = query.list();
//            String table = "<table>";
//
//            for (int i = 0; i < results.size(); i++) {
//                table += "<tr>";
//                table += "<th>";
//                table += Integer.toString(results.get(i).getID());
//                table += results.get(i).getFirstName();
//                table += results.get(i).getLastName();
//                table += results.get(i).getClassStanding();
//                table += results.get(i).getBuilding();
//                table += results.get(i).getApartmentNumber();
//                table += "</th>";
//                table += "</tr>";
//            }
//
//            table += "</table>";
//
//            PassAround.table = table;

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.print(PassAround.table);
            out.print(PassAround.message);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public String getDataOutput() {
        return dataOutput;
    }

    public void setDataOutput(String dataOutput) {
        this.dataOutput = dataOutput;
    }
}
