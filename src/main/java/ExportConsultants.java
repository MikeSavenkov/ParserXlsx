import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExportConsultants {

    Consultant export() throws SQLException {
        final String USER = "postgres";
        final String PASSWORD = "153798246";
        final String URL = "jdbc:postgresql://localhost:5432/structure";

        final Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT consultants.name, consultants.count_tasks, services.name\n" +
                    "FROM consultants JOIN services ON ser_id = services.id";


        Consultant consultants = new Consultant();
        List<Items> items = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            final ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Items item = new Items();
                item.setName(rs.getString(1));
                item.setCountTasks(rs.getDouble(2));
                item.setService(rs.getString(3));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        consultants.setConsultants(items);

        return consultants;
    }
}
