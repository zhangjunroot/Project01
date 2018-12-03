package com.chazhangxinyuan.jdk8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author zhangjun
 * @create 2018/11/20/21:04
 */
public class CreateStream {

    public static void main(String[] args) {
        Stream<String> streamByCollection = createStreamByCollection();
        Stream<String> streamByOf = createStreamByOf();
        Stream<String> streamByArrays = createStreamByArrays();
        streamByCollection.forEach(System.out::println);
        Stream<String> streamByFile = createStreamByFile();
        Stream<Integer> streamByIterator = createStreamByIterate();
        Stream<Double> streamByGenerate = createStreamByGenerate();
        Stream<Obj> streamByGenerateObj = createStreamByGenerateObj();
        System.out.println("+++++++++++++++++++++++++++++++++");
        streamByOf.forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++");
        streamByArrays.forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++");
        streamByFile.forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++");
        streamByIterator.forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++");
        streamByGenerate.forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++");
        streamByGenerateObj.forEach(System.out::println);
    }

    private static Stream<String> createStreamByCollection(){
        return Arrays.asList("12","34","56","78","90","11","21").stream();
    }

    private static Stream<String> createStreamByOf(){
        return Stream.of("12","34","56","78","90","11","21");
    }

    private static Stream<String> createStreamByArrays(){
        Stream<String> stream = Arrays.stream(new String[]{"12", "34", "56", "78", "90", "11", "21"});
        return stream;
    }

    private static Stream<String> createStreamByFile(){
        Path path = Paths.get("C:\\project\\Project01\\jdk8Study\\src\\com\\chazhangxinyuan\\jdk8\\Apple.java");
        try {
            Stream<String> lines = Files.lines(path);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static class ObjSupplier implements Supplier<Obj> {

        Random random =new Random(System.currentTimeMillis());
        @Override
        public Obj get() {
            //获取100以内的整数
            int i = random.nextInt(100);
            return new Obj(i,"name"+i);
        }
    }

    static class Obj{
        private int id;
        private String name;

        public Obj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static Stream<Integer> createStreamByIterate(){

        Stream<Integer> iterate = Stream.iterate(0,n->n+2).limit(10);
        return iterate;
    }
    private static Stream<Double> createStreamByGenerate(){

        Stream<Double> iterate = Stream.generate(Math::random).limit(10);
        return iterate;
    }

    private static Stream<Obj> createStreamByGenerateObj(){

        Stream<Obj> iterate = Stream.generate(new ObjSupplier()).limit(10);
        return iterate;
    }


}
