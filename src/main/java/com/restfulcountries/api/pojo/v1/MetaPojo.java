package com.restfulcountries.api.pojo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaPojo {
    @JsonProperty("current_page")
    private final Integer currentPage;
    private final Integer from;
    @JsonProperty("last_page")
    private final Integer lastPage;
    private final String  path;
    @JsonProperty("per_page")
    private final Integer perPage;
    private final Integer to;

    private final Integer total;

    public MetaPojo(Integer currentPage, Integer from, Integer lastPage, String path, Integer perPage, Integer to, Integer total) {
        this.currentPage = currentPage;
        this.from = from;
        this.lastPage = lastPage;
        this.path = path;
        this.perPage = perPage;
        this.to = to;
        this.total = total;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public String getPath() {
        return path;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getTo() {
        return to;
    }

    public Integer getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return STR."MetaPojo{currentPage=\{currentPage}, from=\{from}, lastPage=\{lastPage}, path='\{path}\{'\''}, perPage=\{perPage}, to=\{to}, total=\{total}\{'}'}";
    }
}
