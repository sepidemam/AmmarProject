import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.dev.*;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * This example shows how to use the event API for reading a file.
 */
public abstract class ReadWriteModify
        implements HSSFListener
{
    

    /**
     * Read an excel file and spit out what we find.
     *
     * @param args      Expect one argument that is the file to read.
     * @throws IOException  When there is an error processing the file.
     */
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException
    {

    	    try {
    	    	PrintWriter writer = new PrintWriter("/Users/spideh/Desktop/DataOut.txt", "UTF-8");
    	        FileInputStream file = new FileInputStream(new File("/Users/spideh/Desktop/Data.xlsx"));
    	        FileInputStream file2 = new FileInputStream(new File("/Users/spideh/Desktop/Map.xlsx"));
    	       
    	        HashSet<String> uniqueTester = new HashSet<String>();

    	        //Create Workbook instance holding reference to .xlsx file
    	        XSSFWorkbook workbook = new XSSFWorkbook(file);
    	        XSSFWorkbook workbook2 = new XSSFWorkbook(file2);
    	       // XSSFWorkbook workbook3 = new XSSFWorkbook(file2);

    	        //Get first/desired sheet from the workbook
    	        XSSFSheet sheet = workbook.getSheetAt(0);
    	      //Get second/desired sheet from the workbook
    	        
    	        XSSFSheet sheet2 = workbook2.getSheetAt(0);

    	        //Iterate through each rows one by one in sheet 1
    	        Iterator<Row> rowIterator = sheet.iterator();
    	        rowIterator.next();
    	        //Iterate through each rows one by one in sheet 2
    	      
    	    
    	        
    	        while (rowIterator.hasNext())
    	        {
    	            Row row = rowIterator.next();
    	            int RowNum=row.getRowNum();
    	           System.out.print("RowN=");
    	           //writer.print("RowN=");
    	           System.out.print(RowNum);
    	           //writer.print(RowNum);
    	            System.out.println();
    	           
    	            //For each row, iterate through all the columns
    	            Iterator<Cell> cellIterator = row.cellIterator();
    	            Cell cell = cellIterator.next();
    	           
	                 cell = cellIterator.next();
	                 cell = cellIterator.next();
	                 double FoodCodeA=cell.getNumericCellValue();
	                 cell = cellIterator.next();
	                 double PortionCodeA=cell.getNumericCellValue();
	                 cell = cellIterator.next();
	                 double SubCodeA=cell.getNumericCellValue();
	                 cell = cellIterator.next();
	                 double HowManyA=cell.getNumericCellValue();
	                // System.out.println(FoodCodeA);
	               //  System.out.println(PortionCodeA);
	                 //System.out.println(SubCodeA);
	              //   System.out.println(HowManyA);
	             
	                 //System.out.println();
	                 Iterator<Row> rowIterator2 = sheet2.iterator();
	     	        rowIterator2.next();
	     	       
	 	               if (FoodCodeA<14 || PortionCodeA<12)
	 	                {
	 	            		 Row row2 = rowIterator2.next();
		     	    	     
	 	     	            //rowIterator2.next();
	 	     	            //For each row, iterate through all the columns
	 	     	            Iterator<Cell> cellIterator2 = row2.cellIterator();
	 	     	            Cell cell2 = cellIterator2.next();
	 	            	 cell2=cellIterator2.next();
	 	                	cell2=cellIterator2.next();
	 	                	
	 	                	while(cellIterator2.hasNext()){
								
								//System.out.print(cell2.getNumericCellValue());
		 	                    //A= HowManyA*(cell2.getNumericCellValue());
							//	cellIterator.hasNext();
							//	cell.setCellValue(A);
								System.out.print(0.0);
								
								System.out.print(" ");
								writer.print(0.0);
								writer.print(" ");
								cell2=cellIterator2.next();
								
		 	                	}
								writer.println();
								System.out.println(" ");
								
								
	 	            	
	 	                }// if2 close 
	 	               else{
	 	            	  int flag=0;
	     	        while (rowIterator2.hasNext())
	    	        {
	     	        	 
	     	        	// Iterator<Row> rowIterator2 = sheet2.iterator();
	     	        	 Row row2 = rowIterator2.next();
	     	    	     
	     	            //rowIterator2.next();
	     	            //For each row, iterate through all the columns
	     	            Iterator<Cell> cellIterator2 = row2.cellIterator();
	     	            Cell cell2 = cellIterator2.next();
	     	           
	 	                
	 	                // cell2 = cellIterator2.next();
	 	                 double FoodCodeB=cell2.getNumericCellValue();
	 	                 cell2 = cellIterator2.next();
	 	                 double PortionCodeB=cell2.getNumericCellValue();
	 	                 cell2 = cellIterator2.next();
	 	                 double SubCodeB=cell2.getNumericCellValue();
	 	                // System.out.println(FoodCodeB);
		              //   System.out.println(PortionCodeB);
		              //   System.out.println(SubCodeB);
		              //   System.out.println();
	 	           // String S1=null;
	                 // check if the cells match
	 	               
	 	                 if (FoodCodeA==FoodCodeB && PortionCodeA==PortionCodeB && SubCodeA==SubCodeB && FoodCodeA>=14 && flag==0){
	 	        	     
	 	                	 flag=1;
	 	                	double A = 0;
	 	                	
	 	                	cell2=cellIterator2.next();
	 	                	
							while(cellIterator2.hasNext()){
								
							//System.out.print(cell2.getNumericCellValue());
	 	                    A= HowManyA*(cell2.getNumericCellValue());
	 	                	//S1= Double.toString(A)+S1;
	 	                	
						
							System.out.print(A);
							
							System.out.print(" ");
							writer.print(A);
							writer.print(" ");
							cell2=cellIterator2.next();
							
							//br.readLine();
							
	 	                	} 
							writer.println();
							System.out.println(" ");
	 	                	 
	 	                 }// close if
	 	       
	 	                
	 	                
	 	                
	 	                 
	    	        }// close while sheet2
	                      
	     	      
    	            
    	        }// close while sheet
    	        }
    	        
    	        file.close();
    	       
    	        file2.close();
    	     /*   try {
 	                
	                   String line;
	                   while((line = br.readLine()) != null) {
	                       if(!uniqueTester.contains(line)) {
	                           uniqueTester.add(line);
	                       }
	                   }
	                 } catch (IOException e) {

	                 }*/
    	        writer.close();
    	        
    	     /*   FileOutputStream out = 
    					new FileOutputStream(new File("/Users/spideh/Desktop/Data.xlsx"));
    				workbook.write(out);
    				out.close();*/
    	        
    	        
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	
    	    
    	   
    	    /*    BufferedReader reader = new BufferedReader(new FileReader("/Users/spideh/Desktop/DataOut.txt"));
    	        Set<String> lines = new HashSet<String>(10000); // maybe should be bigger
    	        String line;
    	        while ((line = reader.readLine()) != null) {
    	            lines.add(line);
    	        }
    	        reader.close();
    	        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/spideh/Desktop/DataOut.txt"));
    	        for (String unique : lines) {
    	            writer.write(unique);
    	            writer.newLine();
    	        }
    	        writer.close();
    	    */
    	    
    	    
  
    }
    
}


