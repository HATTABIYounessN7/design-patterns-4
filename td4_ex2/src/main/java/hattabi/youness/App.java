package hattabi.youness;

import java.util.Arrays;
import java.util.Scanner;

import hattabi.youness.framework.Compresseur;
import hattabi.youness.framework.Filter;
import hattabi.youness.framework.ImageFramework;
import hattabi.youness.legacy.FilterAdapter;
import hattabi.youness.legacy.ImplNonStandard;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ImageFramework framework = new ImageFramework();
        int[] image = { 10, 10, 10, 200, 200, 50, 50, 50, 50, 255 };
        System.out.println("Image : " + Arrays.toString(image));

        while (true) {
            System.out.println("Classe du filtre (exit pour quitter) : ");
            String filterClass = scanner.nextLine().trim();
            if (filterClass.equals("exit")) {
                break;
            }
            System.out.println("Classe de compression : ");
            String compressClass = scanner.nextLine().trim();

            try {
                Object filter = Class.forName(filterClass).getConstructor().newInstance();
                if (filter instanceof ImplNonStandard legacy) {
                    System.out.println("Nom du filtre (ancienne API) : ");
                    filter = new FilterAdapter(legacy, scanner.nextLine().trim());
                }
                framework.setFilter((Filter) filter);
                framework.setCompresseur(
                        (Compresseur) Class.forName(compressClass).getConstructor().newInstance());

                int[] filtered = framework.filter(image);
                System.out.println("Image filtrée    : " + Arrays.toString(filtered));
                System.out.println("Image compressée : " + Arrays.toString(framework.compresser(filtered)));
            } catch (ReflectiveOperationException | ClassCastException | IllegalArgumentException e) {
                System.out.println("Erreur : " + e);
            }
        }
    }
}
