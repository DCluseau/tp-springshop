package fr.fms.business;

import java.util.Scanner;

public class TPSpringShop {

	public TPSpringShop() {
		// TODO Auto-generated constructor stub
	}
	public void selectOption() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenue dans notre application de gestion d'articles ! Vivement la couche web parce que...");
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
	}
}
