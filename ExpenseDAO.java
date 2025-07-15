import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExpenseDAO {
    public static void insertExpense(String description, double amount, String date) {
        String sql = "INSERT INTO expenses (description, amount, date) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, description);
            stmt.setDouble(2, amount);
            stmt.setDate(3, java.sql.Date.valueOf(date));

            stmt.executeUpdate();
            System.out.println("✅ Expense added to database.");

        } catch (SQLException e) {
            System.out.println("❌ Database insertion error:");
            e.printStackTrace();
        }
    }
}