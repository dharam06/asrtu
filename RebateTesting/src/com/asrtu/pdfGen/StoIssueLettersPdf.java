package com.asrtu.pdfGen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.asrtu.bean.RebateSearchCriteria;
import com.asrtu.bean.StoOrderFormBean;
import com.asrtu.bean.TestingChargeBean;
import com.asrtu.dao.RebateDaoImp;
import com.asrtu.model.Invoice;
import com.asrtu.model.RebateForm;
import com.asrtu.service.RebateService;
import com.asrtu.service.RebateServiceImp;
import com.asrtu.bean.InvoiceBean;
import com.asrtu.bean.RebateFormBean;
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
public class StoIssueLettersPdf {
	
	
	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 8 );

	public static Document createPDF(String file, List<StoOrderFormBean> stoOrderBean) {
		 
		Document document = null;
 
		try {
			document = new Document(PageSize.A4.rotate());
			
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
 
			addMetaData(document);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
 
			addTitlePage(document);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );

	        createTable(document, stoOrderBean);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        createFooter(document);

	        document.newPage();
	        
	        addTitlePage(document);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );

	        createTable1(document, stoOrderBean);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        createFooter(document);

	        
	        
	        document.newPage();
	        

	        addTitlePage(document);
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );

	        createTable2(document, stoOrderBean);
			

			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
			document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        document.add( Chunk.NEWLINE );
	        createFooter(document);
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
 
	private static void addTitlePage(Document document)
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
	
	
private static void createFooter(Document document) throws DocumentException  {
		
		Paragraph preface = new Paragraph();
		
		
	   Paragraph p11 = new Paragraph();
	    p11.add(new Chunk("Authorized Signatory",TIME_ROMAN_SMALL));
	    p11.setTabSettings(new TabSettings(250f));
	    p11.add(Chunk.TABBING);
	    p11.add(new Chunk("Authorized Signatory",TIME_ROMAN_SMALL));
	    
	    
	    preface.add(p11);
	    document.add(preface);

		}

 
	private static void createTable(Document document, List<StoOrderFormBean> StoOrderFormBeanList) throws DocumentException {

		Paragraph paragraph = new Paragraph();
		paragraph.add(new Paragraph("Sir,",TIME_ROMAN_SMALL));
		paragraph.add(new Paragraph("Sub.: Testing of random samples of "+StoOrderFormBeanList.get(0).getItemName()+ " of "+StoOrderFormBeanList.get(0).getVendorName(),TIME_ROMAN_SMALL));
		paragraph.add(new Paragraph("It was decided at the Executive Committee Meeting held at Mumbai on 19th August 1995 "
				+" to request the Chief Executives of the State Transport Undertakings for issuing suitable "
				+" instructions to their Technical Officers for completing the work of Sample Collection on priority. "
				+ StoOrderFormBeanList.get(0).getVendorName()+ "  have submitted their tender for supply of "+StoOrderFormBeanList.get(0).getItemName()
				+ " The firm has been requested vide this office letter dated August 5, 2017 (copy enclosed) to get "
				+ "in touch with your office and intimate the dates on which the firm will be in a position to offer" 
				+ "the samples from its production line for testing at CIRT, Pune, so that your Officers could visit "
				+ "the firm’s works at the following address: \n\n"
				+ StoOrderFormBeanList.get(0).getVendorAddress()
				+ "The details to be forwarded to the CIRT, Pune with a copy to this office are given at Annexure ‘Q’. All the annexure are enclosed. "
				+ "May we request you to kindly issue instructions to your Technical Officers to carry out sample collection on priority as per "
				+ "the details mentioned in the enclosed letter."
				+ "\n\n\n"
				+ "Thanking you,\n\n"
				+ "Yours faithfully,"
				+ "\n\n\n"
				+ "for Director (Technical)"
				+ "\n\n\n"
				+ "Documents attached: As above.",TIME_ROMAN_SMALL));
		document.add(paragraph);

	}
 
	private static void createTable1(Document document, List<StoOrderFormBean> StoOrderFormBeanList) throws DocumentException {

		Paragraph paragraph = new Paragraph();
		
		paragraph.add(new Paragraph(StoOrderFormBeanList.get(0).getVendorName() +" \n"
				+ StoOrderFormBeanList.get(0).getVendorAddress() +"\n"
						+ "Sub: Testing of random samples of "
						+ StoOrderFormBeanList.get(0).getItemName(),TIME_ROMAN_SMALL));
		
		
		paragraph.add(new Paragraph("Sir,",TIME_ROMAN_SMALL));
		paragraph.add(new Paragraph("Please refer to your quotation for the supply of above item\n",TIME_ROMAN_SMALL));
		paragraph.add(new Paragraph( "As per the policy decision of the Standing Committee (Supplies & Contracts), "
				+ "testing of random samples of your products/materials under the group offered "
				+ "by you in the above mentioned tender should be carried out at CIRT, Pune before consideration "
				+ "of your above referred tender. Please note that the cost of materials, testing charges, "
				+ "packing and forwarding charges, etc will be borne by you and that your offer shall be considered on" 
				+ "receipt of the sample test reports and works inspection report. Demand Draft Bearing no. 450631 dt.24/12/2014 for Rs.117642/- after "
				+ "cancelling STO Nos. C1527, C1528, C1529, C1530, C1531, C1532, C1533 &  C1534. drawn in favour of Executive Director, ASRTU, New Delhi" 
				+ "for Rs.117642/-  is received at ASRTU towards advance test charges. \n\n"
				+ "Following samples are proposed for testing at CIRT,"
				+ "Pune as per specification number mentioned"
				+ "below the item. Details of test charges and sample test order numbers are as under:"
				+ "\n\n\n",TIME_ROMAN_SMALL));
		document.add(paragraph);

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100);
		table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);
 
		PdfPCell c1 = new PdfPCell(new Phrase("Sl. No."));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Item Description"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Quantity per sample"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Test Charges(Rs.)"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Service Text@15%"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Total Test Charges(Rs.)"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Sample Test Order No."));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);
 
		Iterator<StoOrderFormBean> itr = StoOrderFormBeanList.iterator();
		StoOrderFormBean rb = null;
		Float totalTestChargeAmount = 0f;
		Float totalNetTestChargeAmount = 0f;
		Float totalTaxSum = 0f;
		
		
		for (int i=1; itr.hasNext(); i++){
			
			rb = itr.next();
			
			c1 = new PdfPCell(new Phrase(""+i, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	 
			c1 = new PdfPCell(new Phrase(rb.getItemName(), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase(rb.getQuantity()+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase(rb.getTestCharge()+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase((rb.getTestCharge()*18/100)+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(rb.getTestCharge() + (rb.getTestCharge()*18/100) +"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(rb.getStoId(), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	
		}
 
		document.add(table);
		Paragraph paragraph1 = new Paragraph();
		paragraph1.add(new Paragraph("Note: The samples not issued with sample test order numbers will not be tested by CIRT, Pune."
				+ " The Central Government has implemented the Goods & Service Tax w.e.f. 01/07/2017. Hence with effect from 01/07/2017 "
				+ "you are required to pay GST @ 18% in place of Service Tax @ 15%. Thus you are requested to obtain demand draft for Rs 4987/- (ignore, if already paid) drawn in favour of the Executive Director, ASRTU, New Delhi payable at New Delhi, so that sample test order numbers for rest of proposed samples can be issued by this office."
+ "For the purpose of sample sealing, you are requested to get in touch with the office of the Managing Director, "
+ "Uttarakhand Transport Corporation and intimate the dates on which you will be in a position to offer above mentioned samples from production line, so that officers from Uttarakhand Transport Corporation can visit your works accordingly."
+ "\n\n Uttarakhand Transport Corporation,"
+ "1, Raj Vihar Chakrata Road, Dehradun - 248 001,"
+ "Tel. Phones: 0135-2760478,  "
+ "Fax: 0135-2761866"
+ "\n\n Please note that the cost of materials, testing charges, packing and forwarding charges, etc will be borne by you."
+ "The random samples on behalf of ASRTU are to be jointly sealed by the representative of STU and the manufacturer or his representative. The samples are to be sent directly to the Director, Central Institute of Road Transport (Training & Research), Pune Nasik Road, Bhosari, Pune-411 026. Freight should be prepaid at the consigner’s end and the firm must take care of following points for dispatch of samples to CIRT, Pune-"
+ "The details of samples collected and sample test order numbers are to be forwarded to CIRT, Pune as per Annexure “Q” with a copy to Director (Technical), ASRTU, New Delhi."
+ "o	This letter no. & date, which is issued for testing of random samples of your products/materials."
+ "o	Details of samples sealed along with part nos.(wherever applicable), Specification no. and Quantity."
+ "o	Details of Test Charges paid at ASRTU and Sample Test Order Nos. issued by ASRTU are to be mentioned."
+ "o	Seal & Signature of the officer must be distinctly visible on the sample/carton while sending the random samples."
+ "•	The samples sealed by STU officers, should be sent to Director, CIRT, Pune within 15 days of sealing of samples. "
+ "•	The parcel of sealed samples should be sent by Courier/Road Transport Contract as Door Delivery basis to CIRT, Pune."
+ "•	Dispatch documents should invariably include a delivery challan/note. The consignment note or way bill or lorry receipt as well as the delivery note or challan would invariably be marked “sample for destructive testing only item of no commercial value” or a separate certificate to this effect should be sent with the consignment."
+ "\n\n•	Please note that as per the procedures laid down the samples once sent for testing to CIRT, will not be returned to the manufacturer. "
+ "\nYou are requested to offer random samples as per the details mentioned above.", TIME_ROMAN_SMALL));
document.add(paragraph1);
		
		Paragraph paragraph6 = new Paragraph();
		paragraph6.add(new Paragraph("Thanking You,\n"
				+"Yours faithfully,\n\n\n Sr. Asst. Director(Testing)\nEncl: Annexure  Q.", TIME_ROMAN_SMALL));
		document.add(paragraph6);
		
		
		
	}

	private static void createTable2 (Document document, List<StoOrderFormBean> StoOrderFormBeanList) throws DocumentException {

		Paragraph paragraph = new Paragraph();
		paragraph.add(new Paragraph("The Director,"
+ "Central Institute of Road Transport,"
+ "Bhosari, PUNE – 411 026.\n"
+ "Sub: Testing of random samples Clutch & Clutch Parts.\n"
+ "Sir,\n"
+ "It is proposed to test random samples of "+StoOrderFormBeanList.get(0).getItemName()+" from the production line of "
		+ StoOrderFormBeanList.get(0).getVendorName()+" The firm has paid Rs. 117642/- towards advance test charges drawn in favour of Executive Director, ASRTU, New Delhi towards testing of samples at CIRT, Pune.\n"
+ StoOrderFormBeanList.get(0).getVendorName()+" have been requested to get in touch with the Managing Director, Uttarakhand Transport Corporation to depute their officers to visit their works at address given below and seal samples.\n"
+ StoOrderFormBeanList.get(0).getVendorAddress()+ 
"\n\n The details of payment of advance Test Charges are as under –"
+ "Demand Draft No. 450631 dt.24/12/2014 for Rs.117642/- after cancelling STO Nos. C1527, C1528, C1529, C1530, C1531, C1532, C1533 &  C1534. drawn on SBI in favour of Executive Director, ASRTU, New Delhi for total Rs. 117642/-."
+ "Sample Test Order numbers C2938, C2939, C2940, C2941, C2942, C2943, C2944, ,  and  are issued for testing of the samples. The samples not issued with sample test order numbers need not be tested by CIRT, Pune, until sample test order numbers are issued.\n"
+ "Kindly arrange to test the samples and send the test reports to ASRTU.\n"
+ "Thanking you,\n	"
+ "Yours faithfully,\n"
+ "Sr. Asst. Director (Testing)\n"
+ "Copy to:	The Asst. Director (Finance),"
+ "    	ASRTU, New Delhi - the details of Test Charges are as under –\n"
+ "Demand Draft No. 450631 dt.24/12/2014 for Rs.117642/- after cancelling STO Nos. C1527, C1528, C1529, C1530, C1531, C1532, C1533 &  C1534. SBI in favour of Executive Director, ASRTU, New Delhi for Rs. 117642/- has already been deposited. The firm was requested to obtain demand draft for Rs. 4987/- in favour of the Executive Director, ASRTU, New Delhi payable at New Delhi, so that sample test order numbers for rest of the proposed samples can be issued by this office.\n\n\n"
,TIME_ROMAN_SMALL));
		document.add(paragraph);

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100);
		table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);
 
		PdfPCell c1 = new PdfPCell(new Phrase("Sl. No."));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Item Description"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Quantity per sample"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Test Charges(Rs.)"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("GST@18%"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Total Test Charges Rs."));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Sample Test Order No."));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);
 
		Iterator<StoOrderFormBean> itr = StoOrderFormBeanList.iterator();
		StoOrderFormBean rb = null;
		Float totalTestChargeAmount = 0f;
		Float totalNetTestChargeAmount = 0f;
		Float totalTaxSum = 0f;
		
		
		for (int i=1; itr.hasNext(); i++){
			
			rb = itr.next();
			
			c1 = new PdfPCell(new Phrase(""+i, TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	 
			c1 = new PdfPCell(new Phrase(rb.getItemName(), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase(rb.getQuantity()+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase(rb.getTestCharge()+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase((rb.getTestCharge()*18/100)+"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(rb.getTestCharge() + (rb.getTestCharge()*18/100) +"", TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(rb.getStoId(), TIME_ROMAN_SMALL));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
	
		}
 
		document.add(table);
		Paragraph paragraph1 = new Paragraph();
		paragraph1.add(new Paragraph("The Goods & Service Tax @18% is already paid by ASRTU \n\n"
				+"Name of the firm:	M/s KIE Engineering Pvt.Ltd.\n\n"
				+"Ref. letter no.:		ASRTU/TEST/F(35)/K274/247/14/ATR/\n\n"
				+"Gr./Sub-Group:	Clutch & Clutch Parts   \n\n",TIME_ROMAN_SMALL));
		document.add(paragraph1);
		Paragraph paragraph6 = new Paragraph();
		paragraph6.add(new Paragraph("Date	: "+Calendar.getInstance().getTime()+"							Sr. Asst. Director (Testing)", TIME_ROMAN_SMALL));
		document.add(paragraph6);
		
		
		
	}
	 public static void main(String args[]){  
	     System.out.println("Create PDF");  
	     RebateSearchCriteria bankReportsBean = new RebateSearchCriteria();
	    // createPDF("statement", rebateFormBean);
	    }  
 
	 

}
