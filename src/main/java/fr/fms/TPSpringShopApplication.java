package fr.fms;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import fr.fms.business.TPSpringShop;
import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;

@SpringBootApplication
public class TPSpringShopApplication implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	public static void main(String[] args) {
		SpringApplication.run(TPSpringShopApplication.class, args);
	}
	
	public void selectOption() {
		Scanner scan = new Scanner(System.in);
		Long articleId;
		Article article;
		String brand;
		String description;
		Double price;
		Long categoryId;
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
					/*
					 * Display all articles without paging
					 */
					System.out.println("IDENTIFIANT	DESCRIPTION	MARQUE		PRIX	CATEGORIE");
					for(Article oneArticle : articleRepository.findAll()) {
						System.out.println(oneArticle);
					}
					option = "";
					break;
				case "2":
					/*
					 * Display all articles with paging
					 */
					option = "";
					break;
				case "3":
					/*
					 * Add article
					 */
					option = "";
					System.out.println("Veuillez indiquer la marque :");
					brand = scan.next();
					System.out.println("Veuillez indiquer la description :");
					description = scan.next();
					System.out.println("Veuillez indiquer le prix :");
					price = scan.nextDouble();
					System.out.println("Veuillez indiquer la catégorie :");
					categoryId = scan.nextLong();
					articleRepository.save(new Article(brand, description, price, categoryRepository.findById(categoryId).get()));
					break;
				case "4":
					/*
					 * Display article
					 */
					option = "";
					System.out.println("Veuillez indiquer l'identifiant de l'article à afficher :");
					articleId = scan.nextLong();
					System.out.println("IDENTIFIANT	DESCRIPTION	MARQUE		PRIX	CATEGORIE");
					System.out.println(articleRepository.findById(articleId));
					break;
				case "5":
					/*
					 * Delete article
					 */
					option = "";
					System.out.println("Veuillez indiquer l'identifiant de l'article à supprimer :");
					articleId = scan.nextLong();
					articleRepository.deleteById(articleId);
					break;
				case "6":
					/*
					 * Update article
					 */
					option = "";
					System.out.println("Veuillez indiquer l'identifiant de l'article à modifier :");
					articleId = scan.nextLong();
					article = articleRepository.findById(articleId).get();
					System.out.println("Données actuelles : ");
					System.out.println("IDENTIFIANT	DESCRIPTION	MARQUE		PRIX	CATEGORIE");
					System.out.println(article);
					System.out.println("Veuillez indiquer la marque :");
					brand = scan.next();
					System.out.println("Veuillez indiquer la description :");
					description = scan.next();
					System.out.println("Veuillez indiquer le prix :");
					price = scan.nextDouble();
					System.out.println("Veuillez indiquer la catégorie :");
					categoryId = scan.nextLong();
					articleRepository.save(new Article(brand, description, price, categoryRepository.findById(categoryId).get()));
					break;
				case "7":
					/*
					 * Add category
					 */
					option = "";
					System.out.println("Veuillez indiquer le nom de la catégorie à ajouter :");
					break;
				case "8":
					/*
					 * Display category
					 */
					option = "";
					System.out.println("Veuillez indiquer l'identifiant de la catégorie à afficher :");
					break;
				case "9":
					/*
					 * Delete category
					 */
					option = "";
					System.out.println("Veuillez indiquer l'identifiant de la catégorie à supprimer :");
					break;
				case "10":
					/*
					 * Update category
					 */
					option = "";
					System.out.println("Veuillez indiquer l'identifiant de la catégorie à modifier :");
					break;
				case "11":
					/*
					 * Display all articles of one category
					 */
					option = "";
					System.out.println("Veuillez indiquer l'identifiant de la catégorie pour afficher ses articles :");
					break;
				case "12":
					System.out.println("Au revoir.");
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
	public void run(String...args) throws Exception{
		/*
		 * Create categories and articles
		 */
//		Category smartphone = categoryRepository.save(new Category("Smartphone"));
//		Category tablet = categoryRepository.save(new Category("Tablet"));
//		Category pc = categoryRepository.save(new Category("PC"));
//		
//		articleRepository.save(new Article("Samsung", "S10", 500, smartphone));
//		articleRepository.save(new Article("Samsung", "S9", 350, smartphone));
//		articleRepository.save(new Article("Xiaomi", "MI10", 100, smartphone));
//		
//		articleRepository.save(new Article("Samsung", "GalaxyTab", 450, tablet));
//		articleRepository.save(new Article("Apple", "Ipad", 450, tablet));
//		
//		articleRepository.save(new Article("Asus", "R510", 600, pc));
		
		this.selectOption();
	}
}
