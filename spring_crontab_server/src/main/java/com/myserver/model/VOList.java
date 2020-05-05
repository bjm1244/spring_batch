package com.myserver.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="company")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class VOList {
	@XmlElement(name="record")
    private List<VO> list;
 
    public VOList(List<VO> list) {
        this.list = list;
    }
 
    public VOList() {
        super();
    }
 
    public List<VO> getList() {
        return list;
    }
 
    public void setList(List<VO> list) {
        this.list = list;
    }
}
