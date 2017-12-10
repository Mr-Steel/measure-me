package net.steel.measure.memory;

import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteObjectHashMap;
import org.github.jamm.MemoryMeter;

import java.util.HashMap;
import java.util.Map;

public class MeasureMap {

    private static int initialCapacity = 16;
    private static int targetCapacity = 128;

    private static int multi = 1;

    public static void main(String... args) {
        MemoryMeter meter = new MemoryMeter();
        Map<Integer, Integer> hashMap = new HashMap(initialCapacity);
        Map<Integer, Integer> unifiedMap = new UnifiedMap(initialCapacity);
        Map<Byte, Integer> hashMapByte = new HashMap<>(initialCapacity);
        Map<Byte, Integer> unifiedMapByte = new UnifiedMap(initialCapacity);
        ByteObjectHashMap<Integer> byteObjectHashMap = new ByteObjectHashMap(initialCapacity);
        for (int i = 0; i < targetCapacity; i++) {
            hashMap.put(i*multi, i+500);
            unifiedMap.put(i*multi, i+500);
            hashMapByte.put((byte)i, i+500);
            unifiedMapByte.put((byte) i, i+500);
            byteObjectHashMap.put((byte) i, i+500);
        }

        for (int i = 0; i < targetCapacity; i++) {
            hashMap.remove(i);
            unifiedMap.remove(i);
            hashMapByte.remove((byte)i);
            unifiedMapByte.remove((byte)i);
            byteObjectHashMap.remove((byte)i);
        }


        long measureHashMap = meter.measure(hashMap);
        long measureDeepHashMap = meter.measureDeep(hashMap);

        long measureUnifiedMap = meter.measure(unifiedMap);
        long measureDeepUnifiedMap = meter.measureDeep(unifiedMap);

        long measureHashMapByte = meter.measure(hashMapByte);
        long measureDeepHashMapByte = meter.measureDeep(hashMapByte);

        long measureUnifiedMapByte = meter.measure(unifiedMapByte);
        long measureDeepUnifiedMapByte = meter.measureDeep(unifiedMapByte);

        long measureByteObjectHashmap = meter.measure(byteObjectHashMap);
        long measureDeepByteObjectHashmap = meter.measureDeep(byteObjectHashMap);

        System.out.println("HashMap_norm: " + measureHashMap);
        System.out.println("HashMap_deep: " + measureDeepHashMap);

        System.out.println("Unified_norm: " + measureUnifiedMap);
        System.out.println("Unified_deep: " + measureDeepUnifiedMap);

        System.out.println("HashMap_Byte_norm: " + measureHashMapByte);
        System.out.println("HashMap_Byte_deep: " + measureDeepHashMapByte);

        System.out.println("Unified_Byte_norm: " + measureUnifiedMapByte);
        System.out.println("Unified_Byte_deep: " + measureDeepUnifiedMapByte);

        System.out.println("ByteObjectHashMap_norm: " + measureByteObjectHashmap);
        System.out.println("ByteObjectHashMap_deep: " + measureDeepByteObjectHashmap);
    }
}
