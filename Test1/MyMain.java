package Test1;

import java.util.*;


public class MyMain {
    public static void main(String[] args) {

        System.out.println("Ex1:");
        //EX 1:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the name of the citizen:");
        String citizenName = scanner.nextLine();
        System.out.println("Insert citizen ID number:"); // ID must valid (longer than 9 digits)
        String id = scanner.nextLine();
        String additionalDigit = String.valueOf(id.charAt(id.length()-1));
        String theTenth = String.valueOf(id.charAt(id.length()-2));
        String tempString = id.substring(0,id.indexOf(theTenth)) + additionalDigit;
        String tempString2 = id.substring(id.indexOf(theTenth));
        String newID = tempString + tempString2;

        System.out.println("Citizen name:"+citizenName+ " New ID:"+newID);  //--- DONE!!!

        //EX2:
        System.out.println("\nEx2:");
        int[][] matrix1 = new int[10][10];
        int[][] matrix2 = new int[40][40];
//        Scanner scanner2 = new Scanner(System.in);
        // 2 for loops each to initialize the matrixes with scanners
        // matrix[x][y] = scanner2.nextInt(); etc etc

        int count =0;

        // 4 loops to check if muhal
        for(int i =0; i<matrix1.length;i++){
            for(int j=0; j<matrix1.length;j++){
                for(int m1=0; m1<matrix2.length;m1++){
                    for(int m2=0; m2<matrix2.length;m2++){
                        if(matrix1[i][j] == matrix2[m1][m2]) count++;
                    }
                }
            }
        }
        if(count>=100) System.out.println("Matrix1 is INSIDE Matrix2"); // always prints this because of default values
        else System.out.println("Matrix1 NOT INSIDE Matrix2");


        // EX 3:
        System.out.println("\nEx3:");
        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(new Thread(new ThreadFilePlus()));
        threads.add(new Thread(new ThreadFileMinus()));
        threads.add(new Thread(new ThreadFileDiv()));
        threads.add(new Thread(new ThreadFileMulti()));

        for(var th: threads){
            th.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DONE!! ----->>> " + Thread.currentThread().getName());

        // EX 4:
        System.out.println("\nEx4:");
        MathEquation ex4 = new MathEquation(4,3);
        System.out.println("Equation result is: "+ex4.getResult());

        // EX 5-9:
        System.out.println("\nEx5-9:");
        MyProtectedUniqueList myList = new MyProtectedUniqueList("abc");
        try {
            myList.Add("dror");
            myList.Add("Dor");
            myList.Add("Shlomi");
            myList.Add("");
            myList.Add(null);
            myList.Add("dror");
            myList.Add("5");
            myList.Add("55");
        } catch (Exception e) {
            // exception is handled in the class itself
        }
        try {
            myList.Add(1);
            myList.Add(10);
            myList.Add(111);
            myList.Add(14);
            myList.Add(1);
            myList.Add(null);
        } catch (Exception e) {
            // exception is handled in the class itself
        }
        System.out.println(myList);
        try {
            myList.Sort("abc"); // Sorted by HashCode not alphabetically or numerically
        } catch (Exception e) {
            // exception is handled in the class itself
        }
        for(var v: myList){
            System.out.println(v);
        }



    }
}
