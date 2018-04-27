package com.asrtu.pdfGen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.asrtu.bean.RebateSearchCriteria;
import com.asrtu.dao.RebateDaoImp;
import com.asrtu.model.RebateForm;
import com.asrtu.service.RebateService;
import com.asrtu.service.RebateServiceImp;
import com.asrtu.bean.InvoiceBean;
import com.asrtu.bean.MisSearchResult;
import com.asrtu.bean.MisYearlyResult;
import com.asrtu.bean.RebateFormBean;
import com.asrtu.bean.RebateInvoiceBean;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;

public class MisYearlyPDF {

	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 10);

	public static Document createPDF(String file, List<MisYearlyResult> misYearlyResultList) {

		Document document = null;

		try {
			document = new Document(PageSize.A4.rotate());
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			addMetaData(document);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);

			MisYearlyResult rb = misYearlyResultList.get(0);

			addTitlePage(document, rb);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			createTable(document, misYearlyResultList);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			createFooter(document, rb);
			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

	private static void addMetaData(Document document) {
		document.addTitle("Statement PDF report");
		document.addSubject("Statement PDF report");
		document.addAuthor("ASRTU");
		document.addCreator("ASRTU");
	}

	private static void addTitlePage(Document document, MisYearlyResult misSearchResult) throws DocumentException {

		Paragraph preface = new Paragraph();

		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("ASSOCIATION OF STATE ROAD TRANSPORT UNDERTAKINGS", TIME_ROMAN));
		creteEmptyLine(preface, 1);

		Paragraph p = new Paragraph();
		p.add(new Chunk("ASRTU Bhawan", TIME_ROMAN_SMALL));
		p.setTabSettings(new TabSettings(250f));
		p.add(Chunk.TABBING);
		p.add(new Chunk("Phone : 011-43294294/200/299", TIME_ROMAN_SMALL));
		preface.add(p);
		// preface.add(new Paragraph("Phone :
		// 011-43294294/200/299",TIME_ROMAN_SMALL).setTabSettings(new
		// TabSettings(10f)));
		creteEmptyLine(preface, 1);
		Paragraph p1 = new Paragraph();
		p1.add(new Chunk("Plot No. 4-A, PSP Block", TIME_ROMAN_SMALL));
		p1.setTabSettings(new TabSettings(280f));
		p1.add(Chunk.TABBING);
		p1.add(new Chunk(" : 011-25361640/41", TIME_ROMAN_SMALL));
		preface.add(p1);
		creteEmptyLine(preface, 1);
		Paragraph p2 = new Paragraph();
		p2.add(new Chunk("Pocket-14, Sector-8, Dwarka,", TIME_ROMAN_SMALL));
		p2.setTabSettings(new TabSettings(250f));
		p2.add(Chunk.TABBING);
		p2.add(new Chunk("Fax   : 011-43294242/241,25361642\n", TIME_ROMAN_SMALL));
		preface.add(p2);

		Paragraph p3 = new Paragraph();
		p3.add(new Chunk("New Delhi-110 077", TIME_ROMAN_SMALL));
		p3.setTabSettings(new TabSettings(250f));
		p3.add(Chunk.TABBING);
		p3.add(new Chunk("E-mail: asrtu@de12.vsnl.net.in\n", TIME_ROMAN_SMALL));
		preface.add(p3);
		creteEmptyLine(preface, 1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Paragraph p4 = new Paragraph();
		p4.add(new Chunk("ASRTU Service Tax No. AAAAA0233ASD005", TIME_ROMAN_SMALL));
		p4.setTabSettings(new TabSettings(250f));
		p4.add(Chunk.TABBING);
		p4.add(new Chunk("PAN No. AAAAA0233A" + simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
		preface.add(p4);

		document.add(preface);

	}

	private static void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(""));
		}
	}

	private static void createBottom(Document document, RebateFormBean rebateFormBean) throws DocumentException {

		Paragraph preface = new Paragraph();

		Paragraph p9 = new Paragraph();
		p9.add(new Paragraph("Amount received dated"));
		preface.add(p9);
		document.add(preface);

	}

	private static void createFooter(Document document, MisYearlyResult misSearchResult) throws DocumentException {

		Paragraph preface = new Paragraph();

		Paragraph p11 = new Paragraph();
		p11.add(new Chunk("Authorized Signatory", TIME_ROMAN_SMALL));
		p11.setTabSettings(new TabSettings(250f));
		p11.add(Chunk.TABBING);
		p11.add(new Chunk("Authorized Signatory", TIME_ROMAN_SMALL));

		preface.add(p11);
		document.add(preface);

	}

	private static void createTable(Document document, List<MisYearlyResult> misSearchResultList)
			throws DocumentException {

		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100);
		table.setSpacingBefore(0f);
		table.setSpacingAfter(0f);
        table.setWidths(new float[] { 1,2,3,3,3,3,3,3});


		String title = "Yearly comparative Analysis ::  ";
		DecimalFormat df=new DecimalFormat("0");

		if(null != misSearchResultList.get(0).getFinanceYearName()){
			title = title + " Finance Year : " + misSearchResultList.get(0).getFinanceYearName();
		}

		PdfPCell c1 = new PdfPCell(new Phrase(title , TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(8);
		table.addCell(c1);

		
		c1 = new PdfPCell(new Phrase("SNo.", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setRowspan(2);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Month", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setRowspan(2);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Current FY", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(3);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Previous FY", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	c1.setColspan(2);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Cumulative Difference", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	c1.setRowspan(2);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Budgeted Cumulative", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Actual", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Actual Cumulative", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Actual", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Actual Cumulative", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		int i = 1;

		System.out.println(misSearchResultList.size());
		
		for (MisYearlyResult misSearchResult : misSearchResultList) {

			c1 = new PdfPCell(new Phrase("" + i, TIME_ROMAN_SMALL));
			i++;
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(misSearchResult.getMonthName(), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(df.format(misSearchResult.getBudgetCummulatitve()) +"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("" + df.format(misSearchResult.getCurrentYearRebate()), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("" + df.format(misSearchResult.getActualCummulatitve()), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("" + df.format(misSearchResult.getPrevYearRebate()), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("" + df.format(misSearchResult.getPrevCummulatitve()), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("" + df.format(misSearchResult.getCummulativeDifference()), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	
		}
		
		document.add(table);
	}
	
	private static String formatDate(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String dateString = "";
		
		if(null != date){
			dateString = sdf.format(date);
		System.out.println("==========" + dateString);
		}
		return dateString;
	}

	public static void main(String args[]) {
		System.out.println("Create PDF");
		RebateSearchCriteria bankReportsBean = new RebateSearchCriteria();
		// createPDF("statement", rebateFormBean);
	}

}
