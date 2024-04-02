package com.restfulcountries.api.pojo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Covid19Pojo {
    @JsonProperty("total_case")
    private final String totalCase;

    @JsonProperty("total_deaths")
    private final String totalDeaths;

    @JsonProperty("last_updated")
    private final String lastUpdated;

    public Covid19Pojo(String totalCase, String totalDeaths, String lastUpdated) {
        this.totalCase = totalCase;
        this.totalDeaths = totalDeaths;
        this.lastUpdated = lastUpdated;
    }

    public String getTotalCase() {
        return totalCase;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return STR."Covid19{totalCase='\{totalCase}\{'\''}, totalDeaths='\{totalDeaths}\{'\''}, lastUpdated='\{lastUpdated}\{'\''}\{'}'}";
    }
}
