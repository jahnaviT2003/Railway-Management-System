/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 91630
 */
@WebServlet(urlPatterns = {"/reservation"})
public class reservation extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           HttpSession session=request.getSession(false);
            if(session!=null){
                int flag=0;
                Connection con=link.getConnection("jdbc:derby://localhost:1527/railway","root","root");
                String train_id=request.getParameter("train_id");
                String train_date=request.getParameter("train_date");
                String heads=request.getParameter("heads");
                String fare=request.getParameter("fare");
                String name=request.getParameter("name");
              try{
                    int a=Integer.parseInt("heads"); 
               int b=Integer.parseInt("fare");
               int amount=a*b;
               
                  Statement stm=con.createStatement();
           
              
             PreparedStatement psmt=con.prepareStatement("SELECT * FROM TRAIN WHERE TRAIN_ID=? AND SEAT_AVAIL>=?");
            
                psmt.setString(1, train_id);
                psmt.setString(2, heads);
               ResultSet rs=psmt.executeQuery();
                if(rs.next()){
                  java.sql.Statement stmt=con.createStatement();
            ResultSet r=stmt.executeQuery("SELECT pnr_no.NEXTVAL FROM dual");
            String pnr="pnr";
            if(r.next())
                pnr=r.getString(1);
        request.setAttribute("pnr",pnr);
        System.out.println("helloooo");
     PreparedStatement psmt1=null;
                       
                    psmt1=con.prepareStatement("INSERT INTO RESERVATION(PNR,TRAIN_ID,NO_OF_HEADS,AMOUNT,NAME)VALUES(PNR.NEXTVAL,?,?,?,?)");
                    psmt1.setString(1, pnr);
                    psmt1.setString(2, train_id);
                    psmt1.setInt(3, a);
                    psmt1.setInt(4, amount);
                    psmt1.setString(5, name);
            flag=psmt1.executeUpdate();
                    
                    psmt=con.prepareStatement("UPDATE TRAIN SET SEAT_AVAIL=SEAT_AVAIL-? WHERE TRAIN_ID=?");
                    psmt.setInt(1, a);
                    psmt.setString(2, train_id);
                    
                    flag=psmt.executeUpdate();
                    request.setAttribute("msg","Check Reservation Details");
                   
                     request.getRequestDispatcher("bookingconfirm.jsp").forward(request, response);
               }}
               catch(Exception e){
               }
                if(flag==0) {
                    request.getRequestDispatcher("Admin_Train.jsp").forward(request, response);
                }
               //request.getRequestDispatcher("Admin_Train.jsp").forward(request, response);
            
        } 
        }
        finally {            
            out.close();
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
}
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet reservation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet reservation at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
