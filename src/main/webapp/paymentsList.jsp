<%@ page import="lv.javaguru.java2.domain.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Pro430
  Date: 18.08.2016
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer payments list</title>
    <link href="${pageContext.request.contextPath}/styles/common_styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <%Customer customer=(Customer)request.getAttribute("customerName"); %>
<h1>List of payments for customerId=<%=customer.getCustomer_id()%></h1>
<h1> <%=customer.getFirst_name() + ' '+ customer.getLast_name() %></h1>
</div>
    <div class="clear1"> </div>
    <div class="datatable">
    <table id= "paymentsList" width="100%" border="0" cellpadding="0" cellspacing="0">

      <thead >
            <tr>
                <th>Payment id</th>
                <%--<th>Customer Id</th>--%>
                <th>Amount</th>
                <th>Payment date</th>
                <th>Last update</th>
                <th colspan="4"></th>
            </tr>
            </thead>
        <%--<th width="20" nowrap="nowrap">--%>
            <%--<input type="checkbox" name ="checkbox2" id="checkbox2" onclick="checkUncheckAll(this);"/></th>--%>
        <%--<th style="cursor:pointer;"></th>--%>

            <tbody>
            <tr>
        <c:forEach items="${model}" var="row" varStatus="status">
            <c:choose>
                <c:when test="${(status.index)%2 eq 0 }">
            <tr class="even">
                <td><c:out value ="${row.payment_id}" /> </td>
                <%--<td><c:out value ="${row.customer_id}" /> </td>--%>
                <td><c:out value ="${row.amount}" /> </td>
                <td><c:out value ="${row.payment_date}" /> </td>
                <td><c:out value ="${row.last_update}" /> </td>
                <td nowrap="nowrap" class="action">
                    <a href="./addNewPayment?customer_id=${row.customer_id}" class="bttn">
                        <span> Add payment </span>
                    </a>
                </td>
                <td nowrap="nowrap" class="action">
                    <a href="./payments?payment_id=${row.payment_id}" class="bttn">
                        <span> Edit payment </span>
                    </a>
                </td>
                <td nowrap="nowrap" class="action">
                    <a href="./payments?payment_id=${row.payment_id}" class="bttn">
                        <span> Delete payment </span>
                    </a>
                </td>
            </tr>
                </c:when>
            <c:otherwise>
                <tr>
                    <td><c:out value ="${row.payment_id}" /> </td>
                    <%--<td><c:out value ="${row.customer_id}" /> </td>--%>
                    <td><c:out value ="${row.amount}" /> </td>
                    <td><c:out value ="${row.payment_date}" /> </td>
                    <td><c:out value ="${row.last_update}" /> </td>
                    <td nowrap="nowrap" class="action">
                        <a href="./addNewPayment?customer_id=${row.customer_id}" class="bttn">
                            <span> Add payment </span>
                        </a>
                    </td>
                    <td nowrap="nowrap" class="action">
                      <a href="./payments?payment_id=${row.payment_id}" class="bttn">
                        <span> Edit payment </span>
                      </a>
                    </td>
                    <td nowrap="nowrap" class="action">
                        <a href="./payments?payment_id=${row.payment_id}" class="bttn">
                            <span> Delete payment </span>
                        </a>
                    </td>
                </tr>
            </c:otherwise>
            </c:choose>
            </tbody>
        </c:forEach>
        </tr>
       </div>
    </table>


    <a  href="main" class="bttn">
        <span>Back</span>
    </a>

</body>
</html>
