/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printExcelPdf;


import entity.BookingEntity;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author Admin
 */
public class ExcelBookingReportView extends AbstractXlsView{
  @Override
  public void buildExcelDocument(Map<String,Object> model,Workbook workbook,HttpServletRequest requets,HttpServletResponse response) throws Exception{
  
  
      response.setHeader("Contend-Disposition", "attachment; file-name=\"booking_List.xls\"");
       @SuppressWarnings("unchecked")
       List<BookingEntity> bookingList = (List<BookingEntity>) model.get("bookingList");
       Sheet sheet = workbook.createSheet("Booking List");
       Row header = sheet.createRow(4);
       header.createCell(0).setCellValue("ID");
       header.createCell(1).setCellValue("Code Booking");
       header.createCell(2).setCellValue("Date Booking");
       header.createCell(3).setCellValue("Customer");
       
       
       int rowNum = 1;
       for(BookingEntity book : bookingList){
           Row row = sheet.createRow(rowNum++);
           row.createCell(0).setCellValue(book.getBookingId());
           row.createCell(1).setCellValue(book.getCodeBooking());
           row.createCell(2).setCellValue(String.valueOf(book.getDateBooking()));
           row.createCell(3).setCellValue(book.getCustomer().getCustomerFirstName());
       }
       
       
       
   }
   
    
}
