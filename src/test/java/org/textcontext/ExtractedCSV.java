package org.textcontext;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class ExtractedCSV {
	static String downloadFolderPath = "C:\\Users\\HP\\Downloads";
    String destinationFolderPath = "C:\\Users\\HP\\Downloads\\Loop";
    File latestFile; 
	public void FileOperation() {
		
     // Get the latest download file
		latestFile = getLatestDownloadFile(downloadFolderPath);
        if (latestFile != null) {
            // Delete the old file if it exists
            deleteFileIfExists(destinationFolderPath);

            // Move the latest file to the destination folder and rename it
            Path source = Paths.get(latestFile.getAbsolutePath());
            Path destination = Paths.get(destinationFolderPath, "data.csv");

            try {
                Files.move(source, destination);
                System.out.println("File moved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file found in the download folder.");
        }
    }

	private static void deleteFileIfExists(String destinationFolderPath) {
        File oldFile = new File(destinationFolderPath, "data.csv");
        if (oldFile.exists()) {
            oldFile.delete();
            System.out.println("Old file deleted.");
        }
    }

	private static File getLatestDownloadFile(String downloadFolderPath) {
		File downloadFolder = new File(downloadFolderPath);
        File[] files = downloadFolder.listFiles();

        if (files != null && files.length > 0) {
            File latestFile = files[0];
            for (File file : files) {
                if (file.lastModified() > latestFile.lastModified()) {
                    latestFile = file;
                }
            }
            return latestFile;
        }
        return null;
	
	}
	
	public void orderIdCheck() {
		try {
			String csvFilePath= "C:\\Users\\HP\\Downloads\\Loop\\data.csv";
			CSVReader reader = new CSVReader(new FileReader(csvFilePath));
			List<String[]> csvData = reader.readAll();
			String[] headers = csvData.get(0);
			//To find the orderId column index
			int orderIdIndex = -1;
			for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase("order_id")) {
                    orderIdIndex = i;
                    break;
                }
            }
			 if (orderIdIndex != -1) {
	                System.out.println("The 'order id' column is present.");

	                // Check if values in "order id" column are in ascending order
	                List<String> orderIdValues = new ArrayList();
	                boolean ascendingOrder = true;

	                for (int i = 1; i < csvData.size(); i++) {
	                	
	                    String[] row = csvData.get(i);	
	                    String replace = row[orderIdIndex].trim().replace("O", "").replace("-", "");
	                    orderIdValues.add(replace);
	                    //orderIdValues.add(Integer.parseInt(replace));
	                   // BigInteger orderIdBigInt = new BigInteger(replace);
	                    //orderIdchecked(replace);
	                   //long parseInt = Long.parseLong(orderIdBigInt);
	                    //orderIdValues.add(orderIdBigInt);
	                }

	                for (int i = 1; i < orderIdValues.size(); i++) {
	                	int comparedvalues= orderIdValues.get(i-1).compareTo(orderIdValues.get(i)); //1<0
	                    if (comparedvalues > 0) {
	                        ascendingOrder = false;
	                        break;
	                    }
	                }

	                if (ascendingOrder) {
	                    System.out.println("The 'order id' column values are in ascending order.");
	                } else {
	                    System.out.println("The 'order id' column values are not in ascending order.");
	                }
	            } else {
	                System.out.println("The 'order id' column is not present.");
	            }

	            // Close the reader
	            reader.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	    
	}
	/*
	public static boolean orderIdchecked(String orderId) {
        try {
            // Parse the Order ID as a BigInteger
            BigInteger orderIdBigInt = new BigInteger(orderId.replaceAll("[^0-9]", ""));

            // Check if the Order ID is greater than zero
            return orderIdBigInt.compareTo(BigInteger.ZERO) > 0;
        } catch (NumberFormatException e) {
            // Handle the case where the Order ID cannot be parsed
            return false;
        }
    }*/
}
