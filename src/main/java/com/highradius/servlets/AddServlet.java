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

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InvoiceDao dao = null;
		Invoice invoice = null;
		
		String Sl_no;
	    String CUSTOMER_ORDER_ID;
	    String SALES_ORG;
	    String DISTRIBUTION_CHANNEL;
	    String COMPANY_CODE;
	    String ORDER_CREATION_DATE;
	    String ORDER_CURRENCY;
	    String CUSTOMER_NUMBER;
	    String AMOUNT_IN_USD;
	    String ORDER_AMOUNT;
		    
		    Sl_no = request.getParameter("Sl_no");
		    CUSTOMER_ORDER_ID= request.getParameter("CUSTOMER_ORDER_ID");
		    SALES_ORG = request.getParameter("SALES_ORG");
		    DISTRIBUTION_CHANNEL = request.getParameter("DISTRIBUTION_CHANNEL");
		    COMPANY_CODE= request.getParameter("COMPANY_CODE");
		    ORDER_CREATION_DATE= request.getParameter("ORDER_CREATION_DATE");
		    ORDER_CURRENCY = request.getParameter("ORDER_CURRENCY");
		    CUSTOMER_NUMBER= request.getParameter("CUSTOMER_NUMBER");
		    AMOUNT_IN_USD = request.getParameter("AMOUNT_IN_USD");
		    ORDER_AMOUNT= request.getParameter("ORDER_AMOUNT");
		
            if (Sl_no != null && CUSTOMER_ORDER_ID != null && SALES_ORG!=null &&DISTRIBUTION_CHANNEL!=null &&COMPANY_CODE!=null &&ORDER_CREATION_DATE!=null &&ORDER_CURRENCY!=null && CUSTOMER_NUMBER!=null &&AMOUNT_IN_USD!=null &&ORDER_AMOUNT!=null) {
            	   
            	invoice = new Invoice(Sl_no,CUSTOMER_ORDER_ID,SALES_ORG,DISTRIBUTION_CHANNEL,COMPANY_CODE,ORDER_CREATION_DATE,ORDER_CURRENCY,CUSTOMER_NUMBER,AMOUNT_IN_USD,ORDER_AMOUNT);
                dao = new InvoiceDaoImpl();
            	boolean insert = dao.addInvoice(invoice);
            	if(insert) {
            		response.getWriter().append("Great! we inserted the data");
            	}else {
            		response.getWriter().append("Oops! we were not able to insert the data");
            	}
            }
            else 
            {
            	response.getWriter().append("Data is insufficient");}
	
	}
	
}
