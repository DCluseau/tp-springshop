package fr.fms.business;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;

public class TPSpringShop implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public TPSpringShop() {}
	
	public void selectOption() {
		Scanner scan = new Scanner(System.in);
		String option = "";
		System.out.println("Bienvenue dans notre application de gestion d'articles ! Vivement la couche web parce que...");
		while(option == "") {
			System.out.println("1: Afficher tous les articles sans pagination");
			System.out.println("2: Afficher tous les articles avec pagination");
			System.out.println("*********************************************");
			System.out.println("3: Ajouter un article");
			System.out.println("4: Afficher un article");
			System.out.println("5: Supprimer un article");
			System.out.println("6: Modifier un article");
			System.out.println("*********************************************");
			System.out.println("7: Ajouter une catégorie");
			System.out.println("8: Afficher une catégorie");
			System.out.println("9: Supprimer une catégorie");
			System.out.println("10: Mettre à jour une catégorie");
			System.out.println("11: Afficher tous les articles d'une catégorie");
			System.out.println("*********************************************");
			System.out.println("12: Sortir du programme");
			option = scan.next();
			switch(option) {
				case "1":
					for(Article article : articleRepository.findAll()) {
						System.out.println(article);
					}
					option = "";
					break;
				case "2":
					option = "";
					break;
				case "3":
					option = "";
					break;
				case "4":
					option = "";
					break;
				case "5":
					option = "";
					break;
				case "6":
					option = "";
					break;
				case "7":
					option = "";
					break;
				case "8":
					option = "";
					break;
				case "9":
					option = "";
					break;
				case "10":
					option = "";
					break;
				case "11":
					option = "";
					break;
				case "12":
					break;
				default :
					option = "";
			}
		}
		scan.close();
	}
	public void selectNavigation() {
		System.out.println("EXIT    pour sortir de la pagination");
		System.out.println("PREV    pour sortir de la pagination");
		System.out.println("NEXT    pour sortir de la pagination");
		System.out.println("PAGE puis 7 pour afficher 7 articles par pages (5 par défaut)");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
