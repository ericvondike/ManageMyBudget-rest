package json;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.daklan.controlbudget.rest.controllers.BasketController;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShoppingListJsonOperationIntegrationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingListJsonOperationIntegrationTest.class);

    private final String fileName = "static/list.json";
    private final String delimiter = "\\Z";

    private final InputStream jsonInputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
    private final String jsonDataSourceString = new Scanner(jsonInputStream, "UTF-8").useDelimiter(delimiter).next();

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


//        List<String> jsonpathItemName1 = jsonContext.read(jsonpathItemNamePath1);
//        List<String> jsonpathItemName2 = jsonContext.read(jsonpathItemNamePath2);

        Assert.assertEquals("clothes", jsonpathCategoryName);
        Assert.assertEquals("socks", jsonpathItemName1);
        Assert.assertEquals("TShirt", jsonpathItemName2);


    }
}
