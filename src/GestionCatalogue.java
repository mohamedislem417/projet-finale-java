import java.util.*;

public class GestionCatalogue {

    private List<Produit> catalogue = new ArrayList<>();
    private Set<Produit> produitsUniques = new HashSet<>();
    private Map<String, Produit> indexProduits = new HashMap<>();

    // Ajouter
    public void ajouterProduit(Produit produit) {

        catalogue.add(produit);
        produitsUniques.add(produit);
        indexProduits.put(produit.getReference(), produit);
    }

    // Afficher
    public void afficherProduits() {

        for (Produit p : catalogue) {
            System.out.println(p);
        }
    }

    // Supprimer
    public void supprimerProduit(String reference) {

        catalogue.removeIf(p ->
                p.getReference().equals(reference));

        produitsUniques.removeIf(p ->
                p.getReference().equals(reference));

        indexProduits.remove(reference);
    }

    // Rechercher
    public Produit rechercherProduit(String reference) {

        return indexProduits.get(reference);
    }

    // Trier par prix
    public void trierParPrix() {

        catalogue.sort(Comparator.comparingDouble(
                Produit::getPrix));
    }

    // Trier par nom
    public void trierParNom() {

        catalogue.sort(Comparator.comparing(
                Produit::getNom));
    }

    // Statistiques
    public void statistiques() {

        System.out.println("Nombre produits : "
                + catalogue.size());

        Produit max = Collections.max(
                catalogue,
                Comparator.comparingDouble(
                        Produit::getPrix));

        System.out.println("Produit plus cher : "
                + max);

        double total = 0;

        for (Produit p : catalogue) {
            total += p.getPrix();
        }

        System.out.println("Total ventes : "
                + total);
    }
}