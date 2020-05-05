package com.myserver.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class VO_backup {
 
    private String result;
    
    public VO_backup(){
        
    }
    public VO_backup(String result) {
        super();
        this.result = result;
    }
    
    @XmlElement
    public String getResult() {
        return result;
    }
 
    public void setResult(String result) {
        this.result = result;
    }
 
    @Override
    public String toString() {
        return "Root [result=" + result + "]";
    }
 
    
    
}