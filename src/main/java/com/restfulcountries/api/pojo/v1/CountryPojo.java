package com.restfulcountries.api.pojo.v1;

import com.restfulcountries.api.entities.v1.Country;

import java.util.List;

public class CountryPojo {
    private final List<Country> data;
    private final LinksPojo links;
    private final MetaPojo meta;

    public CountryPojo(List<Country> data, LinksPojo links, MetaPojo meta) {
        this.data = data;
        this.links = links;
        this.meta = meta;
    }

    public List<Country> getData() {
        return data;
    }

    public LinksPojo getLinks() {
        return links;
    }

    public MetaPojo getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return STR."CountryPojo{data=\{data}, links=\{links}, meta=\{meta}\{'}'}";
    }
}
