package com.asrtu.pdfGen;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.asrtu.bean.RebateSearchCriteria;
import com.asrtu.dao.InvoiceDao;
import com.asrtu.dao.InvoiceDaoImpl;
import com.asrtu.dao.RebateDaoImp;
import com.asrtu.model.Invoice;
import com.asrtu.model.RebateForm;
import com.asrtu.service.InvoiceService;
import com.asrtu.service.InvoiceServiceImpl;
import com.asrtu.service.RebateService;
import com.asrtu.service.RebateServiceImp;
import com.asrtu.bean.InvoiceBean;
import com.asrtu.bean.OpeningBalance;
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

@Component
@Configurable
public class IncentiveRebateLedgerPDF {
	
	@Autowired
	private InvoiceService invoiceService;

	
	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 10 );

	public  Document createPDF(String file, List<RebateForm> rebateList, OpeningBalance openingBalance, RebateSearchCriteria rebateSearchCriteria) {
		 
		Document document = null;
 
		try {
			document = new Document(PageSize.A4.rotate());
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
 
			addMetaData(document);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
 
	        RebateForm rb = rebateList.get(0);
	        
			addTitlePage(document, rb);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
			createTable(document, rebateList, openingBalance, rebateSearchCriteria);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
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
 
	private static void addTitlePage(Document document,  RebateForm  rebateFormBean)
			throws DocumentException {
 
		Paragraph preface = new Paragraph();
	
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("ASSOCIATION OF STATE ROAD TRANSPORT UNDERTAKINGS", TIME_ROMAN));
		creteEmptyLine(preface, 1);

		Paragraph p = new Paragraph();
		p.add(new Chunk("ASRTU Bhawan",TIME_ROMAN_SMALL));
		p.setTabSettings(new TabSettings(250f));
	    p.add(Chunk.TABBING);
	    p.add(new Chunk("Phone : 011-43294294/200/299",TIME_ROMAN_SMALL));
	    preface.add(p);
		//preface.add(new Paragraph("Phone : 011-43294294/200/299",TIME_ROMAN_SMALL).setTabSettings(new TabSettings(10f)));
		creteEmptyLine(preface, 1);
		Paragraph p1 = new Paragraph();
		p1.add(new Chunk("Plot No. 4-A, PSP Block",TIME_ROMAN_SMALL));
		p1.setTabSettings(new TabSettings(280f));
	    p1.add(Chunk.TABBING);
	    p1.add(new Chunk(" : 011-25361640/41",TIME_ROMAN_SMALL));
		preface.add(p1);
		creteEmptyLine(preface, 1);
		Paragraph p2 = new Paragraph();
		p2.add(new Chunk("Pocket-14, Sector-8, Dwarka,",TIME_ROMAN_SMALL));
		p2.setTabSettings(new TabSettings(250f));
	    p2.add(Chunk.TABBING);
	    p2.add(new Chunk("Fax   : 011-43294242/241,25361642\n",TIME_ROMAN_SMALL));
		preface.add(p2);

		Paragraph p3 = new Paragraph();
		p3.add(new Chunk("New Delhi-110 077",TIME_ROMAN_SMALL));
		p3.setTabSettings(new TabSettings(250f));
	    p3.add(Chunk.TABBING);
	    p3.add(new Chunk("E-mail: asrtu@de12.vsnl.net.in\n",TIME_ROMAN_SMALL));
	    preface.add(p3);
 		creteEmptyLine(preface, 1);
 		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Paragraph p4 = new Paragraph();
		p4.add(new Chunk("ASRTU Service Tax No. AAAAA0233ASD005",TIME_ROMAN_SMALL));
		p4.setTabSettings(new TabSettings(250f));
	    p4.add(Chunk.TABBING);
	    p4.add(new Chunk("PAN No. AAAAA0233A"+ simpleDateFormat.format(new Date()),TIME_ROMAN_SMALL));
	    preface.add(p4);
	  
		 document.add(preface);
 
	}
 
	private static void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(""));
		}
	}
 
	private static void createBottom(Document document, RebateFormBean rebateFormBean) throws DocumentException  {
		
		Paragraph preface = new Paragraph();
		
		Paragraph p9 = new Paragraph();
	    p9.add(new Paragraph("Amount received dated"));
	   preface.add(p9);
	    document.add(preface);

		}
	
	
