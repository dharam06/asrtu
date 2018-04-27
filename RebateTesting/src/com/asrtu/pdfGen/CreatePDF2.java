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
 
public class CreatePDF2 {
	
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
		document.addAuthor("ASRTU");
		document.addCreator("ASRTU");
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
		p4.add(new Chunk("Ref.: ASRTU/TEST/F(35)D080/222/50/VDRS",TIME_ROMAN_SMALL));
		p4.setTabSettings(new TabSettings(250f));
	    p4.add(Chunk.TABBING);
	    p4.add(new Chunk("Date:"+ simpleDateFormat.format(new Date())+"\n",TIME_ROMAN_SMALL));
	    preface.add(p4);
		//preface.add(new Paragraph("Ref.: ASRTU/TEST/F(35)/A625/243/M21/ATR Date:"+ simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
		document.add(preface);
 
	}
 
	private static void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(""));
		}
	}
 
	private static void createTable(Document document) throws DocumentException {
		Paragraph para = new Paragraph();
		para.setAlignment(Element.ALIGN_CENTER);
		para.add(new Paragraph("Sub: registration under Vendor Develoment Scheme of ASRTU for the supply of Rubber & Rubber Parts\n"));
		para.setAlignment(Element.ALIGN_CENTER);
		para.add(new Paragraph("Ref: Your letter dt. 21/09/2016\n"));
		document.add(para);
		Paragraph paragraph = new Paragraph();
		paragraph.add(new Paragraph("Sir,",TIME_ROMAN));
		paragraph.add(new Paragraph("We are in receipt of your request, regarding registration of your fime under "+
"Vendor Development Registration Scheme of ASRTU, along with registration fee of Rs. 1000/-as per the details given below:\n\n",TIME_ROMAN_SMALL));

		document.add(paragraph);
		PdfPTable table = new PdfPTable(7);
 
		PdfPCell c1 = new PdfPCell(new Phrase("Sn No."));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Item Description"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
 
		c1 = new PdfPCell(new Phrase("Quantity /sample"));
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
		paragraph1.add(new Paragraph("In order to process further course of action, we are sending you the following document:\n "
				+ " 1)   ASRTU Vendor Development Registration Scheme Book.\n "
				+"2)   Application form for Registration under Vendor Development Registration Scheme.\n"
				+" 3)   Works Inspection  Proforma in triplicate.\n"
				+"4)   The schedule of relevant items/Procurement Groups.\n"
				+"5)   Set of relevant ASRTU Specification and test charges detail(sub-group wise).",TIME_ROMAN_SMALL));
		paragraph1.add(new Paragraph("You are requested to kindly go through the above document carefully and submit"
				+ " the following information/ document to the Director(Technical),"
           +"ASRTU within 30 days from the issue of this letter.\n",TIME_ROMAN_SMALL));
		paragraph1.add(new Paragraph("(A).Mark the items (wherever application, under each group/sub-groups for which you are interested for Contracts) in our printed Item Schedule in duplicate and send back to ASRTU.\n"
+ " (B).Fill up Works Inspection Proforma in duplicate and send back to ASRTU along with advance Works Inspection Charges of Rs.1500/- per factory"
  +"per location by way of Demand Draft issued in favour of the Executive director, ASRTU payble at New Delhi. Please also enclose the copies of the"
      +"document wherever application, as per the check list mentioned in the Works Inspection Proforma.\n"
  +"(C).Send the advance Testing Charges as applicable for the relevant items sub-Groups by way of Demand Draft in favour of the Executive Director, ASRTU payble at New Delhi.\n"
  +"(D). The random samples on behalf of ASRTU are to be jointly sealed by the ASRTU officers or officers from designated member of STU and the manufacturer or his representative.\n"        
  +"(E).The samples are to be send directly to the Director, Central Institute of Road Transport(Training & Research), Pune Nasik Road, Bhosari, Pune-411 026\n"
  +"(F).The cost of materials, testing charges, packing and forwarding charges, etc will be brone by you. Freight should bbe prepaid at the consinger's end\n\n",TIME_ROMAN_SMALL));
		document.add(paragraph1);
		
		Paragraph paragraph2 = new Paragraph();
		paragraph2.add(new Paragraph("Kindly note that your request for Registration under Vendor Development Registration Scheme"
         +"may be delayed / may not be considered, if incomplete information is received.\n\n"
         + "In case of Works Inspecton Report is ''Satisfactory'' and the products pass the prescribed laboratory test, then ASRTU would request member STUs"
         +" to place the Trial Orders on yoour firm and report the filed performance of the product to ASRTU\n",TIME_ROMAN_SMALL));
		document.add(paragraph2);
		Paragraph paragraph3 = new Paragraph();
		paragraph3.add(new Chunk("Thanking You\n",TIME_ROMAN));
		paragraph3.setTabSettings(new TabSettings(280f));
		paragraph3.add(Chunk.TABBING);
		paragraph3.add(new Chunk("Your faithfully,\n\n\n ",TIME_ROMAN_SMALL));
		paragraph3.setTabSettings(new TabSettings(275f));
		paragraph3.add(Chunk.TABBING);
		paragraph3.add(new Chunk("Technical Officer(Testing)",TIME_ROMAN_SMALL));
		paragraph3.setTabSettings(new TabSettings(275f));
		paragraph3.add(Chunk.TABBING);
		paragraph3.add(new Chunk(" Encl: as above",TIME_ROMAN_SMALL));
		paragraph3.add(new Paragraph("Copy to:\n"
				+ "Accounts Officer,\n"
+ " Delhi-Firm has deposited Demand Draft No./P.O.No An amount of Rs.10925/- lying with ASRTU  after issuing STO Nos. B7007 as "
 + " on 21/09/2016 and cheque no. 225168 dt. 21/09/2016 for Rs.9300/- of which is enclosed herewith.",TIME_ROMAN_SMALL));
		document.add(paragraph3);
	}
 
	
}