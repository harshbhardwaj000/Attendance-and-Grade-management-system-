
profile.jsp:
----------------------
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="JSP.css">
</head>
<body>
<h1>Welcome, ${name}</h1>
<p>Email: ${email}</p>
<a href="/students">View Students</a><br/>
<a href="/attendance">View Attendance</a><br/>
<a href="/grades">View Grades</a>
</body>
</html>

students.jsp:
----------------------
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
<h1>Student Records</h1>
<ul>
    <c:forEach var="student" items="${students}">
        <li>${student}</li>
    </c:forEach>
</ul>
</body>
</html>
*/