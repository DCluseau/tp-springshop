package fr.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Category;
import fr.fms.entities.Article;

@ExtendWith(MockitoExtension.class)
class ApplicationTests {
	// Pour faire des tests unitaires, il faut forcément utiliser les mocks

	@Mock
	private ArticleRepository articleRepository;

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private TPSpringShopApplication app;

	@Test
	@DisplayName("adminAddCategory - création d'une catégorie si le nom est valide")
	public void adminAddCategory_ShouldCreateCategory_WhenNameIsProvided() {

		String simulateKeyboardInput = "Gaming\n";
		System.setIn(new ByteArrayInputStream(simulateKeyboardInput.getBytes()));

		// On instancie le scanner qui va lire notre faux clavier virtuel
		Scanner mockScanner = new Scanner(System.in);

		// simulateKeyboardInput = "Gaming\n";
		// System.setIn(new ByteArrayInputStream(simulateKeyboardInput.getBytes()));

		app.addCategory(mockScanner);

		// assert
		verify(categoryRepository, times(1)).save(argThat(category -> category.getName().equals("Gaming")));
	}

	@Test
	void contextLoads() {
		assertFalse(1 == 2);
	}

	// @Test
	// void testAddArticle() {
	// // GIVEN
	// Category anonymous = categoryRepository.save(new Category("anonymous"));
	// articleRepository.save(new Article("incognito", "incognito 007", 375,
	// anonymous));

	// // WHEN
	// Article article = articleRepository.findByBrandContains("incognito").get(0);

	// // THEN
	// assertEquals("incognito 007", article.getDescription());
	// }

	// @Test
	// void shouldFindOneArticle() {
	// Iterable<Article> articles = articleRepository.findAll();
	// assertThat(articles).isNotEmpty();
	// }

	@Test
	@DisplayName("searchArticles - Doit retourner les résultats trouvés")
	public void searchArticles_ShouldReturnList_WhenBrandMatch() {

		// Mocking du résultat de la recherche dans mockArticles
		// (en vrai on peut mettre n'importe quoi dans ces enregistrements tant qu'il y
		// en a au moins qui correspond à ce qu'on cherche)
		// Trust the process
		List<Article> mockArticles = Arrays.asList(
				new Article("Asus", "PC", 500.0, null),
				new Article("Asus", "Iphone", 1200, null));
		// Indique que lorsqu'on fait appel à la méthode testée, on renvoie mockArticles
		// (qui mime un résultat de recherche)
		// Ce qui fait que notre résultat de recherche renvoie 2 enregistrements
		when(articleRepository.findByBrandContains("Asus"))
				.thenReturn(mockArticles);

		// Méthode à tester : findByBrandContains
		// On lance la méthode findByBrandContains et on stocke le résultat dans results
		List<Article> results = articleRepository.findByBrandContains("Asus");

		// Assertion que la liste des résultats a deux enregistrements
		assertThat(results).hasSize(2);
		// Assertion que l'enregistrement 0 a bien un brand = Asus
		assertThat(results.get(0).getBrand()).isEqualTo("Asus");
	}

}
