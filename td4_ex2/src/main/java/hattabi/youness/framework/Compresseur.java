package hattabi.youness.framework;

public abstract class Compresseur {
    public final int[] compresser(int[] data) {
        return encoder(preparer(data));
    }

    protected int[] preparer(int[] data) {
        return data;
    }

    protected abstract int[] encoder(int[] data);
}
