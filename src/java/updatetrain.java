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
@WebServlet(urlPatterns = {"/updatetrain"})
public class updatetrain extends HttpServlet {


   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           int flag=0;
            HttpSession session=request.getSession(false);
            if(session!=null){
                
             Connection con=link.getConnection("jdbc:derby://localhost:1527/student","root","root");
                String train_id;
                String train_name;
                String source;
                 train_id=request.getParameter("train_id");
                train_name=request.getParameter("train_name");
                 source=request.getParameter("source");
                 String destination=request.getParameter("destination");
              String seat=request.getParameter("seat_avail");
              String date=request.getParameter("train_date");
              String fare=request.getParameter("fare");
                
                try{
                    PreparedStatement psmt=con.prepareStatement("UPDATE TRAIN SET TRAIN_NAME=?,SOURCE=?,DESTINATION=?,SEAT_AVAIL=?,TRAIN_DATE=?,FARE=? WHERE TRAIN_ID=?");
                    
                   
                    psmt.setString(1, train_name);
                    psmt.setString(2, source);
                    psmt.setString(3, destination);
                    psmt.setString(4, seat);
                    psmt.setString(5, date);
                    psmt.setString(6, fare);
                  psmt.setString(7, train_id);
                    flag=psmt.executeUpdate();
                    request.setAttribute("msg","VALUES UPDATED");
                    request.getRequestDispatcher("Admin_Home.jsp").forward(request, response);
               }
               catch(Exception e){}
                if(flag==0){request.setAttribute("msg","VALUES ARE NOT UPDATED");
                    request.getRequestDispatcher("updatetrainconfirm.jsp").forward(request, response);
               //request.getRequestDispatcher("Admin_Train.jsp").forward(request, response);
            }}
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
            out.println("<title>Servlet updatetrain</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updatetrain at " + request.getContextPath() + "</h1>");
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
