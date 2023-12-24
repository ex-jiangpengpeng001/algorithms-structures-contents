package com.mashibing.component.service;

import com.mashibing.component.entity.ComponentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamComponent extends Component {
    private String name;
    private String id;
    private String type;

    public TeamComponent(ComponentEntity team) {
        this.name = team.getName();
        this.id = team.getId();
        this.type = team.getType();
    }

    @Override
    public Component add(Component c) {
        return null;
    }

    @Override
    public void operation() {

    }

    @Override
    public String toString() {
        return "TeamComponent{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
