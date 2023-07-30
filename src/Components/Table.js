import React, { useState, useEffect } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import {
  Tabs,
  Tab,
  Button,
  Dialog,
  DialogTitle,
  TextField,
  DialogContent,
  DialogActions,
} from '@mui/material';
import ColumnDescription from './ColumnDescription.json';

function Table() {
  const [selectedTab, setSelectedTab] = useState(0);
  const [selectedRows, setSelectedRows] = useState([]);
  const [rows, setRows] = useState([]);
  const [openModal, setOpenModal] = useState(false);
  const [selectedRowData, setSelectedRowData] = useState({});
  const [isEditButtonDisabled, setIsEditButtonDisabled] = useState(true);
  const [isDeleteButtonDisabled, setIsDeleteButtonDisabled] = useState(true);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await fetch('http://localhost:8080/h2h_final_project/DataLoadingServlet');
      if (response.ok) {
        const data = await response.json();
        const rowsWithId = data.map((row, index) => ({ ...row, id: index + 1 }));
        setRows(rowsWithId);
      } else {
        console.error('Error:', response.status);
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  const handleSelectionChange = (selection) => {
    setSelectedRows(selection.selectionModel);
    setIsEditButtonDisabled(selection.selectionModel.length !== 1);
    setIsDeleteButtonDisabled(selection.selectionModel.length === 0);
  };

  const handleTabChange = (event, newValue) => {
    setSelectedTab(newValue);
  };

  const handleRefreshData = () => {
    fetchData();
  };

  const handleEdit = () => {
    if (selectedRows.length === 1) {
      const selectedRow = rows.find((row) => row.id === selectedRows[0]);
      setSelectedRowData(selectedRow);
      setOpenModal(true);
    }
  };

  const handleDelete = () => {
    // Perform the delete operation for the selected rows
    const updatedRows = rows.filter((row) => !selectedRows.includes(row.id));
    setRows(updatedRows);
    setSelectedRows([]);
    setIsDeleteButtonDisabled(true);
  };

  const handlePredict = () => {
    console.log('Predict button clicked');
  };

  const handleSave = async () => {
    // Get the new row data from the form fields
    const slNo = document.getElementById('outlined-sl-no').value;
    const customerNumber = document.getElementById('outlined-customer-number').value;
    const customerOrderId = document.getElementById('outlined-customer-order-id').value;
    const salesOrg = document.getElementById('outlined-sales-org').value;
    const distributionChannel = document.getElementById('outlined-distribution-channel').value;
    const companyCode = document.getElementById('outlined-company-code').value;
    const orderCreationDate = document.getElementById('outlined-order-creation-date').value;
    const orderAmount = document.getElementById('outlined-order-amount').value;
    const orderCurrency = document.getElementById('outlined-order-currency').value;
    const amountInUSD = document.getElementById('outlined-amount-in-usd').value;
  
    try {
      // Send the new row data to the server for insertion
      const response = await fetch('http://localhost:8080/h2h_final_project/AddServlet', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `Sl_no=${slNo}&CUSTOMER_NUMBER=${customerNumber}&CUSTOMER_ORDER_ID=${customerOrderId}` +
          `&SALES_ORG=${salesOrg}&DISTRIBUTION_CHANNEL=${distributionChannel}` +
          `&COMPANY_CODE=${companyCode}&ORDER_CREATION_DATE=${orderCreationDate}` +
          `&ORDER_AMOUNT=${orderAmount}&ORDER_CURRENCY=${orderCurrency}&AMOUNT_IN_USD=${amountInUSD}`,
      });
  
      if (response.ok) {
        // If the insertion is successful, fetch the updated data from the server
        setOpenModal(false);
        fetchData();
         // Close the pop-up
      } else {
        console.error('Error:', response.status);
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };
  
    

  const handleCancel = () => {
    setOpenModal(false);
  };

  return (
    <div>
      <div>
        <Tabs value={selectedTab} onChange={handleTabChange}>
          <Tab label="Homepage" />
          <Tab label="Add data" />
          <Tab label="Analytics view" />
        </Tabs>
      </div>

      {selectedTab === 0 && (
        <div>
          <DataGrid
            rows={rows}
            columns={ColumnDescription}
            checkboxSelection
            onSelectionModelChange={handleSelectionChange}
            selectionModel={selectedRows}
            getRowId={(row) => row.id}
            pageSize={10}
            pageSizeOptions={[10, 20, 50, 100]}
            style={{
              height: '800px',
              width: 'auto',
              backgroundColor: 'grey',
              fontSize: '20px',
              border: '7px solid orange',
              color: 'whitesmoke',
            }}
          />
          <div className="footer">
            <Button variant="outlined" onClick={handleRefreshData}>
              Refresh Data
            </Button>
            <Button variant="outlined" onClick={handleEdit} disabled={isEditButtonDisabled}>
              Edit
            </Button>
            <Button variant="outlined" onClick={handleDelete} disabled={isDeleteButtonDisabled}>
              Delete
            </Button>
            <Button variant="outlined" onClick={handlePredict}>
              Predict
            </Button>
          </div>
        </div>
      )}

      {selectedTab === 1 && (
        <div>
          <Button variant="outlined" onClick={() => setOpenModal(true)}>
            Add Data
          </Button>
        </div>
      )}

      {selectedTab === 2 && <div>Analytics view tab content</div>}

      <Dialog open={openModal} id="Dialog">
        <DialogTitle id="Dialog-header">Add Data</DialogTitle>
        <DialogContent>
          <TextField id="outlined-sl-no" label="Sl No" variant="outlined" />
          <TextField
            id="outlined-customer-number"
            label="Customer Number"
            variant="outlined"
          />
          <TextField
            id="outlined-customer-order-id"
            label="Customer Order ID"
            variant="outlined"
          />
          <TextField id="outlined-sales-org" label="Sales Org" variant="outlined" />
          <TextField
            id="outlined-distribution-channel"
            label="Distribution Channel"
            variant="outlined"
          />
          <TextField id="outlined-company-code" label="Company Code" variant="outlined" />
          <TextField
            id="outlined-order-creation-date"
            label="Order Creation Date"
            variant="outlined"
          />
          <TextField id="outlined-order-amount" label="Order Amount" variant="outlined" />
          <TextField id="outlined-order-currency" label="Order Currency" variant="outlined" />
          <TextField id="outlined-amount-in-usd" label="Amount in USD" variant="outlined" />
        </DialogContent>
        <DialogActions>
          <Button variant="outlined" color="primary" onClick={handleSave}>
            Save
          </Button>
          <Button variant="outlined" color="primary" onClick={handleCancel}>
            Cancel
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}

export default Table;
