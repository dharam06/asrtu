package com.asrtu.pdfGen;

import java.io.FileNotFoundException;
import com.asrtu.bean.RebateLedgerSearchResult;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.asrtu.bean.RebateSearchCriteria;
import com.asrtu.dao.RebateDaoImp;
import com.asrtu.model.Invoice;
import com.asrtu.model.RebateForm;
import com.asrtu.service.RebateService;
import com.asrtu.service.RebateServiceImp;
import com.asrtu.bean.InvoiceBean;
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
public class RebateLedgerPDF {
	
	
	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 6 );

	public static Document createPDF(String file, List<RebateLedgerSearchResult> rebateLedgerSearchResult) {
		 
		Document document = null;
 
		try {
			document = new Document(PageSize.A4.rotate());
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
 
			addMetaData(document);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
 
	        RebateLedgerSearchResult rb = rebateLedgerSearchResult.get(0);
	        
			addTitlePage(document, rb);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
			createTable(document, rebateLedgerSearchResult);
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
 
	private static void addTitlePage(Document document,  RebateLedgerSearchResult  rebateFormBean)
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
	
	
private static void createFooter(Document document, RebateLedgerSearchResult rebateFormBean) throws DocumentException  {
		
		Paragraph preface = new Paragraph();
		
		
	   Paragraph p11 = new Paragraph();
	    p11.add(new Chunk("Authorized Signatory",TIME_ROMAN_SMALL));
	    p11.setTabSettings(new TabSettings(250f));
	    p11.add(Chunk.TABBING);
	    p11.add(new Chunk("Authorized Signatory",TIME_ROMAN_SMALL));
	    
	    
	    preface.add(p11);
	    document.add(preface);

		}

 
	private static void createTable(Document document, List<RebateLedgerSearchResult> rebateFormBean) throws DocumentException {

		PdfPTable table = new PdfPTable(19);
		table.setWidthPercentage(100);
		table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);
        table.setWidths(new float[] { 1,2,1,1,1,1,3,2,2,2,1,1,3,2,2,2,2,2,2});
        
        String title = "Rebate Ledger :: ";
        
        if(null != rebateFormBean.get(0).getFinacialYear()){
        	title = title + "  Finance Year: " + rebateFormBean.get(0).getFinacialYear();
        }
        
        if(null != rebateFormBean.get(0).getVendorName()){
        	title = title + "  Vendor Name: "+rebateFormBean.get(0).getVendorName();
        }

        if(null != rebateFormBean.get(0).getItemName()){
        	title = title + "  Item Name: "+rebateFormBean.get(0).getItemName();
        }

        PdfPCell c1 = new PdfPCell(new Phrase(title, TIME_ROMAN_SMALL));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(19);
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
		c1.setColspan(3);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Invoice Details ", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(5);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Receipt details", TIME_ROMAN_SMALL));
		c1.setColspan(6);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
			
		c1 = new PdfPCell(new Phrase("Due Amount ", TIME_ROMAN_SMALL));
		c1.setColspan(3);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
				
		c1 = new PdfPCell(new Phrase("Rebate", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Tax", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Total", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Invoice No", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Quarter", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Rebate", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Tax", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Total", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Trans No", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Invoice No", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Quarter", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Rebate", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Tax", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Total", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Rebate", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Tax", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);

c1 = new PdfPCell(new Phrase("Total", TIME_ROMAN_SMALL));
		c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c1);
		

		Iterator<RebateLedgerSearchResult> itr = rebateFormBean.iterator();
		RebateLedgerSearchResult rb = null;
		
for (int i=1; itr.hasNext(); i++){
			
			rb = itr.next();
			c1 = new PdfPCell(new Phrase(""+i, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	 
			c1 = new PdfPCell(new Phrase(""+formatDate(rb.getTransactionDate()), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			// c
			c1 = new PdfPCell(new Phrase(rb.getOpeningBalance().getRebateBalance()+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			// d 
			c1 = new PdfPCell(new Phrase(rb.getOpeningBalance().getTaxBalance()+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase(rb.getOpeningBalance().getTotal()+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			String invoiceIds = "";
			for(Invoice invoice : rb.getInvoiceList()){
				invoiceIds = invoiceIds + invoice.getAsrtuInvoiceNumber() + "\n ";
				
			}
			
			c1 = new PdfPCell(new Phrase(invoiceIds, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);


			String quarters = "";
			for(Invoice invoice : rb.getInvoiceList()){
				quarters = quarters + invoice.getQuarter()+ "\n ";
				
			}
			
			c1 = new PdfPCell(new Phrase(quarters, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			// h
			String rebateAmounts = "";
			Float rebateAmountSum=0f;
			for(Invoice invoice : rb.getInvoiceList()){
				rebateAmounts = rebateAmounts + invoice.getAmount()+ "\n ";
				rebateAmountSum = rebateAmountSum + invoice.getAmount();
				
			}
			
			//h
			c1 = new PdfPCell(new Phrase(rebateAmounts, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);


			String rebateTaxes = "";
			Float rebateTaxesSum=0f;
			for(Invoice invoice : rb.getInvoiceList()){
				rebateTaxes = rebateTaxes + invoice.getTotalTax()+ "\n ";
				rebateTaxesSum = rebateTaxesSum + invoice.getTotalTax();
				
			}
			
			//i
			c1 = new PdfPCell(new Phrase(rebateTaxes, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			// Total  j=h+i
			c1 = new PdfPCell(new Phrase((rebateAmountSum+rebateTaxesSum)+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			String rebateIds = "";
			for(RebateForm rebateForm : rb.getRebateForm()){
				rebateIds = rebateIds + rebateForm.getReceiptNo() + "\n ";
				
			}
			
			c1 = new PdfPCell(new Phrase(rebateIds, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);


			String rebateInvoiceIds = "";
			for(RebateForm rebateForm : rb.getRebateForm()){
				rebateInvoiceIds = rebateInvoiceIds + rebateForm.getInvoiceNumber() + "\n ";
				
			}
			
			c1 = new PdfPCell(new Phrase(rebateInvoiceIds, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			String rebateInvoiceQtrs = "";
			for(RebateForm rebateForm : rb.getRebateForm()){
				rebateInvoiceQtrs = rebateInvoiceQtrs + rebateForm.getQfdate()+ "\n ";
				
			}
			
			c1 = new PdfPCell(new Phrase(rebateInvoiceQtrs, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			//n
			String rebates = "";
			Float rebatesSum = 0f;
			for(RebateForm rebateForm : rb.getRebateForm()){
				rebates = rebates + rebateForm.getInvoicePayment()+ "\n ";
				rebatesSum = rebatesSum + rebateForm.getInvoicePayment();
				
			}
			
			//n
			c1 = new PdfPCell(new Phrase(rebates, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			String rebateTaxs = "";
			Float rebateTaxsSum = 0f;
			for(RebateForm rebateForm : rb.getRebateForm()){
				rebateTaxs = rebateTaxs + rebateForm.getTdsAmount()+ "\n ";
				rebateTaxsSum = rebateTaxsSum + rebateForm.getTdsAmount();
				
			}
			
			//o
			c1 = new PdfPCell(new Phrase(rebateTaxs, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			// Total p=n+o

			c1 = new PdfPCell(new Phrase((rebatesSum + rebateTaxsSum)+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			//q=c+h-n 

			Float q = rb.getOpeningBalance().getRebateBalance() + rebateAmountSum - rebatesSum;
			
			c1 = new PdfPCell(new Phrase( q +"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			//r=d+i-o

			Float r = rb.getOpeningBalance().getTaxBalance() + rebateTaxesSum - rebateTaxsSum;
			
			c1 = new PdfPCell(new Phrase( r +"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			// s= q+r
			c1 = new PdfPCell(new Phrase((q + r) +"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
}	
		document.add(table);
	}
	
	private static String formatDate(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String dateString = sdf.format(date);
		System.out.println("==========" + dateString);

		return dateString;
	}
 
	 public static void main(String args[]){  
	     System.out.println("Create PDF");  
	     RebateSearchCriteria bankReportsBean = new RebateSearchCriteria();
	    // createPDF("statement", rebateFormBean);
	    }  
 

}
