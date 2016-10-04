<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="lv.javaguru.java2.domain.Payment" %>
<%@ page import="lv.javaguru.java2.domain.Staff" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Svetlana Titova
  Date: 18.09.2016
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/styles/common_styles.css" rel="stylesheet" type="text/css" />
    <% Payment payment=(Payment)request.getAttribute("newEmptyPayment"); %>
    <% List<Staff> staff =(List<Staff>)request.getAttribute("staff_list");%>
    <% Integer customer_id= payment.getCustomer_id();%>
    <title>Add New Payment</title>

    <%--<p> New Amount <%=payment.getAmount()%> </p>--%>
    <%--<p><%=(List<Staff>)request.getAttribute("staff_list")%> </p>--%>
    <%--<h2><% List<User> user=( List<User>)request.getAttribute("model"); %></h2>--%>

    <script type="text/javascript">
        function goBack(link) {
            window.location=  link;
        }
    </script>

</head>
<body>


<h1> Add new payment </h1>
<div class="box1">
    <div class="head">New payment </div>

    <div class="body" >


<form id="newPaymentForm" action="" method="POST"/>

        <table class="form condensed">
            <tbody>
            <tr class="form-row">
                <td class="control">
                    <span class="control-label"> Customer Id </span>
                    <span class="control-body">
                        <input id="customer_id" name="customer_id"  style="width: 175px" value=<%=payment.getCustomer_id()%> type="text" disabled="disabled"> </input>
                    </span>
                </td>

                <td class="control">
                    <%--<span class="control-label" hidden> Payment Id </span>--%>
                    <%--<span class="control-body" hidden></span>--%>
                    <input id="payment_id" hidden name="payment_id" style="width: 175px" type=text" disabled="disabled"> </input>
                </td>

                <td class="control">
                    <span class="control-label"> Payment reason  </span>
                    <span class="control-body" >

                   <select select id = "rental_id"  style="width: 300px;" name="rental_id">

                   <option selected="selected" value="">Select ... </option>
                    <c:forEach items="${rental_list}" var="row">

                        <option value="${row.rental_id}"> ${row.title}</option>

                    </c:forEach>
                   </select>
                    </span>

                </td>

            </tr>
            <tr class="form-row">
                <td class="control">
                    <span class="control-label"> Amount </span>
                    <span class="control-body"></span>
                    <input id="amount" name="amount" type="text" style="width: 175px" value = <%=payment.getAmount()%>  > </input>
                </td>

                <td class="control">
                    <span class="control-label"> Payment date </span>
                    <span class="control-body"></span>
                    <%--<input id="payment_date" name="payment_date" style="width: 175px" type="datetime" disabled="disabled"value = <%=payment.getPayment_date()%> > </input>--%>
                    <input id="MyDate" type="datetime" disabled="disabled" style="width: 175px" >
                    <script>
                        var dt=new Date();
                        var month = dt.getMonth()+1;
                        if (month<10) month='0'+month;
                        var day = dt.getDate();
                        if (day<10) day='0'+day;
                        var year = dt.getFullYear();
                        MyDate.value=day+'.'+month+'.'+year;
                    </script>

                </td>


                <td class="control">
                    <span class="control-label"> Staff member list  </span>
                    <span class="control-body" >

                   <select select id = "mystaff"  style="width: 300px;" name="staff">

                   <option selected="selected" value="">Select ... </option>
                    <c:forEach items="${staff_list}" var="row">

                        <option value="${row.staff_Id}"> ${row.firstName} ${row.lastName} </option>

                    </c:forEach>
                   </select>
                    </span>

                </td>
            </tr>

            </tbody>

        </table>

    </div>
</div>


<div class="clear10"></div>
<div class="actions">

    <div class="actions">
        <a class="btn-pri" href="#" onclick="goBack('./main')" >
            <span>Back </span>
        </a>

        <a class="btn-pri" href="#" onclick="goBack('./main')">
            <span>Cancel new payment </span>
        </a>

        <a class="btn-pri" href="#"  onclick="document.getElementById('newPaymentForm').submit();goBack('./payments?customer_id=<%=payment.getCustomer_id()%>')">
            <span>Submit new payment </span>

            <%--<script type="text/javascript">--%>
                <%--function showMessage () {--%>
                    <%--alert("Payment submitted");--%>
                <%--}--%>

                <%--function goBack(link) {--%>
                  <%--//  alert('Payment submitted');--%>
                    <%--//goBack('./payments?customer_id=<%=payment.getCustomer_id()%>')--%>
                    <%--window.location = link;--%>
                <%--}--%>

            <%--</script>--%>
        </a>
    </div>

</div>

</form>

</body>
</html>
