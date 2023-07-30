package com.highradius.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;

import com.highradius.implementation.*;
import com.highradius.model.*;

@WebServlet("/DataLoadingServlet")
public class DataLoadingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        InvoiceDao dao = new InvoiceDaoImpl();
        List<Invoice> invoiceList = new ArrayList<Invoice>();
        invoiceList = dao.getInvoiceList();

        String errorString = "Sorry! No invoices found!!";
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(errorString);

        if (invoiceList.size() > 0) {
            jsonResponse = gson.toJson(invoiceList);
        }

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.getWriter().append(jsonResponse);
    }
}
