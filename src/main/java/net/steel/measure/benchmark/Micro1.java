package net.steel.measure.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Micro1 {

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(1)
    @Warmup(iterations = 10)
    @Measurement(iterations = 30)
    @BenchmarkMode(Mode.AverageTime)
    public Map<Integer, Integer> test1() {
        Map<Integer, Integer> map = new HashMap<>(100);
        for (int i = 0; i < 1000000; i++) {
            map.put(i*i, i*i*i+500);

        }
        return map;
    }

}
