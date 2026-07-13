package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String filepath;

	public ExcelUtil(String filepath) {
		this.filepath = filepath;
	}

	
	public String[][] getExcelData(String filePath, String sheetName) throws IOException {

	    int totalRows = getRowCount(sheetName);
	    int totalCols = getCellCount(sheetName, 0);

	    String[][] testData = new String[totalRows][totalCols];

	    for (int row = 1; row <= totalRows; row++) {
	        for (int col = 0; col < totalCols; col++) {
	            testData[row - 1][col] =
	                    getCellData(sheetName, row, col);
	        }
	    }
	    return testData;
	}
	
	public int getRowCount(String sheetname) throws IOException{
	    
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		if (sheet == null) {
		    workbook.close();
		    fi.close();
		    throw new RuntimeException("Sheet not found: " + sheetname);
		}
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	} 
	
	public int getCellCount(String sheetname, int rownum) throws IOException {
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
		
	}
	
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		
		workbook.close();
		fi.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
		File xlFile=new File(filepath);
		if(!xlFile.exists()) {
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(filepath);
			workbook.write(fo);
		}
		
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(sheetName)== -1) {
			workbook.createSheet(sheetName);
			sheet = workbook.getSheet(sheetName);
		}
		
		if(sheet.getRow(rowNum) == null){
			sheet.createRow(rowNum);
			row = sheet.getRow(rowNum);
		}
		
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
	public void fillGreenColour(String sheetName, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		workbook.close();
		
		fi.close();
		fo.close();		
	}
	
	public void fillRedColour(String sheetName, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		workbook.close();
		
		fi.close();
		fo.close();		
	}
}
