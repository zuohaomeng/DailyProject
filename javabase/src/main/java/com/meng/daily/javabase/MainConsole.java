package com.meng.daily.javabase;


/**
 * @author ZuoHao
 * @date 2021/1/14
 */
public class MainConsole {
    public static void main(String[] args) {
        try {
            MainConsole mainConsole = new MainConsole();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("------------");
            System.out.println(e.toString());
            System.out.println("------------");
            e.printStackTrace();
        }


    }
    public void fun(int a,int b){
        try {
            int c = a/b;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("------------");
            System.out.println(e.toString());
            System.out.println("------------");
            e.printStackTrace();
        }
    }
}
