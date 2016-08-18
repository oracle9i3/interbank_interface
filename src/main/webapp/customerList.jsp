<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="lv.javaguru.java2.domain.Customer" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Svetlana Titova
  Date: 17.08.2016
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>

</head>
<body>

<div class="clear1"> </div>
<table id= "usersList" width="100%" border="0" cellpadding="0" cellspacing="0">

    <th width="20" nowrap="nowrap">
        <input type="checkbox" name ="checkbox2" id="checkbox2" onclick="checkUncheckAll(this);"/></th>
    <th style="cursor:pointer;"></th>


    <c:forEach items="${model}" var="row" varStatus="status">
        <tr>
            <td><c:out value ="${row.customer_id} " /> </td>
            <td><c:out value =" ${row.first_name}" /> </td>
            <td><c:out value ="${row.last_name}" /> </td>
            <td><c:out value ="${row.email}" /> </td>

            <td>
                <c:choose>
                <c:when test="${row.active=='1'}"> ACTIVE
            </c:when>
            <c:otherwise>
                PASSIVE
             </c:otherwise>
                </c:choose>
            </td>

            <td><c:out value ="${row.create_date}" /> </td>
            <td><c:out value ="${row.last_update}" /> </td>
            <td nowrap="nowrap" class="action">
               <a href="" class="button">
               <span> View customer payments </span>
               </a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
