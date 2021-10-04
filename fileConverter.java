package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class fileConverter {


    //constructor method, calls method depending on what type of file we want to convert to
    public void fileConvert(String file, String datatype) throws FileNotFoundException {

        if (datatype.equals("-c")) {
            convertCSV(file);
        }
        if (datatype.equals("-j")) {
            convertJSON(file);
        }
        if (datatype.equals("-x")) {
            convertXML(file);
        }

    }


    //converts file to XML, very similar to JSON
    private void convertXML(String inputFile) throws FileNotFoundException {

        //Create Scanner object to parse file, StringBuilder to properly format.  Create new array of strings with all tags.
        Scanner fileScnr = new Scanner(new File(inputFile));
        StringBuilder frmtedFile = new StringBuilder();
        String[] tagArray = fileScnr.nextLine().split("\\t");

        //Format the text file to JSON.
        frmtedFile.append("<players>" + "\n");
        while (fileScnr.hasNextLine()) {
            String [] currLine = fileScnr.nextLine().split("\\t");

            //i want to go to bed, im sorry for my sins
            frmtedFile.append("\t<player>\n");
            for (int i = 0; i < tagArray.length; i++){
                tagArray[i] = tagArray[i].replaceAll(" ","");
                tagArray[i] = tagArray[i].replaceAll("/", "");
                tagArray[i] = tagArray[i].replaceAll("\\(", "");
                tagArray[i] = tagArray[i].replaceAll("\\)", "");
                tagArray[i] = tagArray[i].replaceAll("1", "");
                tagArray[i] = tagArray[i].replaceAll("2", "");
                tagArray[i] = tagArray[i].replaceAll("3", "");
                tagArray[i] = tagArray[i].replaceAll("4", "");
                tagArray[i] = tagArray[i].replaceAll("5", "");
                tagArray[i] = tagArray[i].replaceAll("6", "");
                tagArray[i] = tagArray[i].replaceAll("7", "");
                tagArray[i] = tagArray[i].replaceAll("8", "");
                tagArray[i] = tagArray[i].replaceAll("9", "");
                tagArray[i] = tagArray[i].replaceAll("0", "");
                frmtedFile.append("\t\t" + '<' + tagArray[i] + '>'  + currLine[i].replaceAll(" ",""));
                frmtedFile.append("</" + tagArray[i]  + ">\n");
            }
            frmtedFile.append("\t</player>\n");
        }
        frmtedFile.append("\n</players>");

        //Write out to new file, close stream.
        PrintWriter out = new PrintWriter("C:\\Users\\row3b\\IdeaProjects\\HW #2 CMPE 131\\src\\outputXML.xml");
        out.print(frmtedFile);
        out.close();

    }


    private void convertJSON(String inputFile) throws FileNotFoundException {

        //Create Scanner object to parse file, StringBuilder to properly format.  Create new array of strings with all tags.
        Scanner fileScnr = new Scanner(new File(inputFile));
        StringBuilder frmtedFile = new StringBuilder();
        String[] tagArray = fileScnr.nextLine().split("\\t");

        //Format the text file to JSON.
        frmtedFile.append("[" + "\n");
        while (fileScnr.hasNextLine()) {
            String [] currLine = fileScnr.nextLine().split("\\t");
            frmtedFile.append("\t{\n");
            for (int i = 0; i < tagArray.length; i++){
                frmtedFile.append("\t\t" + '"' + tagArray[i]+'"' + ":" + '"' + currLine[i] + '"');
                if (i < tagArray.length-1){
                    frmtedFile.append(",");
                }
                frmtedFile.append("\n");
            }
            frmtedFile.append("\t},\n");
        }
        frmtedFile.delete(frmtedFile.length()-2,frmtedFile.length());
        frmtedFile.append("\n]");

        //Write out to new file, close stream.
        PrintWriter out = new PrintWriter("C:\\Users\\row3b\\IdeaProjects\\HW #2 CMPE 131\\src\\outputJSON.json");
        out.print(frmtedFile);
        out.close();

    }

    public void convertCSV(String inputFile) throws FileNotFoundException {

        Scanner fileScnr = new Scanner(new File(inputFile));
        StringBuilder frmtedFile = new StringBuilder();

        //Format the text file to CSV.
        while (fileScnr.hasNextLine()) {
            String currLine = fileScnr.nextLine();
            currLine = (currLine.replaceAll("\\t", ","));
            frmtedFile.append(currLine);
            frmtedFile.append("\n");
        }

        //Write out to new file, close stream.
        PrintWriter out = new PrintWriter("C:\\Users\\row3b\\IdeaProjects\\HW #2 CMPE 131\\src\\outputCSV.csv");
        out.print(frmtedFile);
        out.close();
    }

}


