package com.jm.java.str.build;

/**
 * Created by Roger on 2015/9/14.
 */
public class Demo {
   // StringBuilder sb = new StringBuilder();
    StringBuffer sb = new StringBuffer();
    public void addStr(){
        sb.append("I am a String builder");
    }



    public void run1(){
        for (int i=0;i<100;i++){
            Thread t = new Thread(){
                @Override
                public void run() {
                    addStr();
                }
            };
            t.setName("name" + i);
            t.start();
            System.out.println(t.getName() + ":" +sb);
        }
    }
}
