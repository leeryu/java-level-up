package com.leeeryu.url;

public class Result {
    private String srcLangType;
    private String tarLangType;
    private String translatedText;
    private String engineType;
    private String pivot;

    public String getSrcLangType() {
        return srcLangType;
    }

    public void setSrcLangType(String srcLangType) {
        this.srcLangType = srcLangType;
    }

    public String getTarLangType() {
        return tarLangType;
    }

    public void setTarLangType(String tarLangType) {
        this.tarLangType = tarLangType;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getPivot() {
        return pivot;
    }

    public void setPivot(String pivot) {
        this.pivot = pivot;
    }

    @Override
    public String toString() {
        return "Result{" +
                "srcLangType='" + srcLangType + '\'' +
                ", tarLangType='" + tarLangType + '\'' +
                ", translatedText='" + translatedText + '\'' +
                ", engineType='" + engineType + '\'' +
                ", pivot='" + pivot + '\'' +
                '}';
    }
}
