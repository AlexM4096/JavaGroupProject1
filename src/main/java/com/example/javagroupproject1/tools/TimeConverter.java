package com.example.javagroupproject1.tools;

public class TimeConverter {
    public static String convertFromMinutes(int timeInMinutes) {
        String string = "";

        int cookingHours = timeInMinutes / 60;
        if (cookingHours > 0){
            String cookingHoursWord = switch (cookingHours % 10) {
                case 1 -> "час";
                case 2, 3, 4 -> "часа";
                default -> "часов";
            };

            if (cookingHours > 10 &&  cookingHours < 20)
                cookingHoursWord = "часов";

            string += cookingHours + " " + cookingHoursWord + " ";
        }

        int cookingMinutes = timeInMinutes % 60;
        if (cookingMinutes > 0){
            String cookingMinutesWord = switch (cookingMinutes % 10) {
                case 1 -> "минута";
                case 2, 3, 4 -> "минуты";
                default -> "минут";
            };

            string += cookingMinutes + " " + cookingMinutesWord;
        }

        return string;
    }

    public static int convertToMinutes(String string){
        String[] strings = string.split(" ");
        int length = strings.length;
        int result = 0;

        if (length == 2){
            String str = strings[1];
            int a = Integer.parseInt(strings[0]);

            if (str.contains("минут")){
                result = a;
            }
            else if (str.contains("час")){
                result = a * 60;
            }

        }
        else if (length == 4){
            String str = strings[3];
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[2]);

            result = a * 60 + b;
        }

        return result;
    }
}
