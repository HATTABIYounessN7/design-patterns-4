package hattabi.youness.impl;

import java.util.Arrays;

import hattabi.youness.framework.Filter;

public class SeuilFilter implements Filter {
    @Override
    public int[] filter(int[] data) {
        return Arrays.stream(data).map(v -> v >= 128 ? 255 : 0).toArray();
    }
}
