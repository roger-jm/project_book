package com.jm.java.str;

/**
 * Created by Roger on 2015/9/10.
 */
public class StringTest {
    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i=0;i<200000;i++){
            // StringBuilder sb = new StringBuilder();
            StringBuffer sb = new StringBuffer();
            sb.append("amber");
            sb.append("black");
            sb.append("cyan");
            sb.append("denim");
        }
        System.out.println(System.currentTimeMillis()-b);
    }
}
