package com.example.world_skils_test;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "Valute")
public class Valuet {

    @Element(name = "CharCode")
    private String charcode;
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
        return this.charcode;
    }
    public String getName (){
        return this.name;
    }
    public String getValue (){
        return this.value;
    }
}
