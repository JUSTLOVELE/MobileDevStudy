package excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExcel {

	@Test
	public void readExcelTest() {
		
		String filePath = "D:\\20191219.xlsx";
		
		try {
			
			InputStream input = new FileInputStream(filePath);
			XSSFWorkbook hw = new XSSFWorkbook(input);
			XSSFSheet sheet = hw.getSheetAt(0);
			int rownum = sheet.getPhysicalNumberOfRows();
			
			for (int i = 1; i < rownum; i++) {
				
				Row row = sheet.getRow(i);
				
				if (row != null) {
					
					row.getCell(0).setCellType(CellType.STRING);//ID
					row.getCell(1).setCellType(CellType.STRING);//机构名称
					row.getCell(2).setCellType(CellType.STRING);//注册号
					row.getCell(3).setCellType(CellType.STRING);//机构类型,门诊部,村所等等
					row.getCell(4).setCellType(CellType.STRING);//特殊名称
					row.getCell(5).setCellType(CellType.STRING);//区
					row.getCell(6).setCellType(CellType.STRING);//地址
					row.getCell(7).setCellType(CellType.STRING);//医院级别
					
					System.out.println(row.getCell(0).getStringCellValue());
					System.out.println(row.getCell(1).getStringCellValue());
					System.out.println(row.getCell(2).getStringCellValue());
					System.out.println(row.getCell(3).getStringCellValue());
					System.out.println(row.getCell(4).getStringCellValue());
					System.out.println(row.getCell(5).getStringCellValue());
					System.out.println(row.getCell(6).getStringCellValue());
					System.out.println(row.getCell(7).getStringCellValue());
					
//					String PROJECTCODE = row.getCell(0).getStringCellValue();
//					String NAME = row.getCell(1).getStringCellValue();
//					String CONNOTATION = row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "";
//					String EXCLUDEDONTENT = row.getCell(3) != null ? row.getCell(3).getStringCellValue() : "";
//					String VALUATIONNUNIT = row.getCell(4) != null ? row.getCell(4).getStringCellValue() : "";
//					String THREE = row.getCell(5) != null ? row.getCell(5).getStringCellValue() : "";
//					String BELOWTHREE = row.getCell(6) != null ? row.getCell(6).getStringCellValue() : "";
//					String INSTRUCTION = row.getCell(7) != null ? row.getCell(7).getStringCellValue() : "";
//					String T = row.getCell(8) != null ? row.getCell(8).getStringCellValue() : "";
//					int type = -1;
//					
//					if(T.contains("一般医疗服务")) {
//						type = 1;
//					}else if(T.contains("医技诊疗类")) {
//						type = 2;
//					}else if(T.contains("临床诊疗类")) {
//						type = 3;
//					}else if(T.contains("中医类")) {
//						type = 4;
//					}else if(T.contains("过渡期项目")) {
//						type = 5;
//					}
//					
//					String sql = "insert into medicaserviceprice (" +
//					" ID, CODE, PROJECTCODE, NAME, CONNOTATION, " + 
//					" EXCLUDEDONTENT, VALUATIONNUNIT, THREE, BELOWTHREE,INSTRUCTION," + 
//					" TYPE)" + 
//					" value(" + i + " , 'bf0d75ebdf434a73be8bff8ca05dc24f', '" + PROJECTCODE + "', '" + NAME + "', '" + CONNOTATION + "'," +
//					"'" + EXCLUDEDONTENT + "','" + VALUATIONNUNIT + "', '" + THREE + "','" + BELOWTHREE + "','" + INSTRUCTION + "'," +
//					type + ")";
//					
//					System.out.println(sql);
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
