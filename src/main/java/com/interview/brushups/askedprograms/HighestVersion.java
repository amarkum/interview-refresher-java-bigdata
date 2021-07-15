package com.interview.brushups.askedprograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Interview Company - Falabella
 * Find Latest version of each Entity
 * <p>
 * Expected Output
 * customers-10.2.3
 * products-2.8.1
 * stores-2.7.10
 */

public class HighestVersion {
    public static void main(String[] args) {

        List<String> entityDetails = new ArrayList<>();
        entityDetails.add("customers-1.0.23");
        entityDetails.add("products-2.8.1");
        entityDetails.add("products-2.7.2");
        entityDetails.add("customers-10.2.3");
        entityDetails.add("stores-2.7.1");
        entityDetails.add("stores-2.7.10");

        Map<String, String> latestEntityMap = new HashMap<>();
        for (String entity : entityDetails) {
            String[] entityVersionKV = entity.split("-");
            if (!latestEntityMap.containsKey(entityVersionKV[0])) {
                latestEntityMap.put(entityVersionKV[0], entityVersionKV[1]);
            } else {
                String storedVersion = latestEntityMap.get(entityVersionKV[0]);
                String currentVersion = latestEntityMap.get(entityVersionKV[1]);

                boolean isVersionHigher = versionComparison(storedVersion, currentVersion);
                if (isVersionHigher) {
                    latestEntityMap.put(entityVersionKV[0], entityVersionKV[1]);
                }
            }
        }

        for (Map.Entry entry : latestEntityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static boolean versionComparison(String stored, String current) {
        boolean isVersionHigher = false;
        String storedVersionSub[] = stored.split(".");
        String currentVersionSub[] = current.split(".");

        for (int i = 0; i < storedVersionSub.length; i++) {
            if (Integer.parseInt(currentVersionSub[i]) > Integer.parseInt(storedVersionSub[i])) {
                isVersionHigher = true;
            }
        }
        return isVersionHigher;
    }
}
