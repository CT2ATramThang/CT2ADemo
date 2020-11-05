/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printExcelPdf;



import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Paragraph;
import entity.TicketEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Map;


public class ReportPdfView extends AbstractView {

  @Override
  protected void renderMergedOutputModel(Map<String, Object> model,
                                         HttpServletRequest request,
                                         HttpServletResponse response) throws Exception {
      response.setHeader("Content-Disposition", "attachment; filename=ticket_List.pdf");
      TicketEntity ticket = (TicketEntity) model.get("ticket");

      //IText API
      
      PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
      PdfDocument pdf = new PdfDocument(pdfWriter);
      Document pdfDocument = new Document(pdf);
      
      Paragraph title = new Paragraph("DIAMONTH AIRLINE");
      title.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
      title.setBorder(Border.NO_BORDER);
      title.setFontSize(20f);
      pdfDocument.add(title);
      //title
      Paragraph name = new Paragraph("Tên hành khách :" + ticket.getNameOfTheFlyer());
      pdfDocument.add(name);
      //birthday
      Paragraph birthday = new Paragraph("Ngày sinh :" + ticket.getChildDateOfBirth());
      pdfDocument.add(birthday);
      //booking code
      Paragraph bookingCode = new Paragraph("CodeBooking :" + ticket.getBookingT().getCodeBooking());
      pdfDocument.add(bookingCode);
      //source
      Paragraph source = new Paragraph("Source :" + ticket.getFlight().getFlightRoute().getAirPortStationFrom().getAirportName() + " "
              + ticket.getFlight().getFlightTimeFrom());
      pdfDocument.add(source);
      //destination
      Paragraph destination = new Paragraph("Destination :" + ticket.getFlight().getFlightRoute().getAirPortStationTo().getAirportName() + " "
              + ticket.getFlight().getFlightTimeTo());
      pdfDocument.add(destination);
      //date
      Paragraph date = new Paragraph("Ngày bay : " +ticket.getFlight().getFlightDate().format(
      DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
      pdfDocument.add(date);

      //content
      Paragraph content = new Paragraph("Gía vé : " +String.valueOf(ticket.getPrice()));
      pdfDocument.add(content);
      
      
      
      
      pdfDocument.close();

      
  }
}
