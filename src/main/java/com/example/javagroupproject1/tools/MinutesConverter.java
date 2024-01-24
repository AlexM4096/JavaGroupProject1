package com.example.javagroupproject1.tools;

public class MinutesConverter {
    public static String convert(int timeInMinutes) {
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
            string += cookingHours + " " + cookingMinutesWord;
        }

        return string;
    }
}
