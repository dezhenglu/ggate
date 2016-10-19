package com.senyint.common.abs;

import java.util.List;

import org.apache.log4j.Logger;


public abstract class BaseHandle{

    public Logger logger = Logger.getLogger(this.getClass());
    
    private List<String> inParamList;
    private List<String> outParamList;

    public List<String> getInParamList() {
        return inParamList;
    }

    public void setInParamList(List<String> inParamList) {
        this.inParamList = inParamList;
    }

    public List<String> getOutParamList() {
        return outParamList;
    }

    public void setOutParamList(List<String> outParamList) {
        this.outParamList = outParamList;
    }
}
