import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new student
    public int addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (first_name, last_name, enrollment_number, email, course, semester) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEnrollmentNumber());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getCourse());
            statement.setInt(6, student.getSemester());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        }
        return -1;
    }

    // Get a student by ID
    public Student getStudentById(int studentId) throws SQLException {
        String query = "SELECT * FROM students WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Student(
                        resultSet.getInt("student_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("enrollment_number"),
                        resultSet.getString("email"),
                        resultSet.getString("course"),
                        resultSet.getInt("semester")
                    );
                }
            }
        }
        return null;
    }

    // Get all students
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                students.add(new Student(
                    resultSet.getInt("student_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("enrollment_number"),
                    resultSet.getString("email"),
                    resultSet.getString("course"),
                    resultSet.getInt("semester")
                ));
            }
        }
        return students;
    }

    // Update student details
    public boolean updateStudent(Student student) throws SQLException {
        String query = "UPDATE students SET first_name = ?, last_name = ?, email = ?, course = ?, semester = ? WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getCourse());
            statement.setInt(5, student.getSemester());
            statement.setInt(6, student.getStudentId());

            return statement.executeUpdate() > 0;
        }
    }

    // Delete a student
    public boolean deleteStudent(int studentId) throws SQLException {
        String query = "DELETE FROM students WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            return statement.executeUpdate() > 0;
        }
    }
}
