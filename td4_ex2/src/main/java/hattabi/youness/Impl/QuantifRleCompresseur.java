package hattabi.youness.impl;

import java.util.Arrays;

public class QuantifRleCompresseur extends RleCompresseur {
    @Override
    protected int[] preparer(int[] data) {
        return Arrays.stream(data).map(v -> v / 64 * 64).toArray();
    }
}