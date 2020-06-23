package com.hjh.test.testJava;

/**
 * 栈上分配,逃逸分析(翻车了...还是会GC)
 * VM Options:
 * -Xmx1050M -Xms500M -XX:+DoEscapeAnalysis
 * -XX:+PrintGC -XX:-UseTLAB
 * -XX:+EliminateAllocations
 *
 *
 * 启动
 * java  -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis
 * -XX:+PrintGC -XX:-UseTLAB -XX:+EliminateAllocations
 * -classpath "D:\Study\test\testJava\target\classes" com.hjh.test.testJava.OnStackTest
 *
 *
 */
public class OnStackTest {
    public static class User {
        private int id=0;

        private String name="";

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

//    public static void alloc() {
//        User user = new User();
//        user.id = 10;
//        user.name = "aa";
//    }
//
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000000; i++) {
//            alloc();
//        }
//        long end = System.currentTimeMillis();
//
//        System.out.println(end - start);
//    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("blueStarWei");
    }
}
