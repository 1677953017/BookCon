package com.beer.demo;
import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import jxl.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.DateTime;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class ExcelDao {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	//获取指定列的值
	readSpecifyColumns(new File("E://bookinformation.xls"));
	//获取指定行的值
	readSpecifyRows(new File("E://bookinformation.xls"));
	//读取行列的值
	readRowsAndColums(new File("E://bookinformation.xls"));
	//修改表
	//updateExcel(new File("E://bookinformation.xls"));
		} 
catch (Exception e) {
			e.printStackTrace();
			System.out.print("获取失败");
		}
	}	 
	//读取指定列
	public static void readSpecifyColumns(File file)throws Exception{
		//Scanner scanner=new Scanner(System.in);
		//System.out.println("请输入书名");
		//int s=scanner.nextInt();
		//String s=scanner.next();
		ArrayList<String> columnList = new ArrayList<String>();
		ArrayList<String> valueList = new ArrayList<String>();
		ArrayList<String> writerList = new ArrayList<String>();
		ArrayList<String> timeList = new ArrayList<String>();
		
		Workbook readwb = null;
		InputStream io = new FileInputStream(file.getAbsoluteFile());
		readwb = Workbook.getWorkbook(io);
		Sheet readsheet = readwb.getSheet(0);
		int rsColumns = readsheet.getColumns();  //获取表格列数
		int rsRows = readsheet.getRows();  //获取表格行数
		for (int i = 1; i < rsRows; i++) {
			Cell cell_name = readsheet.getCell(0, i);  //第一列的值
			columnList.add(cell_name.getContents());
			Cell cell_writer = readsheet.getCell(1, i);  //第二列的值
			writerList.add(cell_writer.getContents());
			Cell cell_value = readsheet.getCell(2, i);  //第三列的值，此处需要手动更改，获取不同列的值
			valueList.add(cell_value.getContents());
			Cell cell_time=readsheet.getCell(3,i);
			timeList.add(cell_time.getContents());
		}
		//System.out.println(columnList);
		//System.out.println(writerList);
		//System.out.println(valueList);
		//System.out.println(timeList);
		
		String[] name_String = new String[columnList.size()];
		String[] writer_String=new String[columnList.size()];
		String[] value_String = new String[columnList.size()];
		String[] time_String = new String[columnList.size()];
		/*for (int i = 0; i < columnList.size(); i++) {
			name_String[i] = columnList.get(i);
			value_String[i] = valueList.get(i);
			System.out.println("<string name=" + "\"" + name_String[i] + "\">" + value_String[i] +  "</string>");
		}	*/
		for(int i=0;i<columnList.size();i++) {
			name_String[i] = columnList.get(i);
			writer_String[i]=writerList.get(i);
			value_String[i] = valueList.get(i);
			time_String[i]=timeList.get(i);
			if(name_String[i].equals("人间失格")) {
				//System.out.println(i);
				System.out.println("作者："+writer_String[i]);
				System.out.println("借阅人：       "+value_String[i]);
				System.out.println("借阅时间："+time_String[i]);
				break;	
			}
		}
	}
	//读取指定行
	public static void readSpecifyRows(File file)throws Exception{
		ArrayList<String> columnList = new ArrayList<String>();
		Workbook readwb = null;
		InputStream io = new FileInputStream(file.getAbsoluteFile());
		readwb = Workbook.getWorkbook(io);
		Sheet readsheet = readwb.getSheet(0);
		int rsColumns = readsheet.getColumns();  //获取表格列数
		int rsRows = readsheet.getRows();  //获取表格行数
		for (int i = 1; i < rsColumns; i++) {
			Cell cell_name = readsheet.getCell(i, 1);  //在这里指定行，此处需要手动更改，获取不同行的值
			columnList.add(cell_name.getContents());
		}
		//System.out.println(columnList);
	}

	private static void readRowsAndColums(File file) throws BiffException, IOException {
		//1:创建workbook
        Workbook workbook=Workbook.getWorkbook(new File("E://bookinformation.xls")); 
        //2:获取第一个工作表sheet
        Sheet sheet=workbook.getSheet(0);
        //3:获取数据
       // System.out.println("行："+sheet.getRows());
       // System.out.println("列："+sheet.getColumns());
        for(int i=1;i<sheet.getRows();i++){//行
            for(int j=0;j<sheet.getColumns();j++){//列
                Cell cell=sheet.getCell(j,i);    
                //System.out.print(cell.getContents()+" ");
            }
            //System.out.println();
        }        
        //最后一步：关闭资源
        workbook.close();
	}
}

	/*

	//修改
	private static void updateExcel(File file) throws BiffException,IOException {
		// TODO Auto-generated method stub
		//获得Excel文件
		try{
		Workbook workbook = Workbook.getWorkbook(new File("E://bookinformation.xls"));
		//打开一个文件副本，并且指定数据写回到原文件
		WritableWorkbook book = Workbook.createWorkbook(new File("E://bookinformation2.xls"), workbook);
		//读取第一个sheet
		WritableSheet sheet=book.getSheet(0);
		//读取即将修改的cell
		WritableCell cell=sheet.getWritableCell(2,1);
		//获取cell格式
		jxl.format.CellFormat cf=cell.getCellFormat();
		Label label=new Label(10,10,"String");
		//添加到工具表
		sheet.addCell(label); 
		//生成保存日期
		DateTime dtime=new DateTime(9,9,new Date());
		
		book.write();
		book.close();
	}
		catch (Exception e) {          
		System.out.println(e);  
		}
		
}

*/

/*
	 * jxl实现excel读取并输出

	 * 读取excel修改之后重新输出

	 */
/*
	public static void ModifyExcelAndOutput() {
		try {
			File file=new File("C:\\Users\\Administrator\\Desktop\\excels\\example.xls");
			//这里读出来的workbook作为模版
			Workbook workbook=Workbook.getWorkbook(file);
			//这里是将要输出的workbook
			for(int i=0;i<2;i++){//这里模拟输出两个文件
				//输出文件名
				String outFileName="C:\\Users\\Administrator\\Desktop\\excels\\output"+i+".xls";
				// jxl.Workbook 对象是只读的，所以如果要修改Excel，需要创建一个可读的副本，副本指向原Excel文件（即下面的new File(excelpath)）  

				//WritableWorkbook如果直接createWorkbook模版文件会覆盖原有的文件

				WritableWorkbook writeBook=Workbook.createWorkbook(new File(outFileName),workbook); 
				//读取第一个sheet

				WritableSheet sheet=writeBook.getSheet(0);
				//读取将要修改的cell

				WritableCell cell=sheet.getWritableCell(2, 1);
				//获取上一部cell的格式

				jxl.format.CellFormat cf=cell.getCellFormat();
				Label lable=new Label(2, 1, "商户名称：修改后的商户名"+i);
				//将修改后的单元格格式设置成和原来一样的
				lable.setCellFormat(cf);
				//将修改后的cell放回sheet中
				sheet.addCell(lable);
				writeBook.write();
				writeBook.close();

			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	
