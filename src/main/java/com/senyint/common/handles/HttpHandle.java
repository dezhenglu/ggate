package com.senyint.common.handles;

public class HttpHandle implements IHandle {

    @Override
    public Object Invoke(Object... objs) {
        System.out.println("HttpHandle:Invoke...");
        return null;
    }
}
