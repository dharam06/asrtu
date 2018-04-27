package com.asrtu.pdfGen;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class CreatePDF {
	
	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 12 );
 
	/**
	 * @param args
	 */
	public static Document createPDF(String file) {
 
		Document document = null;
 
		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
 
			addMetaData(document);
 
			addTitlePage(document);
 
			createTable(document);
 
			document.close();
 
		} catch (FileNotFoundException e) {
 
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
 
	}
 
	private static void addMetaData(Document document) {
		document.addTitle("Generate PDF report");
		document.addSubject("Generate PDF report");
		document.addAuthor("Shamsher");
		document.addCreator("Shamsher");
	}
 
	private static void addTitlePage(Document document)
			throws DocumentException {
 
		Paragraph preface = new Paragraph();
	
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("ASSOCIATION OF STATE ROAD TRANSPORT UNDERTAKINGS", TIME_ROMAN));
		creteEmptyLine(preface, 1);
		//preface.add(new Paragraph("ASRTU Bhawan",TIME_ROMAN_SMALL));
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
		//preface.add(new Paragraph("Pocket-14, Sector-8, Dwarka,	\t\t\t Fax   : 011-43294242/241,25361642\n",TIME_ROMAN_SMALL));
		
		//preface.add(new Paragraph("New Delhi-110 077	\t\t\t	E-mail: asrtu@de12.vsnl.net.in\n",TIME_ROMAN_SMALL));
		Paragraph p3 = new Paragraph();
		p3.add(new Chunk("New Delhi-110 077",TIME_ROMAN_SMALL));
		p3.setTabSettings(new TabSettings(250f));
	    p3.add(Chunk.TABBING);
	    p3.add(new Chunk("E-mail: asrtu@de12.vsnl.net.in\n",TIME_ROMAN_SMALL));
	    preface.add(p3);
 		creteEmptyLine(preface, 1);
 		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Paragraph p4 = new Paragraph();
		p4.add(new Chunk("Ref.: ASRTU/TEST/F(35)/A625/243/M21/ATR",TIME_ROMAN_SMALL));
		p4.setTabSettings(new TabSettings(250f));
	    p4.add(Chunk.TABBING);
	    p4.add(new Chunk("Date:"+ simpleDateFormat.format(new Date()),TIME_ROMAN_SMALL));
	    preface.add(p4);
	  
		//preface.add(new Paragraph("\tRef.: ASRTU/TEST/F(35)/A625/243/M21/ATR \t\t\tDate:"+ simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
	    Paragraph p5 = new Paragraph();
	    p5.add(new Paragraph("M/s Anunag Enterprises\n"
	    		+"#562,Near 9th ''D Main Road",TIME_ROMAN_SMALL));
	   preface.add(p5);
	   Paragraph p6 = new Paragraph();
	    p6.add(new Paragraph("Sub: Testing of random samples of LED Based Lights for Bus Body & othe Applications."
	    		+"",TIME_ROMAN_SMALL));
	   preface.add(p6);
	    document.add(preface);
 
	}
 
	private static void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(""));
		}
	}
 
	private static void createTable(Document document) throws DocumentException {
		Paragraph paragraph = new Paragraph();
		paragraph.add(new Paragraph("Sir,",TIME_ROMAN));
		paragraph.add(new Paragraph("Please refer to your quotation for the supply of above item\n",TIME_ROMAN_SMALL));
		paragraph.add(new Paragraph("As per the policy decision of the Standing Committee(Supplies &Contrscts), "
				+ "testing of random samples of your products/materials under the group offered by you in the above mentioned tender "
+"should be carried out at CIRT, Pune before consideration of your above referred tender. Please note"
+"that the cost of materials, testing changes, packing and forwarding changes etc will be borne by you"+
"and that your offer shall be considered on receipt of the sample test reports and works inspection "+
"report.Demand Draft Bearing no. 634135 dt.06/06/2016 drawn in favour of Executive Director,ASRTU,"
+ " New Delhi for Rs. 42938/- is received at ASRTU towards advance test charges."
+ "Following samples are proposed for testing t CIRT, Pune as per specification number mentioned "
+ "below the item. Details of test changes and sample test order numbers are as under.\n\n",TIME_ROMAN_SMALL));
		document.add(paragraph);
		PdfPTable table = new PdfPTable(7);
 
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
 
		for (int i = 0; i < 5; i++) {
			table.setWidthPercentage(100);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell("ShamSher");
			table.addCell("khan");
			table.addCell("Success");
			table.addCell("1");
			table.addCell("2");
			table.addCell("3");
			table.addCell("4");
		}
 
		document.add(table);
		Paragraph paragraph1 = new Paragraph();
		paragraph1.add(new Paragraph("Note:The samples not issued with sample test order numbers will not be tested by CIRT, Pune. "
				+ "You are requested to obtain demand draft for Rs 187/-(ignore, if already paid) drawn in facour of the "
				+"Executive Director, ASRTU, New Delhi payable at New Delhi, so that sample test order numbers for "
				+"rest of proposed samples can be issued by this office.",TIME_ROMAN_SMALL));
		document.add(paragraph1);
		Paragraph paragraph2 = new Paragraph();
		paragraph2.getFont().isBold();
		paragraph2.add(new Paragraph("Note: Service Tex rate goes up from 14.5% to 15% w.e.f. 01/06/2016(i.e. Krishi Kalyan Cess of 0.5% of the value of taxable services on which service tax is payable).Thus, you are requested to obtain demand draft for Rs.187/- in favour of the executive Director, ASRTU, New Delhi payable at New Delhi, so that sample test order numbers by this office.",TIME_ROMAN_SMALL));
		document.add(paragraph2);
		Paragraph paragraph3 = new Paragraph();
		paragraph3.add(new Paragraph("For the purpose of samples sealing, you are requested to get in touch with the office of the Controller of Stores & Purchase, Karnataka State Road Transport Corporation and intimate the dates on which you will be in a position to offer above mentioned samples from production line, so that officers from Karnataka State Road Transport Corporation can visit your works accordingly.",TIME_ROMAN_SMALL));
		document.add(paragraph3);
		Paragraph paragraph4 = new Paragraph();
		paragraph4.setAlignment(Element.ALIGN_CENTER);
		paragraph4.add(new Paragraph("Karnataka State Road Transport Corporation,\n Transport House,Central Office ,K.H. Road,Shanthinagar,\n"
				+ "Banglore - 560027 \n Tel. Phones:080-22221321, \n Fax:080-22224369 "));
		document.add(paragraph4);
		Paragraph paragraph5 = new Paragraph();
		paragraph5.add(new Paragraph("Please note that the cost of materials, testing charges, packing and forwarding charges etc will be borne by you.\n\n"
				+ "The random samples on behalf of ASRTU are to be jointly sealed by the representative of STU and the manufacturer or his representative. The samples are to be sent directly to the Director, Central Institute of Road Transport (Training & Research), Pune Nasik Road,Bhosari,Pune-411026.Freight should be prepaid at the consigner's end and the firm must take care of following points for dispatch of samples to CIRT,Pune-\n\n"
				+ "The details of samples collected and sample test order numbers are to be forwarded to CIRT, Pune as per Annexure \"Q\" with a copy to Director (Technical), ASRTU New Delhi.\n\n"
				+ "o 	This letter no.& date, which is issued for testing of random samples of your products/materials.\n"
				+ "o	Details of samples sealed along with part nos.(wherever applicable),Specification no. and Quantity.\n"
				+ "o	Details of Test Charges paid at ASRTU and Sample Test Order Nos. issued by ASRTU are to be mentioned.\n"
				+ "o	Seal & Signature of the officer must be distinctly visible on the sample/carton while sending the random samples.\n"
				+ "•	The samples sealed by STU officers, should be sent to Director,CIRT,Pune within 15 days of sealing of samples.\n"
				+ "•	The parcel of sealed samples should be sent by Courier/Road Transport Contract as Door Delivery basis to CIRT, pune.\n"
				+ "•	Dispatch documents should invariable include a delivery challan/note.The consignment note or way bill or lorry receipt as well as the delivery note or challan would invariably be marked \"sample for destructive testing only item of no commercial value \" or a separate certificate to this effect should be sent with the consignment.\n"
				+ "•	Please note that as per the procedures laid down the samples once sent for testing to CIRT, will not be returned to the manufacturer.\n\n"
				+ "You are requested to offer random samples as per the details mentioned above.",TIME_ROMAN_SMALL));
		document.add(paragraph5);
		Paragraph paragraph6 = new Paragraph();
		paragraph6.add(new Paragraph("Thanking You,\n"
				+"Yours faithfully,\n\n\n Sr. Asst. Director(Testing)\nEncl: Annexure  Q.", TIME_ROMAN));
		document.add(paragraph6);
	}
 
}