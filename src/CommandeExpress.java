public class CommandeExpress extends Commande {

    private final double fraisLivraison = 20;

    public CommandeExpress(String numeroCommande) {
        super(numeroCommande);
    }

    @Override
    public double calculerTotal() {

        double total = 0;

        for (Produit p : listeProduits) {
            total += p.calculerPrixFinal();
        }

        return total + fraisLivraison;
    }
}
