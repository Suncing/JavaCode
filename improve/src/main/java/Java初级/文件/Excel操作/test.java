package Java初级.文件.Excel操作;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.FileOutputStream;

public class test {
    /**
     * 读取数据
     * @throws Exception
     */

    @Test
    public void test1() throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\zhangpan\\Desktop\\项目二\\1.xlsx");
        XSSFSheet sheet =workbook.getSheetAt(1);

        for(Row row : sheet){
            for(Cell cell: row){
                String stringCellValue = cell.getStringCellValue();
                System.out.println(stringCellValue);
            }
        }
        workbook.close();
    }

    @Test
    public void test2() throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\zhangpan\\Desktop\\项目二\\1.xlsx");
        XSSFSheet sheet =workbook.getSheetAt(1);
        int lastRowNum =sheet.getLastRowNum();
        for(int i =0;i<lastRowNum;i++){
            XSSFRow row = sheet.getRow(i);
            if(row != null){
                short cellNum = row.getLastCellNum();
                for(int j=0;j<=cellNum;j++){
                    XSSFCell cell = row.getCell(j);
                    if(cell!=null){
                        String stringCellValue = cell.getStringCellValue();
                        System.out.println(stringCellValue);
                    }
                }
            }
        }
        workbook.close();
    }

    @Test
    public void test3() throws Exception{
        XSSFWorkbook workbook =new XSSFWorkbook();
        XSSFSheet sheet =workbook.createSheet("工作表1");
        //创建行
        XSSFRow row = sheet.createRow(0);
        //创建单元格
        row.createCell(0).setCellValue("Jay");
        row.createCell(1).setCellValue("Eason");
        row.createCell(2).setCellValue("lisa");

        //创建行
        XSSFRow row1 = sheet.createRow(1);
        //创建单元格
        row1.createCell(0).setCellValue("Jay");
        row1.createCell(1).setCellValue("Eason");
        row1.createCell(2).setCellValue("lisa");


        FileOutputStream out = new FileOutputStream("C:\\Users\\zhangpan\\Desktop\\项目二\\2.xlsx");
        workbook.write(out);
        out.flush();

        out.close();
        workbook.close();
    }


}

