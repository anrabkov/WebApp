<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Person Management Application</title>
</head>
<body>
<center>
    <h1>Person Management</h1>
    <h2>
        <a href="new">Add New Person</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Persons</a>

    </h2>
</center>
<div align="center">
    <c:if test="${person != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${person == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${person != null}">
                            Edit Persons
                        </c:if>
                        <c:if test="${person == null}">
                            Add New Person
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${person != null}">
                    <input type="hidden" name="id" value="<c:out value='${person.id}' />" />
                </c:if>
                <tr>
                    <th>Person Name: </th>
                    <td>
                        <input type="text" name="name" size="50"
                               value="<c:out value='${user.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Current roles: </th>
                    <td>
                        <c:out value='${person.quality}' />
                    </td>
                </tr>

                <tr>
                    <th>Person qualities for adding: </th>
                    <td>
                        <input type="text" name="addedQuality" size="50"
                               placeholder="Please enter quality to Add"
                        />
                    </td>
                </tr>
                <tr>
                <tr>
                    <th>Person quality for deleting: </th>
                    <td>
                        <input type="text" name="deletedQuality" size="50"
                               placeholder="Please enter quality to delete"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>