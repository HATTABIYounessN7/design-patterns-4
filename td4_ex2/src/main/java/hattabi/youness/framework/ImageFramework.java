package hattabi.youness.framework;

public class ImageFramework {
    private Filter filter;
    private Compresseur compresseur;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public void setCompresseur(Compresseur compresseur) {
        this.compresseur = compresseur;
    }

    public int[] filter(int[] data) {
        return filter.filter(data);
    }

    public int[] compresser(int[] data) {
        return compresseur.compresser(data);
    }
}
