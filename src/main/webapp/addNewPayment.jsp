<%@ page import="lv.javaguru.java2.domain.Payment" %><%--
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
    <title>Add New Payment ></title>

    <%--<p> New Amount <%=payment.getAmount()%></p>--%>
</head>
<body>

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
                    <input id="payment_id" name="payment_id" style="width: 170px" type="""text"> </input>
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
                    <input id="amount" name="amount" type="number" style="width: 170px" value = <%=payment.getAmount()%>  > </input>
                </td>

                <td class="control">
                    <span class="control-label"> Payment date </span>
                    <span class="control-body"></span>
                    <input id="payment_date" name="payment_date" style="width: 175px" type="datetime"> </input>
                </td>

                <td class="control">
                    <span class="control-label"> Staff member </span>
                    <span class="control-body">
                    <select  id="active" name="active" style="width: 170px" >
                     <option value="ALL" selected="selected">All</option>
                     <option value="0">Active</option>
                     <option value="1">Passive</option>
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
            <span>Cancel new payment </span>
        </a>


        <a class="btn-pri" href="#" onclick="">
            <span>Submit new payment </span>
        </a>
    </div>

</div>
</body>
</html>
