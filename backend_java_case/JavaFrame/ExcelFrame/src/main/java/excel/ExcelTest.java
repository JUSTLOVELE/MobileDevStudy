package excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ExcelTest {
	
	@Test
	public void insertData() {
		
		String filePath = "C:\\Users\\Administrator\\Desktop\\福建省医疗服务价格数据库编码1.xlsx";
		
		try {
			
			InputStream input = new FileInputStream(filePath);
			XSSFWorkbook hw = new XSSFWorkbook(input);
			XSSFSheet sheet = hw.getSheetAt(0);
			int rownum = sheet.getPhysicalNumberOfRows();
			
			for (int i = 1; i < rownum; i++) {
				
				Row row = sheet.getRow(i);
				
				if (row != null) {
					
					if(row.getCell(0) == null) {
						continue;
					}
					
					row.getCell(0).setCellType(CellType.STRING);//项目编码
					row.getCell(1).setCellType(CellType.STRING);//项目名称
					row.getCell(2).setCellType(CellType.STRING);//项目内涵
					row.getCell(3).setCellType(CellType.STRING);//除外内容
					row.getCell(4).setCellType(CellType.STRING);//计价单位
					row.getCell(5).setCellType(CellType.STRING);//医院等级
					row.getCell(6).setCellType(CellType.STRING);//医院地区级别
					row.getCell(7).setCellType(CellType.STRING);//说明
					row.getCell(8).setCellType(CellType.STRING);//类型;1:一般医疗服务;2:医技诊疗类;3:临床诊疗类;4:中医类;5:过渡期项目
					//System.out.println(row.getCell(0).getStringCellValue() + ";" + row.getCell(1).getStringCellValue());
					//System.out.println(row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "");
					//System.out.println(row.getCell(3) != null ? row.getCell(3).getStringCellValue() : "");
					//System.out.println(row.getCell(4) != null ? row.getCell(4).getStringCellValue() : "");
					//System.out.println(row.getCell(5) != null ? row.getCell(5).getStringCellValue() : "");
					//System.out.println(row.getCell(6) != null ? row.getCell(6).getStringCellValue() : "");
					//System.out.println(row.getCell(7) != null ? row.getCell(7).getStringCellValue() : "");
					//System.out.println(row.getCell(8) != null ? row.getCell(8).getStringCellValue() : "");
					String PROJECTCODE = row.getCell(0).getStringCellValue();
					String NAME = row.getCell(1).getStringCellValue();
					String CONNOTATION = row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "";
					String EXCLUDEDONTENT = row.getCell(3) != null ? row.getCell(3).getStringCellValue() : "";
					String VALUATIONNUNIT = row.getCell(4) != null ? row.getCell(4).getStringCellValue() : "";
					String THREE = row.getCell(5) != null ? row.getCell(5).getStringCellValue() : "";
					String BELOWTHREE = row.getCell(6) != null ? row.getCell(6).getStringCellValue() : "";
					String INSTRUCTION = row.getCell(7) != null ? row.getCell(7).getStringCellValue() : "";
					String T = row.getCell(8) != null ? row.getCell(8).getStringCellValue() : "";
					int type = -1;
					
					if(T.contains("一般医疗服务")) {
						type = 1;
					}else if(T.contains("医技诊疗类")) {
						type = 2;
					}else if(T.contains("临床诊疗类")) {
						type = 3;
					}else if(T.contains("中医类")) {
						type = 4;
					}else if(T.contains("过渡期项目")) {
						type = 5;
					}
					
					String sql = "insert into medicaserviceprice (" +
					" ID, CODE, PROJECTCODE, NAME, CONNOTATION, " + 
					" EXCLUDEDONTENT, VALUATIONNUNIT, THREE, BELOWTHREE,INSTRUCTION," + 
					" TYPE)" + 
					" value(" + i + " , 'bf0d75ebdf434a73be8bff8ca05dc24f', '" + PROJECTCODE + "', '" + NAME + "', '" + CONNOTATION + "'," +
					"'" + EXCLUDEDONTENT + "','" + VALUATIONNUNIT + "', '" + THREE + "','" + BELOWTHREE + "','" + INSTRUCTION + "'," +
					type + ")";
					
					System.out.println(sql);
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createExcel() {

		try {

			String filePath = "D:\\2.xlsx";
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("报表");
			XSSFCellStyle style = wb.createCellStyle();
			// 设置style---cell中水平的对齐方式
			style.setAlignment(HorizontalAlignment.CENTER);
			// 设置style---cell中垂直方向的对齐方式
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue("test1");
			cell.setCellStyle(style);
			FileOutputStream outputStream = new FileOutputStream(filePath);
			wb.write(outputStream);
			outputStream.flush();
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Test
	public void work() {
		
		try {
			
			InputStream input = new FileInputStream("D:\\20191219.xlsx");
			XSSFWorkbook hw = new XSSFWorkbook(input);
			XSSFSheet sheet = hw.getSheetAt(0);
			int rownum = sheet.getPhysicalNumberOfRows();
			XSSFWorkbook newEcel = new XSSFWorkbook();
			XSSFSheet newSheet = newEcel.createSheet("名单");
			XSSFRow newRow0 = newSheet.createRow(0);
			newRow0.createCell(0).setCellValue("医院");
			newRow0.createCell(1).setCellValue("科室");
			newRow0.createCell(2).setCellValue("医生");
			newRow0.createCell(3).setCellValue("职称");
			newRow0.createCell(4).setCellValue("职务");
			newRow0.createCell(5).setCellValue("电话号码");
			newRow0.createCell(6).setCellValue("执业证书编号");
			
			for (int i = 1; i < rownum; i++) {
				
				Row row = sheet.getRow(i);
				String hostipal = row.getCell(2).getStringCellValue().trim();
				String name = row.getCell(3).getStringCellValue().trim();
				String ZC = row.getCell(7).getStringCellValue().trim();
				String ZW = row.getCell(8).getStringCellValue().trim();
				row.getCell(9).setCellType(CellType.STRING);
				String phone = row.getCell(9).getStringCellValue().trim();
				System.out.println(hostipal + "," + name + "," + ZC + "," + ZW + "," + phone);
				XSSFRow newRow = newSheet.createRow(i);
				newRow.createCell(0).setCellValue(hostipal);
				newRow.createCell(1).setCellValue("神经外科");
				newRow.createCell(2).setCellValue(name);
				newRow.createCell(3).setCellValue(ZC);
				newRow.createCell(4).setCellValue(ZW);
				newRow.createCell(5).setCellValue(phone);
				newRow.createCell(6).setCellValue("执业证书编号");
			}
			
			FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\add.xlsx"));
			newEcel.write(out);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
