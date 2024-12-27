// Unit Tests
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @BeforeEach
    void setUp() {
        Database.students.clear();
        Database.attendance.clear();
        Database.grades.clear();
        Database.users.clear();
    }

    @Test
    void testAddStudent() {
        Database.students.add("John Doe");
        assertTrue(Database.students.contains("John Doe"));
    }

    @Test
    void testAddAttendance() {
        Database.attendance.put("student1", new ArrayList<>(Arrays.asList("2024-12-01")));
        assertEquals(1, Database.attendance.get("student1").size());
    }

    @Test
    void testAddGrade() {
        Database.grades.put("student1", "A");
        assertEquals("A", Database.grades.get("student1"));
    }

    @Test
    void testUserRegistration() {
        Database.users.put("john@example.com", "John Doe");
        assertEquals("John Doe", Database.users.get("john@example.com"));
    }
}
