package com.beer.demo;
	import java.io.File;
	import jxl.CellType;
	import jxl.Workbook;
	import jxl.format.UnderlineStyle;
	import jxl.write.Label;
	import jxl.write.WritableCell;
	import jxl.write.WritableCellFormat;
	import jxl.write.WritableFont;
	import jxl.write.WritableSheet;
	import jxl.write.WritableWorkbook;

	public class ExcelChange {

	    /**
	     * ��file1������,�����޸Ĳ������������file2
	     * 
	     * ��Ԫ��ԭ�еĸ�ʽ�����β���ȥ�������Կɽ��µĵ�Ԫ�����μ���ȥ��
	     * 
	     * ��ʹ��Ԫ��������Բ�ͬ����ʽ����
	     * 
	     */

	    public void modifyExcel(File file1, File file2)

	    {

	        try

	        {

	            Workbook rwb = Workbook.getWorkbook(file1);

	            WritableWorkbook wwb = Workbook.createWorkbook(file2, rwb);// copy

	            WritableFont wfc = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,

	                    UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);

	            WritableCellFormat wcfFC = new WritableCellFormat(wfc);

	            WritableSheet ws = wwb.getSheet(0);

	            WritableCell wc = ws.getWritableCell(0, 0);

	            // �жϵ�Ԫ�������,������Ӧ��ת��

	            if (wc.getType() == CellType.LABEL)

	            {

	                Label labelCF = new Label(1, 0, "����£�", wcfFC);

	                ws.addCell(labelCF);

	                Label label = (Label) wc;

	                label.setString("���޸�");

	            }

	            wwb.write();

	            wwb.close();

	            rwb.close();

	        }

	        catch (Exception e)

	        {

	            e.printStackTrace();

	        }

	    }
}
