package com.jm.java.inner;

import static com.jm.java.inner.ClassA.*;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/28
 * At 10:41
 */
public class ClassB {
    public void invokeInner(){
        InnerClass innerClass = new InnerClass();
        innerClass.print();
    }

}
