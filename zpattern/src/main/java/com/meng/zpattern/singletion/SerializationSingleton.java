package com.meng.zpattern.singletion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化反射破坏单例模式
 *
 * @author ZuoHao
 * @date 2021/1/2
 */
public class SerializationSingleton {
    public static void main(String[] args) {
        HungrySingleton s1 = null;
        HungrySingleton s2 = HungrySingleton.getHungrySingletion();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("HungrySingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();
            FileInputStream fis = new FileInputStream("HungrySingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (HungrySingleton) ois.readObject();
            ois.close();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
