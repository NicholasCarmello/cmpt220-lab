import java.io.*; //java io class

import java.io.File ;       // import file class

//main header of the program
public class Splitter{  

    //main method of the program
        public static void main(String []args)throws IOException{
          

            //takes command lind argument
        String argument = args[0];
        
        //creates a new file with that picture for the assignment
        RandomAccessFile file1 = new RandomAccessFile(argument, "rw");

        //takes command line arguments and parses them into integers

       
       long length = file1.length();
       long parse1 = Long.parseLong(args[1]);

       long equalLength = length / parse1;

       int length1 = (int) length;
       int divided = (int) equalLength;

       //creates new array with the files bytes as the outcome
       int[] newArray = new int[length1];

       //prints out how many bytes will be in each file
       System.out.println("The equal length of the new files will be " + equalLength);
       
      

       //takes every byte from the file and puts it into the array 
       for(int i = 0; i < length1;i++){

        newArray[i] = file1.read();
        
           
           

       }
       
       
       //just another variabkle to keep divided in
       int runningTotal = divided;

       //this goes through the files and puts the bytes into them
       for(int o = 0; o <parse1 ; o ++){
        RandomAccessFile input = new RandomAccessFile("sample_image"+ o + ".jpg","rw");

        
    
        for(int a = 0; a < divided; a++){
            if (o >=1 && a == 0){
                a = divided;
               
                divided += runningTotal;
                
                
            
            }
            if (a == length1 || a == length1 + 1){
                System.exit(0);
            }
            

        
            
                input.write(newArray[a]);

                
           
        }
       }

      
       


        
      

      
       
       
    }
}