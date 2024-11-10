import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    private Connection connection;

    public AttendanceDAO(Connection connection) {
        this.connection = connection;
    }

    // Record attendance for a student
    public boolean recordAttendance(int studentId, int courseId, Date attendanceDate, String status) throws SQLException {
        String query = "INSERT INTO attendance (student_id, course_id, attendance_date, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.setDate(3, attendanceDate);
            statement.setString(4, status);

            return statement.executeUpdate() > 0;
        }
    }

    // Get attendance for a student in a specific course
    public List<Attendance> getAttendance(int studentId, int courseId) throws SQLException {
        List<Attendance> attendanceList = new ArrayList<>();
        String query = "SELECT * FROM attendance WHERE student_id = ? AND course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    attendanceList.add(new Attendance(
                        resultSet.getInt("attendance_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("course_id"),
                        resultSet.getDate("attendance_date"),
                        resultSet.getString("status")
                    ));
                }
            }
        }
        return attendanceList;
    }
}
