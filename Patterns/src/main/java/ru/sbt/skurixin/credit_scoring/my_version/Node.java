package ru.sbt.skurixin.credit_scoring.my_version;

/**
 * Created by SBTJavastudent on 06.10.2016.
 */
public class Node implements Composite{
    private Composite operation;
    private Node left,right;


    @Override
    public double getResult(double left, double right) {
        return operation.getResult(left,right);
    }
}
//    city
//      salary
//      periodOfMoonths
//      amountOfCredit
// amount/period >salary