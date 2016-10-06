package ru.sbt.skurixin.credit_scoring.andrew_version;

import java.util.List;
import java.util.Map;

/**
 * Created by SBTJavastudent on 06.10.2016.
 */
public class ParameterNode implements Node {
    private final String keyName;

    public ParameterNode(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public double getResult(Map<String, Double> values) {
        Object value = values.get(keyName);
        if(value instanceof Number){
            return ((Number)value).doubleValue();
        }
        return 0;
    }

    @Override
    public void addNode(Node node) {

    }

    @Override
    public void removeNode(Node node) {

    }

    @Override
    public List<Node> getChildNodes() {
        return null;
    }
}
