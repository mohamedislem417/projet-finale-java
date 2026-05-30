import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Produit p1 = new ProduitElectronique(
                "P01",
                "PC Portable",
                3500,
                2);

        Produit p2 = new ProduitAlimentaire(
                "A01",
                "chocolat",
                3.5,
                "10/10/2026");


        GestionCatalogue catalogue =
                new GestionCatalogue();

        catalogue.ajouterProduit(p1);
        catalogue.ajouterProduit(p2);

        System.out.println(" Catalogue ");
        catalogue.afficherProduits();

        Commande cmd1 =
                new CommandeNormale("C001");

        cmd1.ajouterProduit(p1);
        cmd1.ajouterProduit(p2);

        Commande cmd2 =
                new CommandeExpress("C002");

        cmd2.ajouterProduit(p1);

        System.out.println("\n Totaux ");

        System.out.println(
                cmd1.calculerTotal());

        System.out.println(
                cmd2.calculerTotal());

        cmd1.payer();
        cmd2.payer();

        Queue<Commande> file =
                new LinkedList<>();

        file.add(cmd1);
        file.add(cmd2);

        System.out.println("\n File attente ");

        while (!file.isEmpty()) {

            System.out.println(
                    file.poll());
        }

        System.out.println("\n Tri Prix ");

        catalogue.trierParPrix();
        catalogue.afficherProduits();

        System.out.println("\n Statistiques ");

        catalogue.statistiques();

        System.out.println("\n Recherche ");

        System.out.println(
                catalogue.rechercherProduit("P01"));
    }
}