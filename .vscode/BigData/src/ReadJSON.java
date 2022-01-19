import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON {
    private static void parseStudentObject(JSONObject student) {
        //Get student object within list
        JSONObject studentObject = (JSONObject)student.get("student");
         
        //Get student first name
        String firstName = (String) studentObject.get("firstName");    
        System.out.println(firstName);
         
        //Get student last name
        String lastName = (String) studentObject.get("lastName");  
        System.out.println(lastName);
        
        //Get student high school
        String highschool = (String) studentObject.get("highschool");    
        System.out.println(highschool);
        
        //Get student hometown
        String hometown = (String) studentObject.get("hometown");    
        System.out.println(hometown);
    }
    public static void main(String[] args) throws Exception {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
    
        try (FileReader reader = new FileReader("student.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
    
            JSONArray studentList = (JSONArray) obj;
            System.out.println(studentList);
                
            //Iterate over student array
            studentList.forEach( std -> parseStudentObject( (JSONObject) std ) );
    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
