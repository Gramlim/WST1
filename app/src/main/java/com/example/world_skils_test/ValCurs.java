package com.example.world_skils_test;

import androidx.annotation.AttrRes;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;
@Root(name = "ValCurs")
public class ValCurs {
        @ElementList(inline = true)
        public List<Valuet> list;

        @Attribute(name = "Data")
        public String data;

        @Attribute(name = "name")
        public String name;

        public List<Valuet> getList() {
            return this.list;
    }

}
