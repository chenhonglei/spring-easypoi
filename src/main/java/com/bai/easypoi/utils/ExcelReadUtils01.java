package com.bai.easypoi.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

/**
 * 读取excel
 */
public class ExcelReadUtils01 {

    // ================================================================
    // Constants
    // ================================================================



    // ================================================================
    // Fields
    // ================================================================

    // ================================================================
    // Public or Protected Methods
    // ================================================================

    public static Workbook getWorkbook(String excelFile) throws IOException {
        return getWorkbook(new FileInputStream(excelFile));
    }

    public static Workbook getWorkbook(InputStream is) throws IOException {

        Workbook wb;

        ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
        byte[] buffer = new byte[512];
        int count;
        while ((count = is.read(buffer)) != -1)
            byteOS.write(buffer, 0, count);
        byteOS.close();
        byte[] allBytes = byteOS.toByteArray();

        try {
            wb = new XSSFWorkbook(new ByteArrayInputStream(allBytes));
        } catch (Exception ex) {
            wb = new HSSFWorkbook(new ByteArrayInputStream(allBytes));
        }

        return wb;
    }

    public static ArrayList<ArrayList<Object>> readAllRows(String excelFile) throws IOException {
        return readAllRows(new FileInputStream(excelFile));
    }

    public static ArrayList<ArrayList<Object>> readAllRows(InputStream is) throws IOException {
        Workbook wb = getWorkbook(is);
        ArrayList<ArrayList<Object>> rowList = new ArrayList<>();

        for (int i = 0; i < wb.getNumberOfSheets(); i++) {//获取每个Sheet表
            Sheet sheet = wb.getSheetAt(i);
            rowList.addAll(readRows(sheet));
        }

        return rowList;
    }

    public static ArrayList<ArrayList<Object>> readRows(String excelFile,
                                                        int startRowIndex, int rowCount) throws IOException {
        return readRows(new FileInputStream(excelFile), startRowIndex, rowCount);
    }

    public static ArrayList<ArrayList<Object>> readRows(String excelFile) throws IOException {
        return readRows(new FileInputStream(excelFile));
    }

    public static ArrayList<ArrayList<Object>> readRows(InputStream is,
                                                        int startRowIndex, int rowCount) throws IOException {
        Workbook wb = getWorkbook(is);
        Sheet sheet = wb.getSheetAt(0);

        return readRows(sheet, startRowIndex, rowCount);
    }

    public static ArrayList<ArrayList<Object>> readRows(InputStream is) throws IOException {
        Workbook wb = getWorkbook(is);
        Sheet sheet = wb.getSheetAt(0);
        return readRows(sheet);
    }

    public static ArrayList<ArrayList<Object>> readRows(Sheet sheet,
                                                        int startRowIndex, int rowCount) {
        ArrayList<ArrayList<Object>> rowList = new ArrayList<>();

        for (int i = 0; i <= (startRowIndex + rowCount); i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                break;
            }

            ArrayList<Object> cellList = new ArrayList<>();
            for (Cell cell : row) {
                cellList.add(readCell(cell));
            }

            rowList.add(cellList);
        }

        return rowList;
    }

    public static ArrayList<ArrayList<Object>> readRows(Sheet sheet) {
        int rowCount = sheet.getLastRowNum();
        return readRows(sheet, 0, rowCount);
    }



    // ================================================================
    // Private Methods
    // ================================================================

    /**
     * 从Excel读Cell
     */
    public static Object readCell(Cell cell) {
        if (cell == null) {
            return null;
        }

        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case STRING:
                String str = cell.getRichStringCellValue().getString();
                return str == null ? "" : str.trim();
            case FORMULA:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    try {
                        return String.valueOf(cell.getNumericCellValue());
                    } catch (IllegalStateException e) {
                        return String.valueOf(cell.getRichStringCellValue());
                    }
                }
            case BLANK:
                return "";
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case ERROR:
            case _NONE:
            default:
                System.err.println("Data error for cell of excel: " + cell.getCellType());
                return "";
        }
    }

    // ================================================================
    // Test Methods
    // ================================================================

}
