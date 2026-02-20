package sn.edu.isepat.eboutique.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import sn.edu.isepat.eboutique.entities.Categorie;
import sn.edu.isepat.eboutique.entities.ProduitSeynabouMbengue;
import sn.edu.isepat.eboutique.repository.CategorieRepository;
import sn.edu.isepat.eboutique.repository.ProduitRepository;

@Component
public class InitProduit implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public void run(String... args) {
        if(produitRepository.count() == 0) {
            Categorie cat = categorieRepository.findById(1L).orElse(null);
            if(cat != null) {
                ProduitSeynabouMbengue p1 = new ProduitSeynabouMbengue("Frigo", 350000, 10, cat);
                produitRepository.save(p1);
                System.out.println("Produit initial créé !");
            }
        }
    }
}