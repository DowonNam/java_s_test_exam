package org.example.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CommonUtil {
    private Scanner scan = new Scanner(System.in);
    public Scanner getScan(){
        return scan;
    }

    public String getCurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String dateFormatted = now.format(formatter);
        return dateFormatted;
    }
}
