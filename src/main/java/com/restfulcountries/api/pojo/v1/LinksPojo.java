package com.restfulcountries.api.pojo.v1;
public class LinksPojo {

    private final String first;
    private final String last;
    private final String prev;
    private final String  next;

    public LinksPojo(String first, String last, String prev, String next) {
        this.first = first;
        this.last = last;
        this.prev = prev;
        this.next = next;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getPrev() {
        return prev;
    }

    public String getNext() {
        return next;
    }

    @Override
    public String toString() {
        return STR."LinksPojo{first='\{first}\{'\''}, last='\{last}\{'\''}, prev='\{prev}\{'\''}, next='\{next}\{'\''}\{'}'}";
    }
}
