package com.highradius.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;

public class InvoiceDaoImpl implements InvoiceDao {

	Connection connection = null;
	PreparedStatement ps = null;
	@Override
	public boolean addInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO h2h_oap(Sl_no,CUSTOMER_ORDER_ID,SALES_ORG,DISTRIBUTION_CHANNEL,COMPANY_CODE,ORDER_CREATION_DATE,ORDER_CURRENCY,CUSTOMER_NUMBER,AMOUNT_IN_USD,ORDER_AMOUNT) VALUES(?,?,?,?,?,?,?,?,?,?)";
				
				           
		try {
			connection = DatabaseConnection.getConnection();
			if(connection == null)
				return false;
			
			ps =connection.prepareStatement(sql);
			
			ps.setString(1,invoice.getSlNo());
			ps.setString(2,invoice.getCustomerOrderId());
			ps.setString(3,invoice.getSalesOrg());
			ps.setString(4,invoice.getDistributionChannel());
			ps.setString(5,invoice.getCompanyCode());
			ps.setString(6,invoice.getOrderCreationDate());
			ps.setString(7,invoice.getOrderCurrency());
			ps.setString(8,invoice.getCustomerNumber());
			ps.setString(9,invoice.getAmountInUSD());
			ps.setString(10,invoice.getOrderAmount());
			
			int insert = ps.executeUpdate();
			return insert > 0 ? true : false ;
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	
	}
	@Override
	public List<Invoice> getInvoiceList() {
		
		List<Invoice> h2h_oap = new ArrayList<Invoice>();
		String sql = "SELECT * FROM h2h_oap LIMIT 10000";

        
		try {
			connection = DatabaseConnection.getConnection();
			if(connection == null)
				return null;
			
			ps =connection.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				h2h_oap.add(new Invoice(rs.getString("Sl_no"),rs.getString("CUSTOMER_ORDER_ID"),rs.getString("SALES_ORG"),rs.getString("DISTRIBUTION_CHANNEL"),rs.getString("COMPANY_CODE"),rs.getString("ORDER_CREATION_DATE"),rs.getString("ORDER_CURRENCY"),rs.getString("CUSTOMER_NUMBER"),rs.getString("AMOUNT_IN_USD"),rs.getString("ORDER_AMOUNT")));
			}
			return h2h_oap;
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return h2h_oap;
		}
		
	}
	@Override
	public boolean deleteInvoice(int parseInt) {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = DatabaseConnection.getConnection(); // Obtain a database connection (you need to implement this method)

	        // Prepare the SQL statement
	        String sql = "DELETE FROM h2h_oap WHERE Sl_no = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, parseInt);

	        // Execute the delete operation
	        int rowsAffected = stmt.executeUpdate();

	        // Check if any rows were affected
	        if (rowsAffected > 0) {
	            return true; // Deletion successful
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close the database resources
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return false; // Deletion failed
	}

	@Override
	public boolean updateInvoice(Invoice invoice) {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        conn = DatabaseConnection.getConnection(); // Obtain a database connection (you need to implement this method)

	        // Prepare the SQL statement
	        String sql = "UPDATE h2h_oap SET Sl_no=?, CUSTOMER_ORDER_ID=?, SALES_ORG=?, DISTRIBUTION_CHANNEL=?, COMPANY_CODE=?, ORDER_CREATION_DATE=?, ORDER_CURRENCY=?, CUSTOMER_NUMBER=?, AMOUNT_IN_USD=?, ORDER_AMOUNT=? WHERE Sl_no=?";
	        stmt = conn.prepareStatement(sql);
	       
	        stmt.setString(1, invoice.getSlNo());
	        stmt.setString(2, invoice.getCustomerOrderId());
	        stmt.setString(3, invoice.getSalesOrg());
	        stmt.setString(4, invoice.getDistributionChannel());
	        stmt.setString(5, invoice.getCompanyCode());
	        stmt.setString(6, invoice.getOrderCreationDate());
	        stmt.setString(7, invoice.getOrderCurrency());
	        stmt.setString(8, invoice.getCustomerNumber());
	        stmt.setString(9, invoice.getAmountInUSD());
	        stmt.setString(10, invoice.getOrderAmount());
	        stmt.setString(11, invoice.getSlNo());
	     
	        // Execute the update operation
	        int rowsAffected = stmt.executeUpdate();

	        // Check if any rows were affected
	        if (rowsAffected > 0) {
	            return true; // Update successful
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close the database resources
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return false; // Update failed
	}


}
