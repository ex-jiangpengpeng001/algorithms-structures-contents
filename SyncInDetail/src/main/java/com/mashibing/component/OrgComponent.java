package com.mashibing.component;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class OrgComponent extends Component {
    private String name;
    private String id;
    private String level;

    private ArrayList<Component> list = new ArrayList<>();

    @Override
    public Component add(Component org) {
        list.add(org);
        return this;
    }

    @Override
    public void operation() {

    }

}
