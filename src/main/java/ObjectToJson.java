import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ObjectToJson {

    void convert(Consultant consultants) {

        try {

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(consultants);
            Writer writer = new FileWriter("jsonchick.json");
            writer.write(json);
            writer.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }



    }

}
