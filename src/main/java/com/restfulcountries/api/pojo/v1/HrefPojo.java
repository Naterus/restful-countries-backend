package com.restfulcountries.api.pojo.v1;

public class HrefPojo {
    private final String self;
    private final String states;
    private final String presidents;
    private final String flag;

    public HrefPojo(String self, String states, String presidents, String flag) {
        this.self = self;
        this.states = states;
        this.presidents = presidents;
        this.flag = flag;
    }

    public String getSelf() {
        return self;
    }

    public String getStates() {
        return states;
    }

    public String getPresidents() {
        return presidents;
    }

    public String getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return STR."HrefPojo{self='\{self}\{'\''}, states='\{states}\{'\''}, presidents='\{presidents}\{'\''}, flag='\{flag}\{'\''}\{'}'}";
    }
}
