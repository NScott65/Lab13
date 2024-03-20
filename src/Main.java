import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<String> greg = new ArrayList<String>(10);

    public static boolean done = false;
    public static void main(String[] args) throws IOException {
    

        boolean loaded = false;
        boolean edited = false;
        String fileName = "";
        String choice = "";
        String newWord = "";
        int delNum = 0;
        do {


            choice = Helper.getRegExString(scan, "\nWould you like to \nA - Add an item to the list,\n" +
                    "D - Delete an Item from the List\nV - View the List\nO - Open File\nS - Save File\nC - Clear File\nQ - Quit the Program", "[AaDdQqOoSsCcVv]");

            if (choice.equalsIgnoreCase("a")) {

                newWord = Helper.getNonZeroLengString(scan, "Enter your word: ");
                addString(newWord);
                edited = true;

            } else if (choice.equalsIgnoreCase("d")) {
                delNum = Helper.getInt(scan, "Enter the index of the word you want to delete: ");
                deleteString(delNum);
                edited = true;

            } else if (choice.equalsIgnoreCase("v")) {
                if(loaded) {
                    viewList();
                }

            } else if (choice.equalsIgnoreCase("q")) {
                quit();
            }else if (choice.equalsIgnoreCase("o")){
                if(edited){
                    if(loaded){
                        IOHelper.writeFile(greg, fileName);
                    }else {
                        if(Helper.getYNConfirm(scan, "Do you want to save the current list before opening another?")){
                            IOHelper.writeFile(greg, Helper.getNonZeroLengString(scan, "Enter File Name: "));
                        }
                    }
                }
                greg.clear();
                loaded = true;
                fileName = IOHelper.openFile(greg);

            }else if (choice.equalsIgnoreCase("s")){
                if (loaded) {
                    if(edited){
                        System.out.println("Please enter the name of your file: ");
                        fileName = scan.nextLine();
                        IOHelper.writeFile(greg,fileName);
                    }
                }
                loaded = false;
                edited = false;
                greg.clear();


            }else if (choice.equalsIgnoreCase("c")){
                if(loaded) {
                    greg.clear();
                }
                edited = true;
            }
        }while(!done);

    }

    public static void addString(String input){
        boolean valid = false;

        do {
            if (input.length() > 0) {
                greg.add(input);
                valid = true;
            } else {
                System.out.println("Your input was inlaid. Try Again.");
            }
        }while (!valid);
    }

    public static void deleteString(int index){

        boolean valid = false;

        do {
            if(index >= 0 && index <= greg.size()){
                greg.remove(index);
                valid = true;
            }else{
                System.out.println("Your input was invalid. Try Again.");
            }
        }while(!valid);

    }

    public static void viewList(){
        System.out.print(greg);
    }

    public static void quit(){
        done = true;
    }
}