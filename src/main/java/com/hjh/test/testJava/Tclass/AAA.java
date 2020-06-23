package com.hjh.test.testJava.Tclass;

import java.util.Map;

/**
 * 泛型的翻车现场....
 * 类DDD的test里面注释去掉为什么编译不过
 */
public class AAA   {

   class BBB<T>{
       protected ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

   }

    class DDD extends BBB {
        public void test(){
            //TODO:这里取消注释为什么编译不过???
            //Object o = threadLocal.get().get('1');
        }
    }

   class CCC extends  BBB<Integer>{
       public void test(){
           Object o = threadLocal.get().get('1');
       }
   }
   
}
