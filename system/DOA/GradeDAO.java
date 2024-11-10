import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {

    private Connection connection;

    public GradeDAO(Connection connection) {
        this.connection = connection;
    }

    // Add or update a grade for a student
    public boolean addOrUpdateGrade(int studentId, int courseId, String assessmentType, String grade, double score, String comments) throws SQLException {
        String query = "INSERT INTO grades (student_id, course_id, assessment_type, grade, score, comments, graded_date) VALUES (?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE grade = ?, score = ?, comments = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.setString(3, assessmentType);
            statement.setString(4, grade);
            statement.setDouble(5, score);
            statement.setString(6, comments);
            statement.setDate(7, new Date(System.currentTimeMillis()));

            // Update existing grade if exists
            statement.setString(8, grade);
            statement.setDouble(9, score);
            statement.setString(10, comments);

            return statement.executeUpdate() > 0;
        }
    }

    // Get grades for a student in a specific course
    public List<Grade> getGrades(int studentId, int courseId) throws SQLException {
        List<Grade> gradeList = new ArrayList<>();
        String query = "SELECT * FROM grades WHERE student_id = ? AND course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    gradeList.add(new Grade(
                        resultSet.getInt("grade_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("course_id"),
                        resultSet.getString("assessment_type"),
                        resultSet.getString("grade"),
                        resultSet.getDouble("score"),
                        resultSet.getString("comments"),
                        resultSet.getDate("graded_date")
                    ));
                }
            }
        }
        return gradeList;
    }
}
