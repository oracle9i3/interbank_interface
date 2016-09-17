<%@ page import="lv.javaguru.java2.servlet.mvc.CustomerListController" %>
<%@ page import="lv.javaguru.java2.domain.PageInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<script>
    function nextPage(link) {
        window.location = link;
    }
    function checkUncheckAll(theElement){
        var $el=jQuery(theElement);
        $el.closest('form').find('[type=checkbox][name!=checkall]').prop('checked',$el.prop('checked'));
    }

 </script>

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

<%--<div class="clear20" ></div>--%>

<h1>Customers list</h1>
<div class="box1">
    <div class="head">Filter</div>

    <div class="body">
        <%--<input id="customer_id" name="customer_id" value="0" > </input>--%>
        <%--<input id="store_id" name="store_id" value="0" type="hidden"> </input>--%>
        <%--<input id="first_name" name="first_name" value=" " > </input>--%>
        <%--<input id="last_name" name="last_name" value=" " > </input>--%>

        <table class="form condensed">
            <tbody>
            <tr class="form-row">
                <td class="control">
                    <span class="control-label"> Customer Id </span>
                    <span class="control-body">
                        <input id="customer_id" name="customer_id" style="width: 85px" value="599" type="text"> </input>
                    </span>
                </td>

               <td class="control">
                <span class="control-label"> First name </span>
                <span class="control-body"></span>
                <input id="first_name" name="first_name" style="width: 175px" type="text"> </input>
               </td>

                <td class="control">
                    <span class="control-label"> Last name </span>
                    <span class="control-body"></span>
                    <input id="last_name" name="last_name" style="width: 175px" type="text"> </input>
                </td>

            </tr>
            <tr class="form-row">
                <td class="control">
                    <span class="control-label"> Email </span>
                    <span class="control-body"></span>
                    <input id="email" name="email" style="width: 175px" type="text"> </input>
                </td>

                <td class="control">
                    <span class="control-label"> Last update </span>
                    <span class="control-body"></span>
                    <input id="last_update" name="last_update" style="width: 175px" type="text"> </input>
                </td>

                <td class="control">
                    <span class="control-label"> Status </span>
                    <span class="control-body">
                    <select  id="active" name="active" style="width: 85px" >
                     <option value="ALL" selected="selected">All</option>
                     <option value="0">Active</option>
                     <option value="1">Passive</option>
                     </select>
                    </span>
                </td>
            </tr>

            <%--<div class="clear10"></div>--%>
            <div class="actions">
                <a class="btn-pri" href="#" onclick="">
                    <span>Show</span>
                </a>
            </div>

            </tbody>

        </table>
    </div>
    </div>
<div class="clear1"> </div>
<div class="datatable">
<table id= "customersList" width="100%" border="0" cellpadding="0" cellspacing="0">
    <thead >

<tr>
    <th nowrap="nowrap">
       <input type="checkbox" name ="checkbox2" id="checkbox2" onclick="checkUncheckAll(this);"/></input>
    </th>
    <th  nowrap="nowrap" >Customer Id </th>

    <th style="cursor:pointer;">Name</th>
    <th style="cursor:pointer;">Surname </th>
    <th width="20" style="cursor:pointer;" > Email </th>
    <th> Status </th>
    <th colspan="7"></th>
    </thead >

    <tbody>
    <tr>
    <c:forEach items="${model}" var="row" varStatus="status">
    <c:set var="checkValue" value="${row.customer_id}"/>
        <c:choose>
        <c:when test="${(status.index)%2 eq 0 }">
        <input class="even">
            <td> <input name="checked" value="${checkValue}" type="checkbox"> </input> </td>
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
    <td><input  name="checked" value="${checkValue}" type="checkbox"> </input> </td>
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

    </c:otherwise>
    </c:choose>

    </c:forEach>
    </tbody>
</table>
 <div class="navigator">
<div class="footer">
     <div class="tablecount"></div>
     <u1 class="pager" >

     <li>
         Page <%=((PageInfo)request.getAttribute("pageInfo")).getCurrentPage()%>
         <a class="navbttn-first" href="#" onclick='nextPage("<%=((PageInfo)request.getAttribute("pageInfo")).getFirstPageURI()%>")'> First page</a>

         <a class="navbttn" href="#" onclick='nextPage("<%=((PageInfo)request.getAttribute("pageInfo")).getPrevPageURI()%>")'> << </a>

         <a class="navbttn" href="#" onclick='nextPage("<%=((PageInfo)request.getAttribute("pageInfo")).getNextPageURI()%>")'> >> </a>

         <a class="navbttn-last" href="#" onclick='nextPage("<%=((PageInfo)request.getAttribute("pageInfo")).getLastPageURI()%>")'> Last page </a>
     </li>

     </u1>
 </div>
</body>

</html>
