package com.senyint.common.handles;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.senyint.common.abs.BaseHandle;

public class Request2DocumentHandle extends BaseHandle implements IHandle {

    private String charsetName1;
    private String charsetName2;
    
    public String getCharsetName1() {
        return charsetName1;
    }

    public void setCharsetName1(String charsetName1) {
        this.charsetName1 = charsetName1;
    }

    public String getCharsetName2() {
        return charsetName2;
    }

    public void setCharsetName2(String charsetName2) {
        this.charsetName2 = charsetName2;
    }

    @Override
    public Object Invoke(Object... obj) throws Exception {
        
        Map data = null;
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        
        for (Object object : obj) {
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
        
        if(data == null || request == null || response == null){
            logger.debug("参数错误"); 
        }
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        InputStream in = request.getInputStream();
        try {
            int temp = in.read();
            while (temp != -1) {
                output.write(temp);
                temp = in.read();
            }
        } catch (Exception e) {
            logger.error(e, e);
        } finally {
            in.close();
        }
        
        ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
        
        logger.debug("接接收的xml："+output); 
        logger.debug("接接收的xml："+input.toString());
        
        Document doc = null;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(input, charsetName1));   
            doc = new SAXReader().read(br);
            logger.debug("以"+ charsetName1 +"字符集解析消息成功。");
        }catch (DocumentException e){
            logger.debug("以"+ charsetName1 +"字符集解析消息失败，尝试以"+ charsetName2 +"解析。");
            input.reset();
            BufferedReader br = new BufferedReader(new InputStreamReader(input, charsetName2));
            doc = new SAXReader().read(br);
            logger.debug("以"+ charsetName2 +"解析成功。");
        }
        
        if(doc == null)
            return null;
        logger.debug(doc.asXML());
        
        data.put(super.getOutParamList().get(0), doc);
        
        return data;
    }
}
