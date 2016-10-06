package ru.sbt.skurixin.credit_scoring.andrew_version;

import java.util.List;
import java.util.Map;

/**
 * Created by SBTJavastudent on 06.10.2016.
 */
public interface Node {
    double getResult(Map<String, Double> values);
    void addNode(Node node);
    void removeNode(Node node);
    List<Node> getChildNodes();
}
