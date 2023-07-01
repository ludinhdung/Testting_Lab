package org.example;

public class Main {
    public static void main(String[] args) {
        ReadExcel readExcel = new ReadExcel();
        readExcel.readFile();

        for (int i = 0; i < 10000; i++) {
            for (int i1 = 0; i1 < 10000; i1++) {
                System.out.println("Result: ");

                SumCalculate sumCalculate = new SumCalculate();
                sumCalculate.sum(readExcel.getColumn1Data(), readExcel.getColumn2Data()).forEach(System.out::println);

                System.out.println();
            }
        }

    }
}