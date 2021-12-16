package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pages.Base;
public class TestUtils extends Base{

	
	static String filepath="D:/MAN/EWorkspace/TestPageFac/inputData/data.xlsx";
@SuppressWarnings("resource")
public static  Object[][] readFile() throws IOException {
	Object[][] data = null;
	File file=new File(filepath);
			FileInputStream inputstream=new FileInputStream(file);
			Workbook book=null;
book =new XSSFWorkbook(inputstream);
Sheet booksheet=book.getSheet("abc");
int rowCount=booksheet.getLastRowNum();
System.out.println(rowCount);
data =new Object[booksheet.getLastRowNum()+1][booksheet.getRow(0).getLastCellNum()];
for(int i=0;i<rowCount+1;i++) {
	Row row=booksheet.getRow(i);
	for(int j=0;j<booksheet.getRow(0).getLastCellNum();j++) {
		data[i][j]=row.getCell(j).getStringCellValue();
		System.out.print(data[i][j]);
	}
	System.out.println();


}


return data;
}
public static void main(String[] args) throws IOException {
	readFile();
}
}
