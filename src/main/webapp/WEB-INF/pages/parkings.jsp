<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Books Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Parking List</h1>

<c:if test="${!empty listParkings}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Places total</th>
            <th width="120">Coordinate longitude</th>
            <th width="120">Coordinate latitude</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listParkings}" var="parking">
            <tr>
                <td>${parking.id}</td>
                <td><a href="/parkingdata/${parking.id}" target="_blank">${parking.name}</a></td>
                <td>${parking.placesTotal}</td>
                <td>${parking.coordinateLongitude}</td>
                <td>${parking.coordinateLatitude}</td>
                <td><a href="<c:url value='/edit/${parking.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${parking.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Parking</h1>

<c:url var="addAction" value="/parkings/add"/>

<form:form action="${addAction}" commandName="parking">
    <table>
        <c:if test="${!empty parking.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="placesTotal">
                    <spring:message text="placesTotal"/>
                </form:label>
            </td>
            <td>
                <form:input path="coordinateLongitude"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="coordinateLatitude">
                    <spring:message text="coordinateLatitude"/>
                </form:label>
            </td>
            <td>
                <form:input path="coordinateLatitude"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty parking.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Parking"/>"/>
                </c:if>
                <c:if test="${empty parking.name}">
                    <input type="submit"
                           value="<spring:message text="Add Parking"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
