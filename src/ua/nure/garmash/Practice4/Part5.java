package ua.nure.garmash.Practice4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Scanner;

public class Part5 {

    private static final String RU_LOCALIZATION = "resources_ru.properties";
    private static final String EN_LOCALIZATION = "resources_en.properties";
    private static final String STOP_WORD = "stop";

    public static void main(String[] args) throws IOException {
        Props props = new Props();
        props.printPropValue();
    }

    private static class ReadFromConsole {

        private String key;
        private String localisation;
        Scanner scanner;
        private String input[] = new String[0];

        public void read() throws IOException {
            scanner = new Scanner(System.in);
            input = scanner.nextLine().split(" ");
            key = input[0];
            if (input.length > 1) {
                localisation = input[1];
            }
        }
    }

    private static class Props {
        ReadFromConsole rfc = new ReadFromConsole();
        final Properties properties = new Properties();
        boolean loaded;

        public Properties getProperties() throws IOException {
            loaded = false;
            if(rfc.localisation==null) {
                System.err.println("Failed to load property file. Localization is null");
                return null;
            }
            if (rfc.localisation.equals("ru")) {
                InputStream ruLocal = new FileInputStream(RU_LOCALIZATION);
                properties.load(new InputStreamReader(ruLocal, Charset.forName("UTF-8")));
                loaded = true;
            }
            if (rfc.localisation.equals("en")) {
                InputStream enLocal = new FileInputStream(EN_LOCALIZATION);
                properties.load(new InputStreamReader(enLocal, Charset.forName("UTF-8")));
                loaded = true;
            }

            return properties;
        }

        public void printPropValue() throws IOException {
            rfc.read();
            if (rfc.input[0] != null && rfc.input[0].equals(STOP_WORD)) return;

            try {
                getProperties();
                if (!loaded) {
                    System.err.println("please specify correct key + localization values. " +
                            "Available localizations are: \"en\", \"ru\"");
                } else if (!properties.containsKey(rfc.key)) {
                    System.out.println("There is no such key for specified localization");
                } else {
                    System.out.println(returnPropValue());
                }
                printPropValue();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String returnPropValue() {
            return properties.getProperty(rfc.key);
        }
    }
}

