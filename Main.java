package com.company;

import java.io.FileNotFoundException;

public class Main {



    public static void main(String[] args) throws FileNotFoundException {

        final String fileToConvert =  ("C:\\Users\\row3b\\IdeaProjects\\HW #2 CMPE 131\\src\\testFile.txt");
        fileConverter f = new fileConverter();

         f.fileConvert(fileToConvert, "-c");
         f.fileConvert(fileToConvert, "-j");
         f.fileConvert(fileToConvert, "-x");

    }
}
