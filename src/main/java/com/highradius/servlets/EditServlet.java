package com.highradius.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        InvoiceDao dao = null;

        String Sl_no = request.getParameter("Sl_no");
        String customerOrderId = request.getParameter("customerOrderId");
        String salesOrg = request.getParameter("salesOrg");
        String distributionChannel = request.getParameter("distributionChannel");
        String companyCode = request.getParameter("companyCode");
        String orderCreationDate = request.getParameter("orderCreationDate");
        String orderCurrency = request.getParameter("orderCurrency");
        String customerNumber = request.getParameter("customerNumber");
        String amountInUSD = request.getParameter("amountInUSD");
        String orderAmount = request.getParameter("orderAmount");

        if (Sl_no != null && !Sl_no.isEmpty()) {
            dao = new InvoiceDaoImpl();
            Invoice invoice = new Invoice(Sl_no, customerOrderId, salesOrg, distributionChannel, companyCode,
                    orderCreationDate, orderCurrency, customerNumber, amountInUSD, orderAmount);
            boolean isUpdated = dao.updateInvoice(invoice);
            if (isUpdated) {
                response.getWriter().append("Updated invoice.");
            } else {
                response.getWriter().append("Failed to update invoice.");
            }
        } else {
            response.getWriter().append("Invalid invoice ID");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Inform the client that GET method is not supported
        response.getWriter().append("GET method is not supported. Please use POST method.");
    }
}
