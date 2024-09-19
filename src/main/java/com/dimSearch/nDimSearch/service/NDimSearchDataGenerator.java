package com.dimSearch.nDimSearch.service;

import com.dimSearch.nDimSearch.data.DataHolder;
import com.dimSearch.nDimSearch.data.POJO.DataGenInput;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class NDimSearchDataGenerator {
    public ResponseEntity<String> generateTestData(DataGenInput requestBody){
        try{
            Random r = new Random();
            List<DataHolder> dataList = Arrays.asList(new DataHolder[requestBody.getLength()]);
            for(int i = 0; i < dataList.size(); i++){
                int newId = r.nextInt(requestBody.getUpperBound()- requestBody.getLowerBound()) + requestBody.getLowerBound();
                DataHolder newData = new DataHolder("name".concat(String.valueOf(newId)), newId);
                dataList.set(i, newData);
            }
            return new ResponseEntity<>(new Gson().toJson(dataList), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Error occurred during test data generation.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
