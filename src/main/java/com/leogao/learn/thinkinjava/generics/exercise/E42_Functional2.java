package com.leogao.learn.thinkinjava.generics.exercise;

import static com.leogao.learn.thinkinjava.net.mindview.util.Print.print;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;;

final class DataManipulator1 implements Comparable<DataManipulator1> {
    private int value;

    public DataManipulator1(int value) {
        this.value = value;
    }

    public void increment() {
        ++value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(DataManipulator1 other) {
        return Integer.valueOf(value).compareTo(other.value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

final class DataManipulator2 {
    private String value;

    public DataManipulator2(String value) {
        setValue(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

interface Combiner<T> {
    T combine(T x, T y);
}

interface UnaryFunction<R, T> {
    R function(T x);
}

interface Collector<T> extends UnaryFunction<T, T> {
    T result(); // Extract result of collecting parameter
}

interface UnaryPredicate<T> {
    boolean test(T x);
}

class Functional2 {
    // Calls the Combiner object on each element to combine
    // it with a running result, which is finally returned:
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if (it.hasNext()) {
            T result = it.next();
            while (it.hasNext())
                result = combiner.combine(result, it.next());
            return result;
        }
        // If seq is the empty list:
        return null; // Or throw exception
    }

    // Take a function object and call it on each object in
    // the list, ignoring the return value. The function
    // object may act as a collecting parameter, so it is
    // returned at the end.
    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq)
            func.function(t);
        return func;
    }

    // Creates a list of results by calling a
    // function object for each object in the list:
    public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> func) {
        List<R> result = new ArrayList<R>();
        for (T t : seq)
            result.add(func.function(t));
        return result;
    }

    // Applies a unary predicate to each item in a sequence,
    // and returns a list of items that produced "true":
    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<T>();
        for (T t : seq)
            if (pred.test(t))
                result.add(t);
        return result;
    }

    // To use the above generic methods, we need to create
    // function objects to adapt to our particular needs:
    static class IntegerAdder implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class IntegerSubtracter implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    static class BigDecimalAdder implements Combiner<BigDecimal> {
        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class BigIntegerAdder implements Combiner<BigInteger> {
        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class AtomicLongAdder implements Combiner<AtomicLong> {
        @Override
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            // Not clear whether this is meaningful:
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    // We can even make a UnaryFunction with an "ulp"
    // (Units in the last place):
    static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal> {
        @Override
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }

    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector implements Collector<Integer> {
        private Integer val = 1;

        @Override
        public Integer function(Integer x) {
            val *= x;
            return val;
        }

        @Override
        public Integer result() {
            return val;
        }
    }
}

public class E42_Functional2 {
    // To use the above generic methods, we need to create
    // function objects to adapt to our particular needs:
    static class Incrementor implements UnaryFunction<DataManipulator1, DataManipulator1> {
        @Override
        public DataManipulator1 function(DataManipulator1 x) {
            x.increment();
            return x;
        }
    }

    static class UpperCaseConverter implements UnaryFunction<String, DataManipulator2> {
        @Override
        public String function(DataManipulator2 x) {
            return x.getValue().toUpperCase();
        }
    }

    static class Concatenator implements Combiner<DataManipulator2> {
        @Override
        public DataManipulator2 combine(DataManipulator2 x, DataManipulator2 y) {
            x.setValue(x.getValue() + y.getValue());
            return x;
        }
    }

    public static void main(String[] args) {
        DataManipulator1 rf = new DataManipulator1(4);
        List<DataManipulator1> ldm1 = Arrays.asList(new DataManipulator1(3), new DataManipulator1(10),
                new DataManipulator1(1), new DataManipulator1(7));
        print(Functional2.transform(Functional2.filter(ldm1, new Functional2.GreaterThan<DataManipulator1>(rf)),
                new Incrementor()));
        List<DataManipulator2> ldm2 = Arrays.asList(new DataManipulator2("a"), new DataManipulator2("B"),
                new DataManipulator2("c"), new DataManipulator2("d"));
        print(Functional2.transform(ldm2, new UpperCaseConverter()));
        print(Functional2.reduce(ldm2, new Concatenator()).getValue());
    }
} /*
   * Output: [11, 8] [A, B, C, D] aBcd
   *///:~
