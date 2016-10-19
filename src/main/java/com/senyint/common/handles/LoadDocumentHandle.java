package com.senyint.common.handles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;

import com.senyint.common.abs.BaseHandle;
import com.senyint.common.util.Command;

public class LoadDocumentHandle extends BaseHandle implements IHandle {
    
    private Map<String,String> xPathMap;

    public Map<String, String> getxPathMap() {
        return xPathMap;
    }
    public void setxPathMap(Map<String, String> xPathMap) {
        this.xPathMap = xPathMap;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
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
            logger.debug("LoadCommandHandle参数错误"); 
        }
        
        Document doc = (Document)data.get(getInParamList().get(0));
        
        if(doc == null){
            logger.error("LoadCommandHandle:Document为空");
            return null;
        }
        
        logger.debug(doc.asXML());
        Element root = doc.getRootElement();
        
        Element element;
        Map docData = new HashMap();
        for (String key : this.xPathMap.keySet()) {
            String[] value = this.xPathMap.get(key).split(":");
            if(value[1].equals("text")){
                element = (Element) root.selectSingleNode(value[0]);
                docData.put(key, element.getText());
            }else if(value[1].equals("map")){
                element = (Element) root.selectSingleNode(value[0]);
                List<?> datas = element.elements();
                Map d = new HashMap();
                for(int index=0;index<datas.size();index++){
                    Element el = (Element)datas.get(index);
                    d.put(el.getName(), el.getTextTrim());
                }
                docData.put(key, d);
            }
        }
        
        data.put(this.getOutParamList().get(0), docData);
        
        return data;
    }

}
