package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer,Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        this.denominations = new TreeMap<>();
    }

    public String getCurrencyCode(){
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
       if(denominations.containsKey(denomination)) {
            denominations.put(denomination,denominations.get(denomination)+count);
       }else{
           denominations.put(denomination,count);
       }
    }

    public int getTotalAmount(){
       int result =0;
       for(Integer denomination: denominations.keySet()){
           result+=denomination*denominations.get(denomination);
       }
       return result;
    }
    public boolean hasMoney(){
        return !denominations.isEmpty();
    }
    public boolean isAmountAvailable(int expectedAmount){
        return expectedAmount<=getTotalAmount();
    }
    public Map<Integer,Integer> withdrawAmount(int expectedAmount){
        int sum = expectedAmount;
            Map<Integer,Integer> map = new HashMap<>(denominations);
            return map; //not finished
    }
}
