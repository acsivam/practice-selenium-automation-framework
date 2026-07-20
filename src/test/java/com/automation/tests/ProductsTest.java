package com.automation.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.assertions.CartModalAssertions;
import com.automation.assertions.CartAssertions;
import com.automation.assertions.ProductAssertions;
import com.automation.base.BaseTest;
import com.automation.components.CartModal;
import com.automation.components.CartTable;
import com.automation.components.CategoryBrandSidebar;
import com.automation.components.ProductContainer;
import com.automation.components.ProductGrid;
import com.automation.components.ProductImage;
import com.automation.components.ProductInformation;
import com.automation.components.RecommendedItems;
import com.automation.constants.AppConstants;
import com.automation.models.CartItem;
import com.automation.models.Product;
import com.automation.pages.BrandProductsPage;
import com.automation.pages.CategoryProductsPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductDetailsPage;
import com.automation.pages.ProductsPage;
import com.automation.testdata.TestDataFactory;

@Test(groups = {"Producs"})
public class ProductsTest extends BaseTest{
	
	private HomePage homePage;
	private BrandProductsPage brandsPage;
	private CategoryProductsPage categoryPage;
	private ProductsPage productsPage;
	private ProductDetailsPage productDetailsPage;
	
	
	@BeforeMethod
	public void productsTestSetup() {
		homePage = new HomePage(driver);
	}
	
	
	public void shouldDisplayProductsOnHomePage() throws InterruptedException  {
		Product stylishDress = TestDataFactory.stylishDress();
		
		ProductGrid featuredItems = homePage.getProductGrid();		
		RecommendedItems recommededItems = homePage.getRecommendedItems();
		
		Thread.sleep(100);
		ProductAssertions.assertThat(featuredItems)
			.isDisplayed()
			.hasProductsDisplayed()			
			.hasProducts(stylishDress)
			.hasDefaultProductCard(stylishDress);
		
		ProductAssertions.assertThat(recommededItems)
			.isDisplayed()
			.hasProductsDisplayed()
			.hasRecommendedProductCard(stylishDress);
	}

	
	public void shouldAddFeaturedProductToCartFromPHomePage()  {
		Product blueTop = TestDataFactory.bluetop();
		CartItem expectedItem = new CartItem(blueTop, 1);
		
		CartModal addToCart = homePage
				.getProductGrid()
				.getProductByName(blueTop.getName())
				.clickAddToCart();
		
		CartModalAssertions.verifyThat(addToCart)
			.hasDefaultCartModal();
		
		CartTable cartTable = addToCart
				.viewCart()
				.getCartTable();
		
		CartAssertions.verifyThat(cartTable)
			.hasProduct(expectedItem);
	}
	
	
	public void shouldAddRecommendedProductToCartFromPHomePage()  {
		Product stylishDress = TestDataFactory.stylishDress();
		CartItem expectedItem = new CartItem(stylishDress, 1);
		
		CartModal addToCart = homePage
				.getRecommendedItems()
				.getProductByName(stylishDress.getName())
				.clickAddToCart();
		
		CartModalAssertions.verifyThat(addToCart)
			.hasDefaultCartModal();
		
		CartTable cartTable = addToCart
				.viewCart()
				.getCartTable();
		
		CartAssertions.verifyThat(cartTable)
			.hasProduct(expectedItem);
	}
	
	
	public void shouldNavigateTFeaturedProductDetailsFromHome() {
		Product blueTop = TestDataFactory.bluetop();
		
		productDetailsPage = homePage
				.getProductGrid()
				.getProductByName(blueTop.getName())
				.clickViewProduct();
		
		Assert.assertTrue(productDetailsPage.isLoaded());
	}
	
	
	public void shouldDisplayAllProductsOnProductPage() {
		int totalCount = 34;

		ProductGrid prodGrid = homePage
				.getTopMenu()
				.goToProductsPage()
				.getProductGrid();
		
		ProductAssertions.assertThat(prodGrid)
			.hasProductCount(totalCount);
	}
	
	
	public void shouldSearchProductSuccessfully() {
		String searchKeyword = "blue";
		
		productsPage = homePage
				.getTopMenu()
				.goToProductsPage();
		
		ProductGrid prodGrid = productsPage
				.getProductSearch()
				.searchProduct(searchKeyword)
				.getProductGrid();
		
		ProductAssertions.assertThat(prodGrid)
			.hasProductCount(7);
		
		
		searchKeyword = "black";
	
		prodGrid = productsPage
				.getProductSearch()
				.searchProduct(searchKeyword)
				.getProductGrid();
		
		ProductAssertions.assertThat(prodGrid)
			.hasProductCount(0);
	}
	
	
	public void shouldFilterProductsByCategory() {
		String category = "Women";
		String subCat = "Dress";
		List<String> expectedSub = List.of("DRESS", "TOPS", "SAREE");
		
		productsPage = homePage
				.getTopMenu()
				.goToProductsPage();
		
		List<String> subCategories = productsPage
			.getCategoryBrandSidebar()
			.expandCategory(category)
			.getSubCategoryNames();
		
		Assert.assertEquals(
				subCategories, expectedSub, 
				"Subcategories mismatch"
				);	

		categoryPage = productsPage
				.getCategoryBrandSidebar()
				.selectSubCategory(subCat);
		
		Assert.assertTrue(categoryPage.isLoaded());
	
		Assert.assertEquals(categoryPage.getProductGrid().getHeading(),
				AppConstants.getCategoryProductsHeading(category, subCat),
				"Productgrid heading mismatch");		
	}

	
	@Test
	public void shouldFilterProductsByBrand() {
		String brand = "Polo";
		
		brandsPage = homePage
				.getTopMenu()
				.goToProductsPage()
				.getCategoryBrandSidebar()
				.selectBrand(brand);
		
		Assert.assertTrue(brandsPage.isLoaded());
		
		Assert.assertEquals(brandsPage.getProductGrid().getHeading(),
				AppConstants.getBrandProductsHeading(brand),
				"Productgrid heading mismatch");	
		
	}
	
	
	public void shouldAddProductToCartFromProductsPage()  {
		Product mensTshirt = TestDataFactory.mensTshirt();
		CartItem expectedItem = new CartItem(mensTshirt, 1);
		
		CartModal addToCart = homePage
				.getTopMenu()
				.goToProductsPage()
				.getProductGrid()
				.getProductByName(mensTshirt.getName())
				.clickAddToCart();
		
		CartModalAssertions.verifyThat(addToCart)
			.hasDefaultCartModal();
		
		CartTable cartTable = addToCart
				.viewCart()
				.getCartTable();
		
		CartAssertions.verifyThat(cartTable)
			.hasProduct(expectedItem);
	}

	
	public void shouldNavigateToProductDetailsPageFromProductsPage() {
		Product mensTshirt = TestDataFactory.mensTshirt();
		
		productDetailsPage = homePage
				.getTopMenu()
				.goToProductsPage()
				.getProductGrid()
				.getProductByName(mensTshirt.getName())
				.clickViewProduct();
		
		Assert.assertTrue(productDetailsPage.isLoaded());
	}

	
	public void shouldVerifyProductDetails() {
		Product blueTop = TestDataFactory.bluetop();
		
		//Pre-requisite
		navigateToProductDetailsPage(blueTop);

		ProductImage prodImg = productDetailsPage.getProductImage();
		
		ProductInformation  prodInfo = productDetailsPage.getProductInformation();
	
		
		ProductAssertions verifyProdImage = new ProductAssertions(prodImg);
		verifyProdImage
			.hasDefaultProductImage(blueTop.getProductId());
		
		ProductAssertions verifyProdInfo = new ProductAssertions(prodInfo);
		verifyProdInfo
			.hasDefaultProductInformation(blueTop);
	}


	public void shouldAddProductToCartFromProductDetailsPage()  {
		Product mensTshirt = TestDataFactory.mensTshirt();
		CartItem expectedItem = new CartItem(mensTshirt, 1);
		
		productDetailsPage = navigateToProductDetailsPage(mensTshirt);
		
		CartModal addToCart = productDetailsPage
				.getProductInformation()
				.clickAddToCart();
		
		CartModalAssertions.verifyThat(addToCart)
			.hasDefaultCartModal();
		
		CartTable cartTable = addToCart
				.viewCart()
				.getCartTable();
		
		CartAssertions.verifyThat(cartTable)
			.hasProduct(expectedItem);
	}
	
	
	private ProductDetailsPage navigateToProductDetailsPage(Product product) {
		return homePage
			.getTopMenu()
			.goToProductsPage()
			.getProductGrid()
			.getProductByName(product.getName())
			.clickViewProduct();
	}
}
