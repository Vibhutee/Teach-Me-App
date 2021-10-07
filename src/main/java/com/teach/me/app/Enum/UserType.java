package com.teach.me.app.Enum;

public enum UserType {
    TUTOR(0), STUDENT(1);

    private int index;
    UserType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
