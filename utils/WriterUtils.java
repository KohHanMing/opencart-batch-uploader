package utils;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import main.WriterMain;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WriterUtils {
    private static final char CSV_DELIMITER = ',';
    private static final String DIMENSION_UNITS = "cm";
    public static List<List<String>> readFromCsv(String filePath) {
        List<List<String>> productData = new ArrayList<>();
        try {
            CSVParser parser = new CSVParserBuilder().withSeparator(CSV_DELIMITER).build();
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(parser).build();
            String[] data;

            csvReader.readNext(); //ignore first line
            
            while ((data = csvReader.readNext()) != null) {
                //System.out.println(data.toString());
                List<String> productRow = new ArrayList<>();

                //Add name
                String productName = data[0].trim();
                productRow.add(productName);
                
                //Add category
                String productCategory = data[1];
                productRow.add(productCategory);
                
                //Add description
                String productDesc = "";
                if (WriterMain.hasEncodingInDesc) {
                    productDesc = data[5]; //pull directly from desc column
                } else {
                    String year = data[2];
                    String length = data[3];
                    String height = data[4];
                    String desc = data[5];

                    //If the info exists, add it to description, otherwise ignore
                    if (!year.isBlank()) productDesc += encodeInHtml("Year: " + data[2]);
                    if (!length.isBlank() && !height.isBlank()) {
                        String formattedLength = "L" + length + DIMENSION_UNITS;
                        String formattedHeight = "H" + height + DIMENSION_UNITS;
                        productDesc += encodeInHtml("Dimensions: " + formattedLength + " x " + formattedHeight);
                    }
                    if (!desc.isBlank()) productDesc += encodeInHtml(data[5]);
                }
                productRow.add(productDesc);

                //Add price
                if (WriterMain.hasPriceStored) productRow.add(data[6]); //add price to product data manager

                productData.add(productRow);

                //System.out.println("Product Row: " + productRow.toString());
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Check filepath given");
        } catch (IOException e) {
            System.out.println("IO exception encountered. Check for opened files");
            e.printStackTrace();
        } catch (CsvValidationException e) {
            System.out.println("CSV Validation error. Check cell formatting");
        }
        return productData;
    }

    public static void writeToCsv(List<List<String>> dataArray, String savePath) {
        try (
            Writer writer = Files.newBufferedWriter(Paths.get(savePath));

            CSVWriter csvWriter = new CSVWriter(writer,
                    CSV_DELIMITER,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
        ) {
            for (List<String> data : dataArray) {
                csvWriter.writeNext(data.toArray(new String[0]));
            }
        } catch (IOException e) {
            System.out.println("IO exception encountered. Check for opened files");
            e.printStackTrace();
        }
    }

    private static String encodeInHtml(String string) {
        return "&lt;p&gt;" + string + "&lt;/p&gt;";
    }
}
