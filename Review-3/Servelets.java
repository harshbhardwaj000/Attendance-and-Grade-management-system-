// create and configure Servlets.
// Implement doGet and doPost methods.
// Implement user form registration and profile using Servlets.
// Integrate JSP with Servlets.
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

// Simulated Database
class Database {
    static List<String> students = new ArrayList<>();
    static Map<String, List<String>> attendance = new HashMap<>();
    static Map<String, String> grades = new HashMap<>();
    static Map<String, String> users = new HashMap<>();  // Store user profiles
}

// User Registration Servlet
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if (name != null && email != null) {
            Database.users.put(email, name);
        }
        response.sendRedirect("/profile?email=" + email);
    }
}

// User Profile Servlet
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = Database.users.get(email);
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);
    }
}

// 1. Student Servlet
@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("students", Database.students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name != null && !name.trim().isEmpty()) {
            Database.students.add(name);
        }
        response.sendRedirect("/students");
    }
}

// 2. Attendance Servlet
@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("attendance", Database.attendance);
        RequestDispatcher dispatcher = request.getRequestDispatcher("attendance.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String date = request.getParameter("date");
        if (studentId != null && date != null) {
            Database.attendance.computeIfAbsent(studentId, k -> new ArrayList<>()).add(date);
        }
        response.sendRedirect("/attendance");
    }
}

// 3. Grade Servlet
@WebServlet("/grades")
public class GradeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("grades", Database.grades);
        RequestDispatcher dispatcher = request.getRequestDispatcher("grades.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String grade = request.getParameter("grade");
        if (studentId != null && grade != null) {
            Database.grades.put(studentId, grade);
        }
        response.sendRedirect("/grades");
    }
}
