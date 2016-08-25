<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="myl" tagdir="/WEB-INF/tags" %>--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:a="http://www.w3.org/1999/xhtml">
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

    <title>Interbank interface</title>
    <%--<link href="${pageContext.request.contextPath}/styles/main_page_style.css" rel="stylesheet" type="text/css" />--%>
    <link href="${pageContext.request.contextPath}/styles/common_styles.css" rel="stylesheet" type="text/css" />
    <%--<link rel="stylesheet" href="https://js.arcgis.com/4.0/esri/css/main.css">--%>
</head>
<body>
<div class="header">
<h2>  Interbank interface </h2>
</div>

<div class="main">
    <ul class = "tab-bar">
        <li class = "tab">
            <a href="/java2/index">
                <span> Message files </span>
            </a>
        </li>
        <li class = "tab-act">
            <a href="/java2/main">
                <span> Contracts </span>
            </a>
        <li class = "tab">
            <a href="/java2/index">
                <span> Reports </span>
            </a>
        </li>
    </ul>
</div>


<div class="clear1"> </div>
<div class="datatable">
<table id= "customersList" width="100%" border="0" cellpadding="0" cellspacing="0">
    <thead >

<tr>
    <th width="20" nowrap="nowrap">
     Customer Id <input type="checkbox" name ="checkbox2" id="checkbox2" onclick="checkUncheckAll(this);" />
    </th>
    <th style="cursor:pointer;">Name</th>
    <th style="cursor:pointer;">Surname </th>
    <th width="20" style="cursor:pointer;" > Email </th>
    <th> Status </th>
    <th colspan="7"></th>
    </thead >

    <tbody>
    <c:forEach items="${model}" var="row" varStatus="status">
        <c:choose>
        <c:when test="${(status.index)%2 eq 0 }">
        <tr class="even">
            <td width="20"><c:out value ="${row.customer_id} " /> </td>
            <td><c:out value ="${row.first_name}" /> </td>
            <td><c:out value ="${row.last_name}" /> </td>
            <td><c:out value ="${row.email}" /> </td>
            <c:url var="viewUrl" value="/paymentsList.jsp?customer_id=${row.customer_id}" />
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

            <a href="./payments?customer_id=${row.customer_id}" class="bttn">
               <span> View customer payments </span>
               </a>
            </td>
        </tr>
        </c:when>
        <c:otherwise>
<tr>
    <td width="20"><c:out value ="${row.customer_id} " /> </td>
    <td><c:out value =" ${row.first_name}" /> </td>
    <td><c:out value ="${row.last_name}" /> </td>
    <td><c:out value ="${row.email}" /> </td>
    <c:url var="viewUrl" value="/paymentsList.jsp?customer_id=${row.customer_id}" />
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

        <a href="./payments?customer_id=${row.customer_id}" class="bttn">
            <span> View customer payments </span>
        </a>
    </td>
</tr>

</div>
    </c:otherwise>
    </c:choose>


    </c:forEach>


 <div class="navigator">
     <div class="tablecount">Records 1-26 </div>
     <u1 class="pager">
     <li>
         <a class="navbttn" href="#"> << </a>
     </li>
      <a class="act" href="#"> 1 </a>
     </u1>

 </div>
</body>
</html>
