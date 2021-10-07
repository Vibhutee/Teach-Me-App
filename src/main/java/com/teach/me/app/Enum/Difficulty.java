package com.teach.me.app.Enum;

public enum Difficulty {
    EASY(0), MEDIUM(1), HARD(2);

    private int index;

    Difficulty(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
