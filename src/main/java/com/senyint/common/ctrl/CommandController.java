package com.senyint.common.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.senyint.common.handles.IHandle;

public class CommandController extends AbstractController{

    Logger logger = Logger.getLogger(this.getClass());
    
    private List<IHandle> handleList;
    
    public List<IHandle> getHandleList() {
        return handleList;
    }

    public void setHandleList(List<IHandle> handleList) {
        this.handleList = handleList;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String reAddr = request.getRemoteAddr();
        String reHost = request.getRemoteHost();
        int rePort = request.getRemotePort();
        String reUser = request.getRemoteUser();

        StringBuffer sb = new StringBuffer();
        sb.append("Got request from Address[" + reAddr + "],Host[" + reHost
                + "],Port[" + rePort + "],User[" + reUser + "]");

        logger.debug(sb.toString());
        
        Map data = new HashMap();
        
        for (IHandle iHandle : handleList) {
            iHandle.Invoke(data,request,response);
        }
        
        return new ModelAndView("main",data);
    }

}
