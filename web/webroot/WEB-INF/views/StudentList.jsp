<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <title>Student List</title>
    <body>
        <h1>Student List</h1>
     <ul>
     <c:forEach var="student" items="${students}">
        <li><a href="./students/${student.id}">
        ${student.fname}</a></li>
      </c:forEach>
      </ul>
    </body>
</html>