private static void createFooter(Document document, RebateForm rebateFormBean) throws DocumentException  {
		
		Paragraph preface = new Paragraph();
		
		
	   Paragraph p11 = new Paragraph();
	    p11.add(new Chunk("Authorized Signatory",TIME_ROMAN_SMALL));
	    p11.setTabSettings(new TabSettings(250f));
	    p11.add(Chunk.TABBING);
	    p11.add(new Chunk("Authorized Signatory",TIME_ROMAN_SMALL));
	    
	    
	    preface.add(p11);
	    document.add(preface);

		}

 
	private  void createTable(Document document, List<RebateForm> rebateFormBean, OpeningBalance openingBalance, RebateSearchCriteria rebateSearchCriteria) throws DocumentException {

		PdfPTable table = new PdfPTable(10);
		table.setWidthPercentage(100);
		table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);
        table.setWidths(new float[] { 1,3,3,3,4,3,3,3,3,3});
        
        String title = " Incentive Ledger :: ";

		if (null != rebateSearchCriteria.getFinanceYear()) {
			title = title + "  Finance Year: " + rebateSearchCriteria.getFinanceYear();
		}

		if (null != rebateSearchCriteria.getVendorName()) {
			title = title + "  Vendor Name: " + rebateSearchCriteria.getVendorName();
		}

		if (null != rebateSearchCriteria.getItemName()) {
			title = title + "  Item Name: " + rebateSearchCriteria.getItemName();
		}

        PdfPCell c1 = new PdfPCell(new Phrase(title, TIME_ROMAN_SMALL));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(10);
		table.addCell(c1);

        c1 = new PdfPCell(new Phrase("SNo.", TIME_ROMAN_SMALL));
		
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setRowspan(2);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Date", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setRowspan(2);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Op balance", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setRowspan(2);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Receipt details", TIME_ROMAN_SMALL));
		c1.setColspan(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Incentive due", TIME_ROMAN_SMALL));
		c1.setRowspan(2);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
			
		c1 = new PdfPCell(new Phrase("Incentive availed ", TIME_ROMAN_SMALL));
		c1.setRowspan(2);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Balance Incentive due", TIME_ROMAN_SMALL));
		c1.setRowspan(2);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		//Trans No	Quarter	Receipt date	Rebate Type	Amount

		
		c1 = new PdfPCell(new Phrase("Trans No", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Quarter", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Receipt date", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Rebate", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
				

		Iterator<RebateForm> itr = rebateFormBean.iterator();
		RebateForm rb = null;
		
for (int i=1; itr.hasNext(); i++){
			
			rb = itr.next();
			c1 = new PdfPCell(new Phrase(""+i, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	 
			c1 = new PdfPCell(new Phrase(""+formatDate(rb.getTransactionDate()), TIME_ROMAN_SMALL)); 
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	 
						
			c1 = new PdfPCell(new Phrase(""+openingBalance.getRebateBalance(), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	 

			c1 = new PdfPCell(new Phrase(rb.getTransactionNo(), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			//InvoiceDaoImpl invoiceService = new InvoiceDaoImpl();

			Invoice invoice = null;
			if(null != rb.getInvoiceNumber()){
				invoice = invoiceService.getInvoice(rb.getInvoiceNumber());
			} 
			
			if(null == invoice) {
				 invoice = invoiceService.getInvoice(1);
			}
			
			c1 = new PdfPCell(new Phrase(invoice.getQuarter(), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase(formatDate(rb.getReceiptDate()) + "", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(rb.getInvoicePayment() + "", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			Float incentiveDue = 0f;
			
			Calendar invoiceDay = Calendar.getInstance();
			invoiceDay.setTime(rb.getReceiptDate());
			invoiceDay.set(Calendar.DAY_OF_MONTH, invoiceDay.getActualMaximum(Calendar.DAY_OF_MONTH));
			
			Calendar qrtToDay = Calendar.getInstance();
			if(null != invoice.getQuarterToDate()){
				qrtToDay.setTime(invoice.getQuarterToDate());
			}
			
			invoiceDay.set(Calendar.HOUR_OF_DAY, 0);
			invoiceDay.set(Calendar.MINUTE, 0);
			invoiceDay.set(Calendar.SECOND, 0);
			invoiceDay.set(Calendar.MILLISECOND, 0);
	
			qrtToDay.set(Calendar.HOUR_OF_DAY, 0);
			qrtToDay.set(Calendar.MINUTE, 0);
			qrtToDay.set(Calendar.SECOND, 0);
			qrtToDay.set(Calendar.MILLISECOND, 0);
			
			long totalDaysForSt = TimeUnit.MILLISECONDS.toDays(
		        Math.abs(qrtToDay.getTimeInMillis() - invoiceDay.getTimeInMillis()));

			if(totalDaysForSt < 31){
				
				incentiveDue = 0.05f * rb.getInvoicePayment();
				
			}
			
// g= 5% of f (rebate)  if e(rcpt dt is within one month of end of quarter)
			
			DecimalFormat df = new DecimalFormat("0.00");

			c1 = new PdfPCell(new Phrase( df.format(incentiveDue) + "", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			Float intOnRebateInvoice = 0f;
			if(null != rb.getInterestOnRebateInvoice()){
				intOnRebateInvoice = rb.getInterestOnRebateInvoice();
				
			}
			
			c1 = new PdfPCell(new Phrase(df.format(intOnRebateInvoice)+ "", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			Float balanceIntDue = 0f;
			try{
				 balanceIntDue = openingBalance.getRebateBalance() + rb.getInvoicePayment() - rb.getInterestOnRebateInvoice();
			}catch(NullPointerException e){
				
			}
			
			c1 = new PdfPCell(new Phrase(df.format(balanceIntDue) + "", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);						
}
		
	
		
		
		document.add(table);
	}
 
	 public static void main(String args[]){  
	     System.out.println("Create PDF");  
	     RebateSearchCriteria bankReportsBean = new RebateSearchCriteria();
	    // createPDF("statement", rebateFormBean);
	    }  
 
		private Float getAmountByPerForDays(Float amount, long days, Float percentage){
			
			if(amount == null || percentage == null ) {
				return 0f;
			}
			
			else{
				
				return days*amount*percentage/36000;
			}
			
			
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
	 
}
