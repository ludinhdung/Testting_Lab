package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    private final List<Object> column1Data = new ArrayList<>();
    private final List<Object> column2Data = new ArrayList<>();

    public ReadExcel() {
    }

    private Object getCellValue(Cell cell) {

        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    double numericValue = cell.getNumericCellValue();
                    DecimalFormat decimalFormat = new DecimalFormat("#");
                    return decimalFormat.format(numericValue);
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            default:
                return null;
        }
    }

    public void readFile() {

        String filePath = "C://Users//dungd//OneDrive//Desktop//Testing.xlsx";

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);

                Object value1 = getCellValue(cell1);
                Object value2 = getCellValue(cell2);

                column1Data.add(value1);
                column2Data.add(value2);
            }

            fis.close();
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Object> getColumn1Data() {
        return column1Data;
    }

    public List<Object> getColumn2Data() {
        return column2Data;
    }

    public static void main(String[] args) {
        ReadExcel readExcel = new ReadExcel();
        readExcel.readFile();
        readExcel.column1Data.forEach(System.out::println);
        readExcel.column2Data.forEach(System.out::println);
        System.out.println(Integer.MAX_VALUE);
    }
}
