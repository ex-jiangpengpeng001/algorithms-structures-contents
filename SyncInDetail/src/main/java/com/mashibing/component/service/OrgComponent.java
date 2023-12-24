package com.mashibing.component.service;

import com.mashibing.component.entity.ComponentEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class OrgComponent extends Component {
    private String name;
    private String id;
    private String type;

    private ArrayList<Component> list = new ArrayList<>();

    public OrgComponent(ComponentEntity org) {
        this.name = org.getName();
        this.id = org.getId();
        this.type = org.getType();
    }

    @Override
    public Component add(Component org) {
        list.add(org);
        return this;
    }

    @Override
    public void operation() {

    }

    @Override
    public String toString() {
        return "OrgComponent{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", list=" + list +
                '}';
    }
}
