package sn.edu.isepat.eboutique.init;  // package en haut

// IMPORTS → TOUJOURS AVANT LA CLASSE
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import sn.edu.isepat.eboutique.entities.Categorie;
import sn.edu.isepat.eboutique.repository.CategorieRepository;

@Component
public class InitCategorie implements CommandLineRunner {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public void run(String... args) throws Exception {
        if(categorieRepository.count() == 0) {
            Categorie cat = new Categorie("ELECTROMENAGER-SMB-SEYNABOU");
            categorieRepository.save(cat);
            System.out.println("Catégorie initiale créée !");
        }
    }
}