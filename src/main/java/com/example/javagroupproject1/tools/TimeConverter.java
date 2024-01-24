package com.example.javagroupproject1.tools;

public class TimeConverter {
    public static String convertFromMinutes(int timeInMinutes) {
        String string = "";

        int cookingHours = timeInMinutes / 60;
        if (cookingHours > 0){
            String cookingHoursWord;

            switch (cookingHours){
                case 1:
                    cookingHoursWord = "час";
                    break;
                case 2, 3, 4:
                    cookingHoursWord = "часа";
                    break;
                default:
                    cookingHoursWord = "часов";
                    break;
            }
            string += cookingHours + " " + cookingHoursWord + " ";
        }

        int cookingMinutes = timeInMinutes % 60;
        if (cookingMinutes> 0){
            String cookingMinutesWord;

            switch (cookingHours){
                case 1:
                    cookingMinutesWord = "минута";
                    break;
                case 2, 3, 4:
                    cookingMinutesWord = "минуты";
                    break;
                default:
                    cookingMinutesWord = "минут";
                    break;
            }
            string += cookingMinutes + " " + cookingMinutesWord;
        }

        return string;
    }

    public static int convertToMinutes(String string){
        String[] strings = string.split(" ");
        int length = strings.length;

        if (length == 2){
            String str = strings[1];
            int a = Integer.parseInt(strings[0]);

            if (str.contains("минут")){
                return a;
            }
            else if (str.contains("час")){
                return a * 60;
            }

        }
        else if (length == 4){
            String str = strings[3];
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[2]);

            return a * 60 + b;
        }

        return 0;
    }
}
