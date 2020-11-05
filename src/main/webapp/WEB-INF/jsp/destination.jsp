<%-- 
    Document   : thanks
    Created on : Oct 27, 2020, 9:27:29 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                 
        <div class="form-field">    
            <label for="date">To:</label>
            <select name="airPortStationTo" id="to" class="form-control" >
                <option id="option" value="">Select</option>
               <c:forEach var="destination" items="${destinations}">
                   <option id="option" value="${destination.airPortStationId}">${destination.airportName}</option>
               </c:forEach>
            </select>
        </div>
    </body>
</html>
