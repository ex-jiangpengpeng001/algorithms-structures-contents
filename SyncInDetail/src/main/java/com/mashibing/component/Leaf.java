package com.mashibing.component;

public class Leaf extends Component {
    @Override
    public void add(Component c) {

    }

    @Override
    public void remove(Component c) {

    }

    @Override
    public Component getChild(int i) {
        return new Leaf();
    }

    @Override
    public void operation() {

    }
}
