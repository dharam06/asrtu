package com.asrtu.pdfGen;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		List<Book> listBooks = (List<Book>) model.get("listBooks");
		
		doc.add(new Paragraph("ASSOCIATION OF STATE ROAD TRANSPORT UNDERTAKINGS"));
		doc.add(new Paragraph("ASRTU Bhawan"));
		doc.add(new Paragraph("Plot No. 4-A,PSP Block"));
		doc.add(new Paragraph("Pocket-14,Sector-8,Dwarka,"));
		doc.add(new Paragraph("New Delhi-110077"));
		 Paragraph para1 = new Paragraph("As per the policy decision of the Standing Committee(Supplies &Contrscts), testing of random"+
"samples of your products/materials under the group offered by you in the above mentioned tender"+ 
"should be carried out at CIRT, Pune before consideration of your above referred tender. Please note"+
"that the cost of materials, testing changes, packing and forwarding changes etc will be borne by you"+
"and that your offer shall be considered on receipt of the sample test reports and works inspection"+
"report.Demand Draft Bearing no. 634135 dt.06/06/2016 drawn in favour of Executive Director,"+
"ASRTU, New Delhi for Rs. 42938/- is received at ASRTU towards advance test charges."+
"Following samples are proposed for testing t CIRT, Pune as per specification number mentioned"+ 
"below the item. Details of test changes and sample test order numbers are as under.");
		 doc.add(para1);
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {3.0f, 2.0f, 2.0f, 2.0f, 1.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		
		// write table header 
		cell.setPhrase(new Phrase("Book Title", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Author", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("ISBN", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Published Date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Price", font));
		table.addCell(cell);
		
		// write table row data
		for (Book aBook : listBooks) {
			table.addCell(aBook.getTitle());
			table.addCell(aBook.getAuthor());
			table.addCell(aBook.getIsbn());
			table.addCell(aBook.getPublishedDate());
			table.addCell(String.valueOf(aBook.getPrice()));
		}
		
		doc.add(table);
		
	}

}