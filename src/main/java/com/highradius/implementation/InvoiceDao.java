package com.highradius.implementation;

import java.util.List;

import com.highradius.model.Invoice;

public interface InvoiceDao {

	boolean addInvoice(Invoice invoice);

	List<Invoice> getInvoiceList();


	boolean deleteInvoice(int parseInt);

	boolean updateInvoice(Invoice invoice);

}
