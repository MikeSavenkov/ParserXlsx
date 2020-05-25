import model.*;
import model.Consultant;

import java.sql.*;

public class ImportToDB {

    final String USER = "postgres";
    final String PASSWORD = "153798246";
    final String URL = "jdbc:postgresql://localhost:5432/structure";

    final Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

    public ImportToDB() throws SQLException {

    }

    void importDivisions(Structure structure) throws SQLException {

        for (Division division : structure.getDivisions()) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO divisions (id, name) VALUES (DEFAULT, (?)) RETURNING id")) {
                statement.setString(1, division.getDivisionName());
                boolean result = statement.executeQuery().next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void importDirections(Structure structure) throws SQLException {

        for (Direction direction : structure.getDirections()) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO directions (id, name, div_id) VALUES (DEFAULT, (?), (?)) RETURNING id")) {
                statement.setString(1, direction.getDirectionName());
                statement.setInt(2, direction.getDivisionId());
                boolean result = statement.executeQuery().next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void importServices(Structure structure) throws SQLException {

        for (Service service : structure.getServices()) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO services (id, name, div_id, dir_id) VALUES (DEFAULT, (?), (?), (?)) RETURNING id")) {
                statement.setString(1, service.getServiceName());
                statement.setInt(2, service.getDivisionId());
                statement.setInt(3, service.getDirectionId());
                boolean result = statement.executeQuery().next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void importSubdivisions(Structure structure) throws SQLException {

        for (Subdivision subdivision : structure.getSubdivisions()) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO subdivisions (id, name, div_id, dir_id, ser_id) VALUES (DEFAULT, (?), (?), (?), (?)) RETURNING id")) {
                statement.setString(1, subdivision.getSubdivisionName());
                statement.setInt(2, subdivision.getDivisionId());
                statement.setInt(3, subdivision.getDirectionId());
                statement.setInt(4, subdivision.getServiceId());
                boolean result = statement.executeQuery().next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void importConsultants(Structure structure) throws SQLException {

        for (Consultant consultant : structure.getConsultants()) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO consultants (id, name, count_tasks, div_id, dir_id, ser_id, sub_id) VALUES (DEFAULT, (?), (?), (?), (?), (?), (?)) RETURNING id")) {
                statement.setString(1, consultant.getName());
                statement.setDouble(2, consultant.getCountTasks());
                statement.setInt(3, consultant.getDivisionId());
                statement.setInt(4, consultant.getDirectionId());
                statement.setInt(5, consultant.getServiceId());
                if (consultant.getSubdivisionId() == 0 || consultant.getCountTasks() == 0.45) {
                    statement.setObject(6, null);
                } else {
                    statement.setInt(6, consultant.getSubdivisionId());
                }

                boolean result = statement.executeQuery().next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
