package com.highradius.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        InvoiceDao dao = null;

        String Sl_no = request.getParameter("Sl_no");

        if (Sl_no != null && !Sl_no.isEmpty()) {
            dao = new InvoiceDaoImpl();
            boolean delete = dao.deleteInvoice(Integer.parseInt(Sl_no));
            if (delete) {
                response.getWriter().append("Invoice with ID " + Sl_no + " has been deleted successfully");
            } else {
                response.getWriter().append("Failed to delete invoice with ID " + Sl_no);
            }
        } else {
            response.getWriter().append("Invalid invoice ID");
        }
    }
}
