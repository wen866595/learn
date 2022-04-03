package net.coderbee.learn.newfeature.serialization;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class DeserializationObject implements Serializable {
    private String name;
    private int age;
    private List<String> list;
    private Map<String, String> map;
}
