//import java.io.*;
//import java.util.*;
//public class FileReaderFormer {
//    ArrayList<Flight> flight = new ArrayList<>();
//    ArrayList<String> columns = new ArrayList<>();
//
//    public FileReaderFormer(String filename) {
//        try {
//            Scanner in = new Scanner(new FileReader(filename));
//
//            /*
//            //To print out all data:
//            while (in.hasNextLine()) {
//                if(columns.size() == 0) {
//                    String nextLine = in.nextLine();
//                    System.out.println(nextLine);
//                }
//            }
//             */
//            while (in.hasNextLine()) {
//                //Read only column headers
//                if(columns.size() == 0) {
//                    String nextLine = in.nextLine();
//                    for (String str : nextLine.split(",")) { //this is using the comma between the headers to
//                        //split the headers
//                        System.out.println(str);
//                        columns.add(str);
//                    }
//                    System.out.println(columns);
//                } else {
////                    System.out.println(in.nextLine()); //prints out the rest of the data
////                    flight.add(in.nextLine());
////                    parseFlight(in.nextLine());
//                    flight.add(parseFlight(in.nextLine()));
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Did not read file");
//        }
//    }
//
//    public boolean isInteger (String input) {
//        try {
//            Integer.parseInt(input);
//            return true;
//        }
//        catch(Exception e) {
//            return false;
//        }
//    }
//
//    public Flight parseFlight(String row) {
//        String newRow = "";
//
//        for (char c : row.toCharArray()) {
//            if (c == ',') {
//                newRow += ";;";
//            } else {
//                newRow += c;
//            }
//        }
//
//        //Split into an array
//
//        String[] newRowArr = newRow.split(";;");
//
////        String DestStateName = newRowArr[10].length() == 0 ? String.valueOf(-1) : newRowArr[10];
////
//
//        Flight f = new Flight(
//                isInteger(Integer.parseInt(newRowArr[0])),
//                Integer.parseInt(newRowArr[1]),
//                newRowArr[2],
//                newRowArr[3],
//                newRowArr[4],
//                newRowArr[5],
//                newRowArr[6],
//                newRowArr[7],
//                newRowArr[8],
//                newRowArr[9],
//                DestStateName,
//                Integer.parseInt(newRowArr[11]),
//                Integer.parseInt(newRowArr[12]),
//                Integer.parseInt(newRowArr[13]),
//                Integer.parseInt(newRowArr[14]),
//                Integer.parseInt(newRowArr[15]),
//                Integer.parseInt(newRowArr[16]),
//                Integer.parseInt(newRowArr[17]),
//                newRowArr[18],
//                Integer.parseInt(newRowArr[19]),
//                Integer.parseInt(newRowArr[20]),
//                Integer.parseInt(newRowArr[21]));
//
//        return f;
//    }
//
////    public Flight parseFlight(String row) {
////        String newRow = "";
////
////        for (char c : row.toCharArray()) {
////            if (c == ',') {
////                newRow += ";;";
////            } else {
////                newRow += c;
////            }
////        }
////        return System.out.println(newRow);
////    }
//
//    public static void main(String[] args) {
//        FileReaderFormer fr = new FileReaderFormer("flights_small");
//    }
//}
