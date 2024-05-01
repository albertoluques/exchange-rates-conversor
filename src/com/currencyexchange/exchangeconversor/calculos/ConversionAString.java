package com.currencyexchange.exchangeconversor.calculos;

public class ConversionAString {

    private String divisaBase;
    private String divisaTarget;

    public void ConversionIntAString(int i) {
        switch (i) {
            case 1:
            this.divisaBase = "ARG";
            break;
            case 2:
                this.divisaBase = "BOB";
                break;
            case 3:
                this.divisaBase = "BRL";
                break;
            case 4:
                this.divisaBase = "CLP";
                break;
            case 5:
                this.divisaBase = "COP";
                break;
            case 6:
                this.divisaBase = "USD";
                break;
            case 7:
                this.divisaBase = "MXN";
                break;
        }
        switch (i) {
            case 1:
                this.divisaTarget = "ARG";
                break;
            case 2:
                this.divisaTarget = "BOB";
                break;
            case 3:
                this.divisaTarget = "BRL";
                break;
            case 4:
                this.divisaTarget = "CLP";
                break;
            case 5:
                this.divisaTarget = "COP";
                break;
            case 6:
                this.divisaTarget = "USD";
                break;
            case 7:
                this.divisaTarget = "MXN";
                break;
        }
    }

    public String divisaBase() {
        return this.divisaBase;
    }
    public String divisaTarget() {
        return  this.divisaTarget;
    }

}
