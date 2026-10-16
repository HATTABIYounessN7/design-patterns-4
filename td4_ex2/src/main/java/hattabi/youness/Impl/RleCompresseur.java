package hattabi.youness.Impl;

import java.util.ArrayList;
import java.util.List;

import hattabi.youness.framework.Compresseur;

public class RleCompresseur extends Compresseur {
    @Override
    protected int[] encoder(int[] data) {
        List<Integer> out = new ArrayList<>();
        int i = 0;
        while (i < data.length) {
            int j = i;
            while (j < data.length && data[j] == data[i]) {
                j++;
            }
            out.add(data[i]);
            out.add(j - i);
            i = j;
        }
        return out.stream().mapToInt(Integer::intValue).toArray();
    }
}
