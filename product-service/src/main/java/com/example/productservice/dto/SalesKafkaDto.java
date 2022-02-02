package com.example.productservice.dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SalesKafkaDto {
    LinkedList<LinkedList<SalesDto>> data= new LinkedList<>();
    Integer totalPrice=0;
    Integer initialSalesIdx=0;
    Integer lastSalesIdx=0;
    Integer totalQty=0;

    public void setData(LinkedList<SalesDto> salesDtos){
        if(null==salesDtos){
            return;
        }

        for(int i=0; i< salesDtos.size(); i++){
            SalesDto current= salesDtos.get(i);
            this.totalPrice += current.totalPrice;
            this.totalQty += current.quantity;
            setSalesIdx(current);

            if(hasSalesIndex(current)){
                getMatchedList(current).add(current);
            }else{
                this.data.add(new LinkedList<>(){{
                    add(current);
                }});
            }
        }
    }

    public void setSalesIdx(SalesDto salesDto){
        Integer condition=salesDto.salesIdx;

        if(condition>lastSalesIdx){
            lastSalesIdx=condition;
        }else if(condition<initialSalesIdx){
            initialSalesIdx=condition;
        }
    }

    public boolean hasSalesIndex(SalesDto salesDto){
        Integer condition= salesDto.salesIdx;
        for(int i=0; i<this.data.size();i++){
            if(condition.equals(this.data.get(i).get(0).salesIdx)){
                return true;
            }
        }
        return false;
    }

    public LinkedList<SalesDto> getMatchedList(SalesDto salesDto){
        Integer condition = salesDto.salesIdx;

        for(int i=0; i<this.data.size();i++){
            if(condition.equals(this.data.get(i).get(0).salesIdx)){
                return this.data.get(i);
            }
        }
        return null;
    }
}
