package com.senyint.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandleUtil {

    
    public static void GetRRD(Map data, HttpServletRequest request, HttpServletResponse response,Object... objs){
        
        for (Object object : objs) {
            if(object instanceof Map){
                data = (HashMap)object;
            }
            if(object instanceof HttpServletRequest){
                request = (HttpServletRequest)object;
            }
            if(object instanceof HttpServletResponse){
                response = (HttpServletResponse)object;
            }
        }
    }
}
