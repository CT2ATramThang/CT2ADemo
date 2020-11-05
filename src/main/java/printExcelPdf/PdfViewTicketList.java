/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printExcelPdf;


import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import entity.TicketEntity;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author Admin
 */

public class PdfViewTicketList extends AbstractPdfView {
    @Override
    public void buildPdfDocument(Map<String,Object> model,
                                         Document document,
                                         PdfWriter writer,
                                         HttpServletRequest request,
                                         HttpServletResponse response)
                                  throws Exception {

        response.setHeader("Contend-Disposition", "attachment; file-name=\"ticket_List.pdf\"");
        
        @SuppressWarnings("unused")
        List<TicketEntity> ticketList = (List<TicketEntity>) model.get("ticketList");
        Table table = new Table(7);
        //table.addCell("TicketId");
        table.addCell("TicketName");
        table.addCell("Price");
        table.addCell("NameOfTheFlyer");
        table.addCell("ChildDateOfBirth");
        table.addCell("Cmnd");
        table.addCell("TicketIssueDate");
        table.addCell("typeTicket");
        for(TicketEntity ticket: ticketList){
            table.addCell(ticket.getTicketName());
            table.addCell(String.valueOf(ticket.getPrice()));
            table.addCell(ticket.getNameOfTheFlyer());
            table.addCell(String.valueOf(ticket.getChildDateOfBirth()));
            table.addCell(ticket.getCmnd());
            table.addCell(String.valueOf(ticket.getTicketIssueDate()));
            table.addCell(String.valueOf(ticket.getTicketType().getType()));
            
        }
        document.add(table);
        
        
        
        
        }
    }

   

