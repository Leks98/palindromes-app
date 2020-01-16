<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html>
<head>
    <title>List Customers</title>
    <%--reference to css--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>NRM - Number Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <form:form action="checkNumber" method="GET" >
            Enter number: <input type="text" name="checkNumber"/>
            <input type="submit" value="Check" class="add-button"/>
            <if ${isPalindrome}>
                <label text="The number is a palindrome."/>
            </if>
            <th:else>
                <label text="The number isn't a palindrome."/>
            </th:else>

        </form:form>
        <input type="submit" value="Search" class="add-button"/>
        <%--put new button: Add Number--%>
        <input type="button" value="Add Number" onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>
        <form:form action="search" method="GET">
            Search number: <input type="text" name="searchNumber"/>
            <input type="submit" value="Search" class="add-button"/>
        </form:form>
        <%--add out html table here--%>
        <table>
            <tr>
                <th>Value</th>
                <th>AdditionDate</th>
                <th>isPalindrome</th>
                <th>Action</th>
            </tr>
            <%--loop over and print numbers--%>
            <c:forEach var="tempNumber" items="${numbers}">
                <%--costruct an "update" link with number id--%>
                <c:url var="updateLink" value="/number/showFormForUpdate">
                    <c:param name="numberId" value="${tempNumber.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/number/deleteNumber">
                    <c:param name="numberId" value="${tempNumber.id}"/>
                </c:url>
                <tr>
                    <td>${tempNumber.value}</td>
                    <td>${tempNumber.additionDate}</td>
                    <td>${tempNumber.palindrome}</td>
                    <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this number?'))) return false">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>