package json;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

public class ShoppingListJsonTest {

    private static final String jsonFilePath = "src/main/resources/static/list.json";
    private static String json;
    private static File jsonFile = new File(jsonFilePath);

    private static String readFile(File file, Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), charset);
    }

    @BeforeClass
    public static void init() throws IOException {
        json = readFile(jsonFile, StandardCharsets.UTF_8);
    }

    @Test
    @Ignore
    public void shouldMatchCountOfObjects() {
        Map<String, String> objectmap = JsonPath.read(json, "$");
        Assert.assertEquals(1, objectmap.keySet().size());
    }

    @Test
    @Ignore
    public void shouldMatchCountOfInternObjects() {
        Map<String, String> objectmap = JsonPath.read(json, "$.shoppinglist.category");
        Assert.assertEquals(3, objectmap.keySet().size());
    }

    @Test
    @Ignore
    public void shoulMatchCountOfArrays() {
        JSONArray jsonArray = JsonPath.read(json, "$.shoppinglist.category.item[*]");
        Assert.assertEquals(2, jsonArray.size());
    }
}
