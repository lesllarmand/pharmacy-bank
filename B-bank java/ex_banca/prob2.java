import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class Banca
{
    public static void menuOptions()
    {
        System.out.println();
        System.out.println("CHOOSE WHAT YOU WOULD LIKE TO DO NOW :    0.Try the app with already given clients,if you do not want to insert from keyboard ! (after this step,go for OPTION 2 to see all clients and data)");

        System.out.println("                                          1.Register new client (I do not know why it writes the data from keyboard over the given text in the file,happens every time)");

        System.out.println("                                          2.FISC - see data of all clients");
        System.out.println("       ||to stop application,type EXIT||");
        System.out.println();

        System.out.println("Enter from keyboard the corresponding number (then just press enter)");
        Scanner scanner = new Scanner(System.in);
        String inputKeyboard = scanner.next();
        System.out.println();

        if( inputKeyboard.equals("0"))
        {
            System.out.println("You chose option 0. ");
            System.out.println();
            alreadyAddedClients();
            System.out.println("Now you should go for OPTION 2 in order to see the clients of the bank ! ");
            menuBACKOPTIONS();
        }
        // addClientAccounts ,add the necessary data for registering a new client
        if( inputKeyboard.equals("1"))
        {
            System.out.println("You chose option 1. Please enter data for the new client in the following order :   CNP,Sold Cont EURO,Sold cont RON");
            System.out.println("(For each account EURO - RON you cannot have less than 1000 EURO or 1000 RON !!)");
            System.out.println("After you finished entering data,type EXIT ");
            System.out.println();
            addClientAccounts();
            System.out.println("Run again the app in order to go through the other options !");
            System.out.println();
            //menuBACKOPTIONS();
        }
        if( inputKeyboard.equals("2"))
        {
            System.out.println("You chose option 2. The current clients at our bank(and all data for each) are : ");
            System.out.println("    NUME    ,    CNP    ,  EURO  ,  RON  ");
            System.out.println();
            readClientsData();
            menuBACKOPTIONS();
        }

        if( inputKeyboard.equals("EXIT"))
        {
            System.exit(0);
        }
        
    }
    public static void readClientsData()
    {
        try { //read all data from the file so you can see al the details
             File myObj = new File("dateCLIENTI.txt");
             Scanner myReader = new Scanner(myObj);
             while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                }
            myReader.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
             }
         System.out.println();
    }
    public static void alreadyAddedClients(){
        try {
            FileWriter myWriter = new FileWriter("dateCLIENTI.txt");
            myWriter.write("Andrei Pelicanu,5001018359081,1010,2020");
            myWriter.write("\n");
            myWriter.write("George Borcan,5000112355230,1200,3500");
            myWriter.write("\n");
            myWriter.write("Georgiana Stefan,5000183857230,1100,3200");
            myWriter.write("\n");
            myWriter.write("Andreea Mister,5000112419030,2000,4500");
            myWriter.write("\n");
            myWriter.write("Dumitru Pescaru,5000112438590,0,0");
            myWriter.write("\n");
            myWriter.write("Deian Nastur,5000112419030,0,1000");
            myWriter.close();
            System.out.println("Successfully wrote the clients and their data to the file.");
            System.out.println();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    public static void menuBACKOPTIONS()
    {
        System.out.println("Press B on the keyboard in order to go back at the option page ! :)");
        Scanner scanner2 = new Scanner(System.in);
        String inputKeyboard2 = scanner2.next();
        System.out.println();
        if( inputKeyboard2.equals("B"))
        {
            menuOptions();
        }
    }
    public static void addClientAccounts()
    {
        Scanner reader = null;
        FileWriter writer = null;
        String inputText;
        try{
            // // Reader and writer are instantiated within the try block,
            // // because they can already throw an IOException
            reader = new Scanner(System.in);
            writer = new FileWriter("dateCLIENTI.txt");

            // We read line by line
            while(true) {
                inputText = reader.nextLine();

                // If you type 'EXIT', the application quits
                if (inputText.equals("EXIT")) {
                    break;
                }
                writer.write(inputText);

                // Add the newline character
                writer.write("\n");
            }
        }catch (IOException e) {
            // This exception may occur while reading or writing a line
            System.out.println("An ERROR occurred while reading or writing a line !");

          }finally {
            if (reader != null) 
            {
                reader.close();
            }
            try {
                if (writer != null) 
                {
                    writer.close();
                }
            }catch (IOException e) {
                // This second catch block is a notation we need in Java,
                // because the 'close()' call can itself throw an IOException.
                System.out.println("ERROR at closing !");

            }

        }
    }
          
    // public static void searchSoldRon0Euro0() 
//    {   did not manage to finish this
//        try{
//       String[] words=null;
//       FileReader fr = new FileReader("dateCLIENT.txt");
//       BufferedReader br = new BufferedReader(fr);    
//       String input=",0,";   // Input word to be searched
//       int count=1;   //Intialize the lines to 1
//       while((s=br.readLine())!=null)   //Reading Content from the file
//       {
//             //search for the 0 account and delete the line for ex 2
//       }
//       if(count!=1)
//       {
//          System.out.println("The client from line 4 has 0 in one of the 2 accounts : EURO or RON !");
//       }  
//          fr.close();
//     }catch (IOException e)
//     {
//         System.out.println("An error occurred.");
//         e.printStackTrace();
//     }
  // }
    public static void main(String[] args)
    {
        System.out.println();
        //CREATING A FILE
        try{
            File fileObj = new File("dateCLIENTI.txt");
            
            if( fileObj.createNewFile() == true )
            {
                System.out.println("The file was succesfully created : " + fileObj.getName());
            }
            else
            {
                System.out.println("The file already exists !");
            }
        }catch (IOException e) {
            System.out.println("ERROR : The file cannot be created for some reason !");
            e.printStackTrace(); // with this it will show the name of the exception ,the description,also the location on a new line
        }

        //MENU for OPTIONS
        menuOptions();
        
       }

}