package utils;

public class TextHandler {

    public static int getInt(String str){
        return Integer.parseInt(str.replaceAll("[^0-9]", ""));
    }

    public static long getLong(String str){
        return Long.parseLong(str.replaceAll("[^0-9]", ""));
    }

}

