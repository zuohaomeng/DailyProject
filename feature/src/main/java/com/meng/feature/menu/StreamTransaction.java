package com.meng.feature.menu;

import com.alibaba.fastjson.JSON;
import com.meng.feature.bean.Apple;
import com.meng.feature.bean.Trader;
import com.meng.feature.bean.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description Stream交易员练习题
 * @Author ZuoHao
 * @Date 2020/9/7 20:55
 */
public class StreamTransaction {
    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario", "Milan");
    static Trader alan = new Trader("Alan", "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");
    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        StreamTransaction streamTransaction = new StreamTransaction();
        part1();
        part2();
        part3();
    }

    /**
     * 找出2011年发生的所有交易，并交易额排序
     */
    public static void part1() {
        System.out.println("找出2011年发生的所有交易，并交易额排序");
        transactions.stream()
                .filter(e -> 2012 == e.getYear())
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
    }

    public static void part2() {
        System.out.println("交易员都在哪些不同的城市");
        transactions.stream()
                .map(e -> e.getTraders().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    public static void part3() {
        System.out.println("查找所有来自剑桥的交易员，并按名字排序");
        transactions.stream()
                .filter(e -> e.getTraders().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(o -> o.getTraders().getName()))
                .forEach(System.out::println);
    }

}
