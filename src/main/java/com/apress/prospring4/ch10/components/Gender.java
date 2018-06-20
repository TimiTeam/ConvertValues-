package com.apress.prospring4.ch10.components;


public enum Gender {
    MAN("M"), FEMANE("F");

    private String code;

    Gender(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
