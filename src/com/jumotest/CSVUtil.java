/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jumotest;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Little
 */
public class CSVUtil {

    public List<EmployeeAirtime> getEmployeeAirtimes(String filePath) {
        List<EmployeeAirtime> retValue = new ArrayList<>();

        try {
            String csvSplitToken = ",";

            //bufferedReader = new BufferedReader(new FileReader(filePath));
            // bufferedReader =  Files.newBufferedReader(Paths.get(this.getClass().getResource("res.txt").toURI()), Charset.defaultCharset());
            List<String> readAllLines = Files.readAllLines(Paths.get(this.getClass().getResource(filePath).toURI()), Charset.defaultCharset());

            for (int i = 1; i < readAllLines.size(); i++) {

                try {
                    String[] lineTokens = readAllLines.get(i).split(csvSplitToken);

                    EmployeeAirtime var = CSVUtil.getEmployeeAirtime(lineTokens);

                    if (var != null) {

                        retValue.add(var);

                    }
                } catch (Exception exc) {

                    System.out.print(exc);
                }

            }

        } catch (Exception exc) {

            System.out.print(exc);
        }
        return retValue;

    }

    private static EmployeeAirtime getEmployeeAirtime(String[] s) {
        if (s.length >= 3) {
            return new EmployeeAirtime(s[0], s[1], "KSH", Double.valueOf(s[2]));
        } else {
            return null;
        }

    }
}
