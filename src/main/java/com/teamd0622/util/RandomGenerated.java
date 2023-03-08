package com.teamd0622.util;

import java.util.Random;

public class RandomGenerated {
    public String randomString(int len){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        StringBuilder stringBuffer = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int number = random.nextInt(62);
            stringBuffer.append(str.charAt(number));
        }

        return stringBuffer.toString();

    }

    public String randomEmailAddress(){
        RandomGenerated randomGenerated = new RandomGenerated();
        String prefix = randomGenerated.randomString(7);
        String postfix = randomGenerated.randomString(3);
        return prefix + "@" + postfix + ".com";
    }

    public int randomInt(){
        return new Random().nextInt(1000);
    }

    //test
    public static void main(String[] args) {
        System.out.println(new RandomGenerated().randomString(10));
        System.out.println(new RandomGenerated().randomEmailAddress());
        System.out.println(new RandomGenerated().randomInt());
    }
}
