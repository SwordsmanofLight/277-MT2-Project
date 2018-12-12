import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//Mateo S Perez Olmedo
//CECS277 - MT2 Coding Problem

public class Driver {
    public static void main(String[] args) {
        File file = new File("babynames.txt");
        ArrayList<String> boys = new ArrayList<>();
        ArrayList<String> girls = new ArrayList<>();
        Scanner in = null;
        PrintWriter outBoys = null;
        PrintWriter outGirls = null;

        try {
            in = new Scanner(file);
            outBoys = new PrintWriter("boynames.txt");
            outGirls = new PrintWriter("girlnames.txt");
            while (in.hasNextLine()) {
                int rank = in.nextInt();
                String boyname = in.next();
                boys.add(boyname);
                outBoys.println(rank + " " + boyname + " " + in.nextInt() + " " + in.nextDouble());
                String girlname = in.next();
                girls.add(girlname);
                outGirls.println(rank + " " + girlname + " " + in.nextInt() + " " + in.nextDouble());
            }
        } catch (FileNotFoundException | InputMismatchException e) {
            e.printStackTrace();
        } finally {
            assert in != null;
            in.close();
            assert outBoys != null;
            outBoys.close();
            assert outGirls != null;
            outGirls.close();
        }

        System.out.println("===Names For Both Boys and Girls===");
        for (String boy : boys) {
            if (girls.contains(boy)) {
                System.out.println(boy);
            }
        }
    }
}
