
/**
 * Write a description of parsingExportData here.
 * 
 * @author (Enrique Rodrigo Ledesma Pinet) 
 * @version (8/19/2020)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class parsingExportData {
    public void tester(){
        //Open the file
        FileResource fr = new FileResource();
        //Turn the file into a CSV Parser
        CSVParser parser = fr.getCSVParser();
        
        //System.out.println(countryInfo(parser, "Nauru"));
        //listExportersTwoProducts(parser, "gold", "diamonds");
        //System.out.println(numberOfExporters(parser, "sugar"));
        bigExporters(parser, "$999,999,999,999");
    }
    public String countryInfo(CSVParser parser, String country){
        //Get the Country row
        for(CSVRecord record : parser){
            String countryOfInterest = record.get("Country");
            if(countryOfInterest.contains(country)){
                //Country found, get info

                return country + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            }
            
        }
        return "NOT FOUND";
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        //Search the country list
        for(CSVRecord record : parser){
            if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    public int numberOfExporters(CSVParser parser, String exportItem){
        int counter = 0;
        //Search the exports list
        for(CSVRecord record : parser){
            if(record.get("Exports").contains(exportItem)){
                counter++;
            }
        }
        return counter;
    }
    public void bigExporters(CSVParser parser, String amount){
        int stringLength = amount.length();
        //Search the value list
        for(CSVRecord record : parser){
            if(record.get("Value (dollars)").length() > stringLength){
                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
        
    }
}
