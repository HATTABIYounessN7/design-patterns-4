package hattabi.youness.legacy;

import hattabi.youness.framework.Filter;

public class FilterAdapter implements Filter {
    private final ImplNonStandard legacy;
    private final String filterName;

    public FilterAdapter(ImplNonStandard legacy, String filterName) {
        this.legacy = legacy;
        this.filterName = filterName;
    }

    @Override
    public int[] filter(int[] data) throws IllegalArgumentException {
        return legacy.appliquerFiltre(filterName, data);
    }
}
