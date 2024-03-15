import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<String> greg = new ArrayList<String>(10);

    public static boolean done = false;
    public static void main(String[] args) {
    


        String choice = "";
        String newWord = "";
        int delNum = 0;
        do {


            choice = Helper.getRegExString(scan, "Would you like to \nA - Add an item to the list,\nD - Delete an Item from the List\nP - Print the List\nQ - Quit the Program", "[AaDdPpQq]");

            if (choice.equalsIgnoreCase("a")) {

                newWord = Helper.getNonZeroLengString(scan, "Enter your word: ");
                addString(newWord);
            } else if (choice.equalsIgnoreCase("d")) {
                delNum = Helper.getInt(scan, "Enter the index of the word you want to delete: ");
                deleteString(delNum);

            } else if (choice.equalsIgnoreCase("p")) {
                printList();
            } else if (choice.equalsIgnoreCase("q")) {
                quit();
            }else if (choice.equalsIgnoreCase("o")){

            }else if (choice.equalsIgnoreCase("s")){

            }else if (choice.equalsIgnoreCase("c")){

            }else if(choice.equalsIgnoreCase("v")){

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

    public static void printList(){
        System.out.print(greg);
    }

    public static void quit(){
        done = true;
    }
}