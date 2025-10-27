package Lab03.AimsProject.hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

    public static void main(String[] args) {
        String filename = "C:/Windows/System32/notepad.exe"; 

        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            
            String outputString = "";
            for (byte b : inputBytes) {

                outputString += (char)b; 
            }
            
            endTime = System.currentTimeMillis();
            
            
            System.out.println((endTime - startTime));
            System.out.println("---------------------------------");
            
        } catch (IOException e) {
            System.err.println("File unknown.");
        }
    }
}