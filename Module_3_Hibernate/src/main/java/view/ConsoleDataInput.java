package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ConsoleDataInput {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static Date readDate() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = bufferedReader.readLine();
        Date date = new Date();

        try {

            date = formatter.parse(dateInString);


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static int readInt() throws IOException {
        int number = 1;
        try {
            number = Integer.parseInt(bufferedReader.readLine());

        }catch (NumberFormatException e){
            ConsoleDataInput.writeMessage("Incorrect data, repeat input");
            readInt();
        }
        return number;
    }
}
