import java.util.ArrayList;
import java.util.List;

public abstract class Commande implements Payable {

    protected String numeroCommande;
    protected List<Produit> listeProduits;

    public Commande(String numeroCommande) {
        this.numeroCommande = numeroCommande;
        this.listeProduits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        listeProduits.add(produit);
    }

    public abstract double calculerTotal();

    @Override
    public void payer() {
        System.out.println("Commande " + numeroCommande +
                " payée avec succès.");
    }

    @Override
    public String toString() {
        return "Commande : " + numeroCommande +
                ", Total : " + calculerTotal();
    }
}