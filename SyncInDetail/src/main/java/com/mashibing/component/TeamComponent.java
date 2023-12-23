package com.mashibing.component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamComponent extends Component {
    private String name;
    private String id;
    private String level;

    @Override
    public Component add(Component c) {
        return null;
    }

    @Override
    public void operation() {

    }
}
