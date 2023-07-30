package com.highradius.model;

public class Invoice {
    private String Sl_no;
    private String CUSTOMER_ORDER_ID;
    private String SALES_ORG;
    private String DISTRIBUTION_CHANNEL;
    private String COMPANY_CODE;
    private String ORDER_CREATION_DATE;
    private String ORDER_CURRENCY;
    private String CUSTOMER_NUMBER;
    private String AMOUNT_IN_USD;
    private String ORDER_AMOUNT;

    public Invoice(String Sl_no, String CUSTOMER_ORDER_ID, String SALES_ORG, String DISTRIBUTION_CHANNEL,
                   String COMPANY_CODE, String ORDER_CREATION_DATE, String ORDER_CURRENCY, String CUSTOMER_NUMBER,
                   String AMOUNT_IN_USD, String ORDER_AMOUNT) {
        this.Sl_no = Sl_no;
        this.CUSTOMER_ORDER_ID = CUSTOMER_ORDER_ID;
        this.SALES_ORG = SALES_ORG;
        this.DISTRIBUTION_CHANNEL = DISTRIBUTION_CHANNEL;
        this.COMPANY_CODE = COMPANY_CODE;
        this.ORDER_CREATION_DATE = ORDER_CREATION_DATE;
        this.ORDER_CURRENCY = ORDER_CURRENCY;
        this.CUSTOMER_NUMBER = CUSTOMER_NUMBER;
        this.AMOUNT_IN_USD = AMOUNT_IN_USD;
        this.ORDER_AMOUNT = ORDER_AMOUNT;
    }

	public String getSlNo() {
        return Sl_no;
    }

    public void setSlNo(String Sl_no) {
        this.Sl_no = Sl_no;
    }

    public String getCustomerOrderId() {
        return CUSTOMER_ORDER_ID;
    }

    public void setCustomerOrderId(String CUSTOMER_ORDER_ID) {
        this.CUSTOMER_ORDER_ID = CUSTOMER_ORDER_ID;
    }

    public String getSalesOrg() {
        return SALES_ORG;
    }

    public void setSalesOrg(String SALES_ORG) {
        this.SALES_ORG = SALES_ORG;
    }

    public String getDistributionChannel() {
        return DISTRIBUTION_CHANNEL;
    }

    public void setDistributionChannel(String DISTRIBUTION_CHANNEL) {
        this.DISTRIBUTION_CHANNEL = DISTRIBUTION_CHANNEL;
    }

    public String getCompanyCode() {
        return COMPANY_CODE;
    }

    public void setCompanyCode(String COMPANY_CODE) {
        this.COMPANY_CODE = COMPANY_CODE;
    }

    public String getOrderCreationDate() {
        return ORDER_CREATION_DATE;
    }

    public void setOrderCreationDate(String ORDER_CREATION_DATE) {
        this.ORDER_CREATION_DATE = ORDER_CREATION_DATE;
    }

    public String getOrderCurrency() {
        return ORDER_CURRENCY;
    }

    public void setOrderCurrency(String ORDER_CURRENCY) {
        this.ORDER_CURRENCY = ORDER_CURRENCY;
    }

    public String getCustomerNumber() {
        return CUSTOMER_NUMBER;
    }

    public void setCustomerNumber(String CUSTOMER_NUMBER) {
        this.CUSTOMER_NUMBER = CUSTOMER_NUMBER;
    }

    public String getAmountInUSD() {
        return AMOUNT_IN_USD;
    }

    public void setAmountInUSD(String AMOUNT_IN_USD) {
        this.AMOUNT_IN_USD = AMOUNT_IN_USD;
    }

    public String getOrderAmount() {
        return ORDER_AMOUNT;
    }

    public void setOrderAmount(String ORDER_AMOUNT) {
        this.ORDER_AMOUNT = ORDER_AMOUNT;
    }
    
    
    @Override
    public String toString() {
        return "Invoice [Sl_no=" + Sl_no + ", CUSTOMER_ORDER_ID=" + CUSTOMER_ORDER_ID + ", SALES_ORG=" + SALES_ORG
                + ", DISTRIBUTION_CHANNEL=" + DISTRIBUTION_CHANNEL + ", COMPANY_CODE=" + COMPANY_CODE
                + ", ORDER_CREATION_DATE=" + ORDER_CREATION_DATE + ", ORDER_CURRENCY=" + ORDER_CURRENCY
                + ", CUSTOMER_NUMBER=" + CUSTOMER_NUMBER + ", AMOUNT_IN_USD=" + AMOUNT_IN_USD + ", ORDER_AMOUNT="
                + ORDER_AMOUNT + "]";
    }
}
