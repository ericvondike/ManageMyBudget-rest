package generictests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Random;

public class GenerateRandomStringTest {

    private final String DELIMITER = "-";
    private int RAND_STR_LENGHT = 5;
    private int RAND_GLOB_STR_LENGHT = 7;

    @Test
    public void usingPlainJava_whenGeneratingRandomStringUnbounded_theCorrect() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedRandomString = new String(array, Charset.forName("UTF-8"));

        System.out.println("The unbounded randomly generated string is : " + generatedRandomString);
    }

    @Test
    public void usingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength =4;
        Random random = new Random();
        StringBuilder outSideBuffer = new StringBuilder();
        for (int j = 1; j < 8; j++) {
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimiedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimiedInt);
            }
            String generatedRandomString = buffer.toString();
            outSideBuffer.append(generatedRandomString);
            if (j <7) {
                outSideBuffer.append(DELIMITER);
            }

        }


        System.out.println("The bounded randomly generated string is : " + outSideBuffer);
    }

    @Test
    public void usingApache_whenGeneratingRandomStringBounded_thenCorrect() {
        int length = 5;
        boolean useLetter = true;
        boolean useNumbers = true;

        StringBuilder generatedRadomStringGlobal = new StringBuilder();
        for (int i = 1; i < 8; i++) {
            String generatedRandomString = RandomStringUtils.random(length, useLetter, useNumbers);
            generatedRadomStringGlobal.append(generatedRandomString);

            if (i < 7) {
                generatedRadomStringGlobal.append(DELIMITER);
            }
        }


        System.out.println("The Random String using apache common lang :" + generatedRadomStringGlobal);
    }

    @Test
    public void usingApache_whenGeneratingRandomAlphabeticString_thenCorrect() {
        StringBuilder globalRandomString = new StringBuilder();
        for (int i = 0; i < RAND_GLOB_STR_LENGHT; i++) {
            String generatedString = RandomStringUtils.randomAlphabetic(RAND_STR_LENGHT);
            globalRandomString.append(generatedString);
            if (i < RAND_GLOB_STR_LENGHT - 1) {
                globalRandomString.append(DELIMITER);
            }
        }


        System.out.println("The alphbetic random string using apache commons lang : " + globalRandomString);
    }

    @Test
    public void usingApache_whenGeneratinhAlphnumericString_thenCorrect() {
        StringBuilder globalRandomString = new StringBuilder();
        for (int i = 0; i < RAND_GLOB_STR_LENGHT; i++) {
            String generatedString = RandomStringUtils.randomAlphanumeric(RAND_STR_LENGHT);
            globalRandomString.append(generatedString);

            if (i < RAND_GLOB_STR_LENGHT - 1) {
                globalRandomString.append(DELIMITER);
            }
        }

        System.out.println("The alphaNumeric random string using apache commons lang : " + globalRandomString);
    }
}
