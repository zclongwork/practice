package com.zcl.visitor;

public class Fox implements Animal {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
