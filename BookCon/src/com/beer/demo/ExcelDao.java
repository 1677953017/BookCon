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
	//��ȡָ���е�ֵ
	readSpecifyColumns(new File("E://bookinformation.xls"));
	//��ȡָ���е�ֵ
	readSpecifyRows(new File("E://bookinformation.xls"));
	//��ȡ���е�ֵ
	readRowsAndColums(new File("E://bookinformation.xls"));
	//�޸ı�
	//updateExcel(new File("E://bookinformation.xls"));
		} 
catch (Exception e) {
			e.printStackTrace();
			System.out.print("��ȡʧ��");
		}
	}	 
	//��ȡָ����
	public static void readSpecifyColumns(File file)throws Exception{
		//Scanner scanner=new Scanner(System.in);
		//System.out.println("����������");
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
		int rsColumns = readsheet.getColumns();  //��ȡ�������
		int rsRows = readsheet.getRows();  //��ȡ�������
		for (int i = 1; i < rsRows; i++) {
			Cell cell_name = readsheet.getCell(0, i);  //��һ�е�ֵ
			columnList.add(cell_name.getContents());
			Cell cell_writer = readsheet.getCell(1, i);  //�ڶ��е�ֵ
			writerList.add(cell_writer.getContents());
			Cell cell_value = readsheet.getCell(2, i);  //�����е�ֵ���˴���Ҫ�ֶ����ģ���ȡ��ͬ�е�ֵ
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
			if(name_String[i].equals("�˼�ʧ��")) {
				//System.out.println(i);
				System.out.println("���ߣ�"+writer_String[i]);
				System.out.println("�����ˣ�       "+value_String[i]);
				System.out.println("����ʱ�䣺"+time_String[i]);
				break;	
			}
		}
	}
	//��ȡָ����
	public static void readSpecifyRows(File file)throws Exception{
		ArrayList<String> columnList = new ArrayList<String>();
		Workbook readwb = null;
		InputStream io = new FileInputStream(file.getAbsoluteFile());
		readwb = Workbook.getWorkbook(io);
		Sheet readsheet = readwb.getSheet(0);
		int rsColumns = readsheet.getColumns();  //��ȡ�������
		int rsRows = readsheet.getRows();  //��ȡ�������
		for (int i = 1; i < rsColumns; i++) {
			Cell cell_name = readsheet.getCell(i, 1);  //������ָ���У��˴���Ҫ�ֶ����ģ���ȡ��ͬ�е�ֵ
			columnList.add(cell_name.getContents());
		}
		//System.out.println(columnList);
	}

	private static void readRowsAndColums(File file) throws BiffException, IOException {
		//1:����workbook
        Workbook workbook=Workbook.getWorkbook(new File("E://bookinformation.xls")); 
        //2:��ȡ��һ��������sheet
        Sheet sheet=workbook.getSheet(0);
        //3:��ȡ����
       // System.out.println("�У�"+sheet.getRows());
       // System.out.println("�У�"+sheet.getColumns());
        for(int i=1;i<sheet.getRows();i++){//��
            for(int j=0;j<sheet.getColumns();j++){//��
                Cell cell=sheet.getCell(j,i);    
                //System.out.print(cell.getContents()+" ");
            }
            //System.out.println();
        }        
        //���һ�����ر���Դ
        workbook.close();
	}
}

	/*

	//�޸�
	private static void updateExcel(File file) throws BiffException,IOException {
		// TODO Auto-generated method stub
		//���Excel�ļ�
		try{
		Workbook workbook = Workbook.getWorkbook(new File("E://bookinformation.xls"));
		//��һ���ļ�����������ָ������д�ص�ԭ�ļ�
		WritableWorkbook book = Workbook.createWorkbook(new File("E://bookinformation2.xls"), workbook);
		//��ȡ��һ��sheet
		WritableSheet sheet=book.getSheet(0);
		//��ȡ�����޸ĵ�cell
		WritableCell cell=sheet.getWritableCell(2,1);
		//��ȡcell��ʽ
		jxl.format.CellFormat cf=cell.getCellFormat();
		Label label=new Label(10,10,"String");
		//��ӵ����߱�
		sheet.addCell(label); 
		//���ɱ�������
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
	 * jxlʵ��excel��ȡ�����

	 * ��ȡexcel�޸�֮���������

	 */
/*
	public static void ModifyExcelAndOutput() {
		try {
			File file=new File("C:\\Users\\Administrator\\Desktop\\excels\\example.xls");
			//�����������workbook��Ϊģ��
			Workbook workbook=Workbook.getWorkbook(file);
			//�����ǽ�Ҫ�����workbook
			for(int i=0;i<2;i++){//����ģ����������ļ�
				//����ļ���
				String outFileName="C:\\Users\\Administrator\\Desktop\\excels\\output"+i+".xls";
				// jxl.Workbook ������ֻ���ģ��������Ҫ�޸�Excel����Ҫ����һ���ɶ��ĸ���������ָ��ԭExcel�ļ����������new File(excelpath)��  

				//WritableWorkbook���ֱ��createWorkbookģ���ļ��Ḳ��ԭ�е��ļ�

				WritableWorkbook writeBook=Workbook.createWorkbook(new File(outFileName),workbook); 
				//��ȡ��һ��sheet

				WritableSheet sheet=writeBook.getSheet(0);
				//��ȡ��Ҫ�޸ĵ�cell

				WritableCell cell=sheet.getWritableCell(2, 1);
				//��ȡ��һ��cell�ĸ�ʽ

				jxl.format.CellFormat cf=cell.getCellFormat();
				Label lable=new Label(2, 1, "�̻����ƣ��޸ĺ���̻���"+i);
				//���޸ĺ�ĵ�Ԫ���ʽ���óɺ�ԭ��һ����
				lable.setCellFormat(cf);
				//���޸ĺ��cell�Ż�sheet��
				sheet.addCell(lable);
				writeBook.write();
				writeBook.close();

			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	
