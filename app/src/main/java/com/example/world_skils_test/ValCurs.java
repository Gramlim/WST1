package com.example.world_skils_test;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;
@Root(name = "ValCurs")
public class ValCurs {
        @ElementList(inline = true)
        public List<Valuet> list;

        @Attribute(name = "Date")
        public String _Date;

        @Attribute(name = "name")
        public String _name;

        public List<Valuet> getList() {
            return this.list;
    }

}
