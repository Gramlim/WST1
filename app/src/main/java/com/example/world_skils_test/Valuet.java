package com.example.world_skils_test;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "Valute")
public class Valuet {

    @Element(name = "CharCode")
    private String code;
    @Element(name = "Name")
    private String name;
    @Element(name = "Value")
    private String value;

    @Element(name = "Nominal")
    private String nominal;
    @Element(name = "NumCode")
    private int numcode;

    @Attribute (name = "ID")
    private String id;

    public String getCharCode(){
        return this.code;
    }
    public String getName (){
        return this.name;
    }
    public String getValue (){
        return this.value;
    }
    public String getId(){
        return this.id;
    }

    public void setCharCode (String code){
        this.code = code;
    }
    public void setName (String name){
        this.name = name;
    }
    public void setValue (String value){
        this.value = value;
    }
    public void setId (String id){
        this.id = id;
    }


}
