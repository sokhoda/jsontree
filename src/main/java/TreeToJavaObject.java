import java.io.File;
import java.io.IOException;

import java.util.Arrays;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class TreeToJavaObject{
    public static void main(String args[]){

        TreeToJSON tester = new TreeToJSON();

        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode rootNode = mapper.createObjectNode();
            JsonNode marksNode = mapper.createArrayNode();

            ((ArrayNode)marksNode).add(100);
            ((ArrayNode)marksNode).add(90);
            ((ArrayNode)marksNode).add(85);

            ((ObjectNode) rootNode).put("name", "Mahesh Kumar");
            ((ObjectNode) rootNode).put("age", 21);
            ((ObjectNode) rootNode).put("verified", false);
            ((ObjectNode) rootNode).put("marks",marksNode);

            mapper.writeValue(new File("student.json"), rootNode);

            rootNode = mapper.readTree(new File("student.json"));

            Student student = mapper.treeToValue(rootNode, Student.class);

            System.out.println("Name: "+ student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Verified: " + (student.isVerified() ? "Yes":"No"));
            System.out.println("Marks: "+Arrays.toString(student.getMarks()));

        }
        catch (JsonParseException e) { e.printStackTrace(); }
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }
}

