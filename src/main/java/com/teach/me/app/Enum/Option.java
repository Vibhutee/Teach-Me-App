package com.teach.me.app.Enum;

public enum Option {

    OPTION_1(1), OPTION_2(2), OPTION_3(3), OPTION_4(4), NONE(5);

    private int index;

    Option(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
