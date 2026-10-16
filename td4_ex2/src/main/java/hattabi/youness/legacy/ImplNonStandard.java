package hattabi.youness.legacy;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class ImplNonStandard {

    public int[] appliquerFiltre(String filterName, int[] data) throws IllegalArgumentException {
        IntUnaryOperator op = switch (filterName) {
            case "inverse" -> v -> 255 - v;
            case "moitie" -> v -> v / 2;
            default -> throw new IllegalArgumentException("Filtre inconnu : " + filterName);
        };
        return Arrays.stream(data).map(op).toArray();
    }
}
