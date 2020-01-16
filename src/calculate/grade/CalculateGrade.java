package calculate.grade;

import java.util.Formatter;
import java.util.Scanner;

public class CalculateGrade {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String courseTitle, courseCode;
        int numberOfStudents;
        
        String[] studentName = new String[1000];
        float[] score = new float[1000];
        char[] grade = new char[1000];
        
        System.out.print("Enter the course code: ");
        courseCode = (input.nextLine()).toUpperCase();
        System.out.print("Enter the course title: ");
        courseTitle = (input.nextLine()).toUpperCase();
        
        System.out.print("How many students took " + courseCode + "? ");
        numberOfStudents = input.nextInt();
        
        System.out.println();
        
        for (int i = 0; i < numberOfStudents; i++){
            System.out.println("\nStudent " + (i+1));
            System.out.print("Name: ");
            studentName[i] = input.nextLine();
            studentName[i] = input.nextLine();
            System.out.print("Score: ");
            score[i] = input.nextFloat();
            
            //Get the grades
            if (score[i] >= 70 && score[i] <= 100){
                grade[i] = 'A';
            }
            else if(score[i] >= 60 && score[i] < 70){
                grade[i] = 'B';
            }
            else if(score[i] >= 50 && score[i] < 60){
                grade[i] = 'C';
            }
            else if(score[i] >= 45 && score[i] < 50){
                grade[i] = 'D';
            }
            else if(score[i] >= 40 && score[i] < 45){
                grade[i] = 'E';
            }
            else if(score[i] >= 0 && score[i] < 40){
                grade[i] = 'F';
            }
            else {
                grade[i] = '-';
            }
        }
        
        System.out.println();
        
        //Print results
        System.out.println(courseCode + ": " + courseTitle);
        System.out.println("RESULTS\n");
        System.out.println("S/N NAME                SCORE   GRADE");
        for(int i = 0; i < numberOfStudents; i++){
            System.out.println((i+1) + "   " + studentName[i] +"      " + score[i] + "     " + grade[i]) ;
        }
        
        try{
            Formatter f = new Formatter(courseCode + " Results.txt");
            //\r\n is for new line
            //use f.format( + "\r\n");
            
            f.format(courseCode + ": " + courseTitle + "\r\n");
            f.format("RESULTS\r\n\r\n");
            f.format("S/N NAME\t\tSCORE\t\tGRADE\r\n");
            
            for(int i = 0; i < numberOfStudents; i++){
                f.format((i+1) + "   " + studentName[i] +"\t" + score[i] + "\t\t" + grade[i] + "\r\n") ;
            }
 
            f.close();
        } catch (Exception E){
            System.out.println("Error");
        }
    }
    
}
