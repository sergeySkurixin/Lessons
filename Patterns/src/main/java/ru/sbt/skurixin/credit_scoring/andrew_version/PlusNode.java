package ru.sbt.skurixin.credit_scoring.andrew_version;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SBTJavastudent on 06.10.2016.
 */
public class PlusNode implements Node {
    private List<Node> childNodes = new ArrayList<>();

    @Override
    public double getResult(Map<String, Double> values) {
        List<Node> nodes = getChildNodes();
        double result = 0;
        for (Node node : nodes) {
            result += result + node.getResult(values);
        }
        return result;
    }

    @Override
    public void addNode(Node node) {
        childNodes.add(node);
    }

    @Override
    public void removeNode(Node node) {
        childNodes.remove(node);
    }

    @Override
    public List<Node> getChildNodes() {
        return childNodes;
    }
}
