package com.pivovarit.vavr;


import io.vavr.API;
import io.vavr.Lazy;
import io.vavr.Predicates;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.List;
import static io.vavr.API.Match;
import static io.vavr.API.unchecked;
import static io.vavr.Predicates.instanceOf;

/**
 * @author Grzegorz Piwowarek
 * @email gpiwowarek@gmail.com
 * @twitter/github pivovarit
 */
public class VavrTest {

    @Test
    public void example_1() throws Exception {

        // Function1, Function2... Function8
        // Tuple4, TupleN

        //List.of(1, 2, 3);
        List(1, 2, 3);
    }

    @Test
    public void example_2() throws Exception {
        List<Integer> integers = List.of(Option.of(42), Option.of(54))
          .flatMap(o -> o);

        System.out.println(integers);
    }

    @Test
    public void example_3() throws Exception {
        Try.of(() -> new URI(""))
        //  .recoverWith(URISyntaxException.class, Try.of(() -> {new URI("")}))
          .map(uri -> uri.toString())
          .filter(i -> true)
          .getOrElse("default");
    }

    @Test
    public void example_4() throws Exception {
        Supplier<Integer> sup = () -> {
            System.out.println("computing..");
            return 42;
        };

        sup.get();
        sup.get();
        sup.get();
    }

    @Test
    public void example_5() throws Exception {

        Lazy<Integer> lazy = Lazy.of(() -> {
            System.out.println("computing");
            return 42;
        })
          .map(i -> i +1);

        lazy.get();
        lazy.get();
        lazy.get();
    }

    @Test
    public void example_6() throws Exception {

        List<Integer> l = List.of(1, 2, 3);

        l.drop(1);
        l.tail();

        System.out.println(l);
    }

    @Test
    public void example_7() throws Exception {
        List<Integer> l = List.of(1, 2, 3);

        System.out.println(l.zipWithIndex());
    }

    @Test
    public void example_8() throws Exception {
        List.of(1, 2, 3)
          .collect(Collectors.toList());
    }

    @Test
    public void example_9() throws Exception {
        Stream.iterate(0, i -> i + 1)
          .take(10)
          .forEach(System.out::println);
    }

    @Test
    public void example_10() throws Exception {
        List.of(1, 2)
          .asJava();
    }

    @Test
    public void example_11() throws Exception {
        Tuple2<String, Integer> tuple = Tuple.of("Java", 8);

        String result = tuple.apply((s, integer) -> s + integer);

        System.out.println(result);
    }

    @Test
    public void example_12() throws Exception {
      /*  List.of("")
          .map(unchecked(s -> new URI(s))*/

    }

    @Test
    public void example_13() throws Exception {
        Object a = "42";

        Match(a).of(
          Case($(instanceOf(String.class)), "string"),
          Case($(instanceOf(Integer.class)), "int"));

    }


}
