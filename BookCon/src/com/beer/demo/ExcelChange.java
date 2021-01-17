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
	     * 将file1拷贝后,进行修改并创建输出对象file2
	     * 
	     * 单元格原有的格式化修饰不能去掉，但仍可将新的单元格修饰加上去，
	     * 
	     * 以使单元格的内容以不同的形式表现
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

	            // 判断单元格的类型,做出相应的转换

	            if (wc.getType() == CellType.LABEL)

	            {

	                Label labelCF = new Label(1, 0, "人物（新）", wcfFC);

	                ws.addCell(labelCF);

	                Label label = (Label) wc;

	                label.setString("被修改");

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
