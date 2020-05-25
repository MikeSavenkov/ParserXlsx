import model.*;
import model.Consultant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParserExcel {

    public Structure parser(String file) throws IOException {

        List<Consultant>  consultants  = new ArrayList<>();
        List<Division>    divisions    = new ArrayList<>();
        List<Direction>   directions   = new ArrayList<>();
        List<Service>     services     = new ArrayList<>();
        List<Subdivision> subdivisions = new ArrayList<>();

        XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = workBook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        int countRow = 1;

        int divisionId    = 0;
        int directionId   = 0;
        int serviceId     = 0;
        int subdivisionId = 0;
        int consultantId  = 0;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            if (countRow < 3) {
                countRow++;
                continue;
            }
            Consultant consultant = new Consultant();
            Division division = new Division();
            Direction direction = new Direction();
            Service service = new Service();
            Subdivision subdivision = new Subdivision();


            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                int column = cell.getAddress().getColumn();
                CellType cellType = cell.getCellTypeEnum();


                if (column == 0) {
                    switch (cellType) {
                        case BLANK:
                            break;
                        case STRING:
                            divisionId++;
                            division.setDivisionName(cell.getStringCellValue());
                            division.setId(divisionId);
                            divisions.add(division);
                            break;
                    }
                }

                if (column == 1) {
                    switch (cellType) {
                        case BLANK:
                            break;
                        case STRING:
                            directionId++;
                            direction.setDirectionName(cell.getStringCellValue());
                            direction.setId(directionId);
                            direction.setDivisionId(divisionId);
                            directions.add(direction);
                            break;
                    }
                }

                if (column == 2) {
                    switch (cellType) {
                        case BLANK:
                            break;
                        case STRING:
                            serviceId++;
                            service.setServiceName(cell.getStringCellValue());
                            service.setId(serviceId);
                            service.setDivisionId(divisionId);
                            service.setDirectionId(directionId);
                            services.add(service);
                            break;
                    }
                }

                if (column == 3) {
                    switch (cellType) {
                        case BLANK:
                            break;
                        case STRING:
                            subdivisionId++;
                            subdivision.setSubdivisionName(cell.getStringCellValue());
                            subdivision.setId(subdivisionId);
                            subdivision.setDivisionId(divisionId);
                            subdivision.setDirectionId(directionId);
                            subdivision.setServiceId(serviceId);
                            subdivisions.add(subdivision);
                            break;
                    }

                }

                if (column == 4) {
                    switch (cellType) {
                        case BLANK:
                            break;
                        case STRING:
                            consultantId++;
                            consultant.setName(cell.getStringCellValue());
                            break;
                    }
                }
                if (column == 5) {
                    switch (cellType) {
                        case BLANK:
                            break;
                        case NUMERIC:
                            consultant.setCountTasks(cell.getNumericCellValue());
                            consultant.setId(consultantId);
                            consultant.setDivisionId(divisionId);
                            consultant.setDirectionId(directionId);
                            consultant.setServiceId(serviceId);
                            consultant.setSubdivisionId(subdivisionId);
                            consultants.add(consultant);
                            break;
                    }
                }
            }
        }
        return new Structure(divisions, directions, services, subdivisions, consultants);
    }
}
