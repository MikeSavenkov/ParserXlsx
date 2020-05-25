import model.Structure;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        String file = "data.xlsx";
        ParserExcel parserXlsx = new ParserExcel();
        ImportToDB importToDB = new ImportToDB();
        Structure structure = parserXlsx.parser(file);


        importToDB.importDivisions(structure);
        importToDB.importDirections(structure);
        importToDB.importServices(structure);
        importToDB.importSubdivisions(structure);
        importToDB.importConsultants(structure);
        Consultant consultants = new ExportConsultants().export();
        new ObjectToJson().convert(consultants);

        System.out.println();
    }

}
