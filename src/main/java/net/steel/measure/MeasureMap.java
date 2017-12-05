package net.steel.measure;

import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.github.jamm.MemoryMeter;

import java.util.HashMap;
import java.util.Map;

public class MeasureMap {

    public static void main(String... args) {
        MemoryMeter meter = new MemoryMeter();
        Map<Integer, Integer> hashMap = new HashMap(100);
        Map<Integer, Integer> unifiedMap = new UnifiedMap(100);
        for (int i = 0; i < 100; i++) {
            hashMap.put(i, i+500);
            unifiedMap.put(i, i+500);
        }

        for (int i = 0; i < 100; i++) {
            hashMap.remove(i);
            unifiedMap.remove(i);
        }
        long measureHashMap = meter.measure(hashMap);
        long measureDeepHashMap = meter.measureDeep(hashMap);

        long measureUnifiedMap = meter.measure(unifiedMap);
        long measureDeepUnifiedMap = meter.measureDeep(unifiedMap);

        System.out.println("HashMap_norm: " + measureHashMap);
        System.out.println("HashMap_deep: " + measureDeepHashMap);

        System.out.println("UnifiedMap_norm: " + measureUnifiedMap);
        System.out.println("UnifiedMap_deep: " + measureDeepUnifiedMap);

        System.out.println("sdfasf");
    }
}
