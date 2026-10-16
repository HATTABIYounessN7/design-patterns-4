package hattabi.youness.Impl;

import java.util.Arrays;

import hattabi.youness.framework.Filter;

public class InverseFilter implements Filter {
    @Override
    public int[] filter(int[] data) {
        return Arrays.stream(data).map(v -> 255 - v).toArray();
    }
}