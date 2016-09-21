<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Add New Payment ></title>

    <%--<p> New Amount <%=payment.getAmount()%> </p>--%>
    <%--<p><%=(List<Staff>)request.getAttribute("staff_list")%> </p>--%>
    <%--<h2><% List<User> user=( List<User>)request.getAttribute("model"); %></h2>--%>
</head>
<body>
<script>
   // var form = document.forms[0];
    //var select = form.elements.namedItem("staff");
    var staff = request.getAttribute("staff_list");
    var myDropDownList =  document.getElementById("staff");

    for (var i = 0; i < 10; i++) {
        myDropDownList.option[i]=new Option("Строка списка 0", "str0");

        if(option.selected) {
            alert( option.value );
        }
    }
</script>
<h1> Add new payment </h1>
<div class="box1">
    <div class="head">New payment </div>

    <div class="body">

        <table class="form condensed">
            <tbody>
            <tr class="form-row">
                <td class="control">
                    <span class="control-label"> Customer Id </span>
                    <span class="control-body">
                        <input id="customer_id" name="customer_id"  style="width: 85px" value=<%=payment.getCustomer_id()%> type="text"> </input>
                    </span>
                </td>

                <td class="control">
                    <span class="control-label"> Payment Id </span>
                    <span class="control-body"></span>
                    <input id="payment_id" name="payment_id" style="width: 170px" type=text"> </input>
                </td>

                <td class="control">
                    <span class="control-label"> Staff Id </span>
                    <span class="control-body"></span>
                    <input id="staff_id" name="staff_id" style="width: 170px" type="text"> </input>
                </td>

            </tr>
            <tr class="form-row">
                <td class="control">
                    <span class="control-label"> Amount </span>
                    <span class="control-body"></span>
                    <input id="amount" name="amount" type="text" style="width: 170px" value = <%=payment.getAmount()%>  > </input>
                </td>

                <td class="control">
                    <span class="control-label"> Payment date </span>
                    <span class="control-body"></span>
                    <input id="payment_date" name="payment_date" style="width: 175px" type="datetime"> </input>
                </td>

                <td class="control">
                    <span class="control-label"> Staff member </span>
                    <span class="control-body">
                    <select  id="active" name="active" style="width: 170px"  >
                     <option value="ALL" selected="selected">All</option>
                     <option value="0">Active</option>
                     <option value="1">Passive</option>
                     </select>
                    </span>
                </td>

                <td class="control">
                    <span class="control-label"> Staff member list  </span>
                    <span class="control-body" >

                   <select select id = "staff"  style="width: 300px;" name="staff">

                   <option selected="selected" value="">Select ... </option>
                    <c:forEach items="${staff_list}" var="row">

                        <option value="${row.staff_Id}"> ${row.firstName} ${row.lastName} </option>

                    </c:forEach>
                   </select>
                    </span>

                </td>
            </tr>

            <div class="clear10"></div>
            <div class="actions">
                <a class="btn-pri" href="#" onclick="">
                    <span>Reset form </span>
                </a>
            </div>

            </tbody>

        </table>
    </div>
</div>
<%--<input type ="submit" name="addProperty" value="Submit"></br>--%>

<div class="clear10"></div>
<div class="actions">

    <div class="actions">
        <a class="btn-pri" href="#" onclick="" >
            <span>Back </span>
        </a>

        <a class="btn-pri" href="#" onclick="" >
            <span>Cancel new payment </span>
        </a>

        <a class="btn-pri" href="#" onclick="">
            <span>Submit new payment </span>
        </a>
    </div>

</div>
</body>
</html>
