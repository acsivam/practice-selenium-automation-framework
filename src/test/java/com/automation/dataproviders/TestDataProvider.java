package com.automation.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.automation.models.User;
import com.automation.utils.ExcelUtil;

public class TestDataProvider {
	
	private static final String LOGIN_FILE_PATH = "./testData/LoginDDT.xlsx";
	private static final String REGISTER_FILE_PATH ="./testData/registerData.xlsx";


	@DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {

        ExcelUtil excelUtil = new ExcelUtil(LOGIN_FILE_PATH);

        return excelUtil.getExcelData(
        		LOGIN_FILE_PATH,
                "Login"
        );
    }


    @DataProvider(name = "registerData")
    public Object[][] getRegisterData() throws IOException {

        ExcelUtil excelUtil = new ExcelUtil(REGISTER_FILE_PATH);

        String[][] excelData = excelUtil.getExcelData(
        		REGISTER_FILE_PATH,
                "Sheet 1"
        );
 
        Object[][] userData = new Object[excelData.length][1];
        
        for (int i = 0; i < excelData.length; i++) {

            User user = new User();

            user.setEmail(excelData[i][0]);
            user.setPassword(excelData[i][1]);

            userData[i][0] = user;
        }

        return userData;
    }
}
