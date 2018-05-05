/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jumotest;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Little
 */
public class JumoTestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        sendEmployeeAirtimes();
    }

    public static void sendEmployeeAirtimes() {
        CSVUtil csvUtil = new CSVUtil();

        List<EmployeeAirtime> employeeAirtimes = csvUtil.getEmployeeAirtimes("employees.csv");

        //Specify credentials
        String username = "Username";
        String apiKey = "AppAPIKey";

        JSONArray recipientsJSONArray = new JSONArray();

        try {
            for (EmployeeAirtime employeeAirtime : employeeAirtimes) {

                JSONObject jsonObject = new JSONObject().put("phoneNumber", employeeAirtime.getPhoneNumber()).put("amount", employeeAirtime.getAirtimeStr());
                recipientsJSONArray.put(jsonObject);
            }

            String airtimeReciepientsFormattedStr = recipientsJSONArray.toString();

            AfricasTalkingGateway africasTalkingGateway = new AfricasTalkingGateway(username, apiKey);
            JSONArray results = africasTalkingGateway.sendAirtime(airtimeReciepientsFormattedStr);

            for (int i = 0; i < results.length(); i++) {

                JSONObject result = results.getJSONObject(i);
                
                System.out.println(result.getString("amount"));
                System.out.println(result.getString("phoneNumber"));                
                System.out.println(result.getString("requestId"));
              
            }

        } catch (Exception exc) {
            System.out.print(exc);
        }

    }
}
