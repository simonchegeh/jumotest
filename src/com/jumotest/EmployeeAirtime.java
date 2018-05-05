/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jumotest;

/**
 *
 * @author Little
 */
public class EmployeeAirtime {
    
    private String employeeName;
    private String phoneNumber;
     private String currencyCode;
    private Double airtimeAmount;
    
    public EmployeeAirtime()
    {
        super();
    }

     public EmployeeAirtime(String employeeName,String phoneNumber,String currencyCode,Double airtimeAmount)
    {
        this();
        this.employeeName = employeeName; 
        this.phoneNumber = phoneNumber; 
        this.currencyCode = currencyCode; 
        this.airtimeAmount = airtimeAmount;
    }
     
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getAirtimeAmount() {
        return airtimeAmount;
    }

    public void setAirtimeAmount(Double airtimeAmount) {
        this.airtimeAmount = airtimeAmount;
    }

    public String getAirtimeStr() {
       
        return getCurrencyCode() + " " +  String.valueOf(getAirtimeAmount());
    }
    
}
