<%@ page import="lv.javaguru.java2.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<html xmlns:a="http://www.w3.org/1999/xhtml">
<head>

    <title>Interbank interface</title>
    <link href="${pageContext.request.contextPath}/styles/main_page_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%--<img src="${pageContext.request.contextPath}/images/main_logo.jpg" />--%>
    <%--response --%>
    <%--session--%>
    <%--<h1>${name}</h1>--%>
    <%--<h2><% List<User> user=( List<User>)request.getAttribute("model"); %></h2>--%>

    <h1> Interbank interface </h1>

  <div class="main">
      <ul class = "tab-bar">
           <li class = "tab">
           <a href="/index">
               <span> Message files </span>
           </a>
           </li>
          <li class = "tab-act">
              <a href="/index">
                  <span> Contracts </span>
              </a>
          <li class = "tab">
              <a href="/index">
                  <span> Reports </span>
              </a>
          </li>
   </ul>
</div>
<l:form cssClass="contract-form">
    <table border="1">
        <% List<User> userList = (List<User>) request.getAttribute("model");

            if ( userList != null) {
                for(User userRow :  userList) {

        %>

            <tr>
                <td><%=userRow.getUserId()+" "+userRow.getFirstName()+" "+userRow.getLastName() %></td>
                <%--<td><%=userRow.getFirstName()%></td>--%>
                <%--<td><c:out value ="${model}" /> </td>--%>

            </tr>

        <%     }
        } else {%>
        <tr><td colspan="3">List of users is empty.</td></tr>
        <% } %>
    </table>
    </l:form>
<div class="clear1"> </div>
       <table id= "usersList" width="100%" border="0" cellpadding="0" cellspacing="0">

     <th width="20" nowrap="nowrap">
         <input type="checkbox" name ="checkbox2" id="checkbox2" onclick="checkUncheckAll(this);"
      /></th>
      <th style="cursor:pointer;"
          ></th>
        <c:forEach items="${model}" var="row" varStatus="status">
                <tr>
                    <td><c:out value ="${row.userId} ${row.firstName} ${row.lastName}" /> </td>
                    <td><c:out value ="${row.firstName}" /> </td>
                    <td><c:out value ="${row.lastName}" /> </td>
                    <td>${row.userId + 200}</td>

                </tr>
            </c:forEach>
        <%--</c:if>--%>
    </table>


</body>
</html>
