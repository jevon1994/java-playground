package com;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void addChartVersion() throws IOException {
        Files.list(Paths.get("src/main/resources"))
                .forEach(path -> {
                    File file = path.toFile();
                    String line = null;
                    CharArrayWriter  tempStream = new CharArrayWriter();
                    try (InputStream inputStream = new FileInputStream(file.getAbsoluteFile());
                         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                         ) {
                        while ((line = reader.readLine()) != null) {
                            if (line.contains("version: ")) {
                                String ver = line.split("version: ")[1];
                                String[] subVer = ver.split("\\.");
                                line = "version: ".concat(subVer[0]).concat(".")
                                        .concat(subVer[1]).concat(".") + (Integer.valueOf(subVer[2]) + 1);


                            }
                            tempStream.write(line);
                            tempStream.append(System.getProperty("line.separator"));
                        }
                        FileWriter out = new FileWriter(file);
                        tempStream.writeTo(out);
                        out.close();
                        tempStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
