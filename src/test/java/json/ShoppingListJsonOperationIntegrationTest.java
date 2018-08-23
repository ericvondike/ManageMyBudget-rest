package json;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class ShoppingListJsonOperationIntegrationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingListJsonOperationIntegrationTest.class);

    private static ObjectMapper mapper = new ObjectMapper();

    private final String fileName = "static/list.json";
    private final String filePath = "src/main/resources/static/list.json";
    private final String delimiter = "\\Z";

    private final InputStream jsonInputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
    private final String jsonDataSourceString = new Scanner(jsonInputStream, "UTF-8").useDelimiter(delimiter).next();

   private JSONParser jsonParser = new JSONParser();


    {
        try {
           Object obj = jsonParser.parse(new FileReader(filePath));
            JSONObject shoppinglistObject = (JSONObject) obj;
            LOGGER.info("ShoppingList object :  {}", shoppinglistObject.toString());
            JSONObject categoryObject = (JSONObject) shoppinglistObject.get("category");
//            LOGGER.info(categoryObject.toString());
//            JSONArray itemArray = (JSONArray) shoppinglistObject.get("shoppinglist");
//
//            Iterator<Object> iterator = itemArray.iterator();
//            while (iterator.hasNext()) {
//                LOGGER.info((String) iterator.next());
//            }


        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenJsonPathWithoutPredicates_whenReading_thenCorrect() {
        final String jsonpathCategoryNamePath = "$.shoppinglist.category.name";
        final String jsonpathItemPath1 = "$.shoppinglist.category.item[0].name";
        final String jsonpathItemPath2 = "$.shoppinglist.category.item[1].name";
        final String jsonpathItemPath = "$.shoppinglist.category.item[*]";

        DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
        final String jsonpathCategoryName = jsonContext.read(jsonpathCategoryNamePath);
        final String jsonpathItemName1 = jsonContext.read(jsonpathItemPath1);
        final String jsonpathItemName2 = jsonContext.read(jsonpathItemPath2);
        final List<Object> items = jsonContext.read(jsonpathItemPath);
//        Iterator<String> keyStr = items
        LOGGER.info(String.valueOf(items.size()));


//        List<String> jsonpathItemName1 = jsonContext.read(jsonpathItemNamePath1);
//        List<String> jsonpathItemName2 = jsonContext.read(jsonpathItemNamePath2);

        Assert.assertEquals("clothes", jsonpathCategoryName);
        Assert.assertEquals("socks", jsonpathItemName1);
        Assert.assertEquals("TShirt", jsonpathItemName2);


    }

    @Test
    public void shoud_return_jsonNode() throws IOException {
        JsonNode rootNode =  mapper.readTree(jsonInputStream);
        LOGGER.info("\n\n\nroot node is : {} ", rootNode.asText());
        JsonNode itemNode = rootNode.path("category").path("item");
        LOGGER.info(itemNode.asText());
    }
}
