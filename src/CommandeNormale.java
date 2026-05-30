public class CommandeNormale extends Commande {

    public CommandeNormale(String numeroCommande) {
        super(numeroCommande);
    }

    @Override
    public double calculerTotal() {

        double total = 0;

        for (Produit p : listeProduits) {
            total += p.calculerPrixFinal();
        }

        return total;
    }
}
