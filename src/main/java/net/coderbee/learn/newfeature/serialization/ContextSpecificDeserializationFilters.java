package net.coderbee.learn.newfeature.serialization;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class ContextSpecificDeserializationFilters {

    public static void main(String[] args) throws IOException {
        DeserializationObject object = new DeserializationObject();
        object.setAge(35);
        object.setName("coderbee");
        object.setList(Arrays.asList("123", "456"));
        object.setMap(Map.of("address", "SZ"));

        byte[] bytes = convertObjectToStream(object);
        InputStream is = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(is);

        // Setting a Custom Filter Using a Pattern
        // 需要完整的包路径
        // 输入流的最大字节数： maxbytes=1024
        // 该包下的类允许： net.coderbee.learn.newfeature.serialization.*
        // 该模块下的所有类都允许，语法与上面的不一样： java.base/*
        // 拒绝其他的类： !*
        ObjectInputFilter filterByPath =
                ObjectInputFilter.Config.createFilter(
                        "maxbytes=1024;net.coderbee.learn.newfeature.serialization.*;java.base/*;!*");

        // 类型的过滤器
        ObjectInputFilter filterByType = ObjectInputFilter.rejectFilter(
                RejectSerializationInterface.class::isAssignableFrom,
                ObjectInputFilter.Status.UNDECIDED);

        // 多个过滤器组合
        ObjectInputFilter mergedFilter = ObjectInputFilter.merge(filterByType, filterByPath);

        ois.setObjectInputFilter(mergedFilter);
        try {
            Object obj = ois.readObject();
            System.out.println("Read obj: " + obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static byte[] convertObjectToStream(Object obj) {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(obj);
            return boas.toByteArray();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        throw new RuntimeException();
    }

}
