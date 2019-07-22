package nearestNeighbors.serial;

import nearestNeighbors.data.Distance;
import nearestNeighbors.data.Sample;
import nearestNeighbors.distances.EuclideanDistanceCalculator;

import java.util.*;

/**
 * Create by 163 on 2019/7/22
 */
public class KnnClassifier {
    private final List<? extends Sample> dataSet;
    private int k;

    public KnnClassifier(List<? extends Sample> dataSet, int k) {
        this.dataSet = dataSet;
        this.k = k;
    }

    public String classify(Sample example) {
        Distance[] distances = new Distance[dataSet.size()];
        int index = 0;
        for (Sample localSample : dataSet) {
            distances[index] = new Distance();
            distances[index].setIndex(index);
            distances[index].setDistance(EuclideanDistanceCalculator.calculate(localSample, example));
            index++;
        }
        Arrays.sort(distances);
        Map<String,Integer> results = new HashMap<String, Integer>();
        for (int i = 0; i < k; i++) {
            Sample sample = dataSet.get(distances[i].getIndex());
            String tag = sample.getTag();
            results.merge(tag, 1, (a, b) -> a + b);
        }
        return Collections.max(results.entrySet(), Map.Entry.comparingByValue()).getKey();
    }



}
