package org.example;

import java.util.ArrayList;
import java.util.List;

public class SumCalculate {
    public SumCalculate() {
    }

    public List<Object> sum(List<Object> dataColumn1, List<Object> dataColumn2) {
        String PERFORMANCE_MESSAGE = "Out of memory";
        int maxValue = Integer.MAX_VALUE;
        String INVALID_MESSAGE = "Invalid number";

        List<Object> resultList = new ArrayList<>();

        for (int i = 0; i < dataColumn1.size(); i++) {
            try {
                if (dataColumn1.get(i).toString().length() > String.valueOf(maxValue).length() || dataColumn2.get(i).toString().length() > String.valueOf(maxValue).length()) {

                    resultList.add(PERFORMANCE_MESSAGE);
                } else {

                    int sum = Integer.parseInt(dataColumn1.get(i).toString()) + Integer.parseInt(dataColumn2.get(i).toString());

                    resultList.add(sum);

                }
            } catch (NumberFormatException ex) {

                resultList.add(INVALID_MESSAGE);
            }
        }
        return resultList;
    }
}
