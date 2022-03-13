package com.ecart.main;

import java.io.FileNotFoundException;

import com.ecart.dao.ProductDaoImpl;
import com.ecart.utility.InputValidation;
import com.ecart.utility.ProductUtility;

public class Main {

	public void showMainMenu() throws FileNotFoundException {

		int num = 1;
		do {
			System.out.println("========================================================");
			System.out.println("==================== Welcome To Ecart ==================");
			System.out.println("========================================================");

			System.out.println("1)   Add New Category                      ");
			System.out.println("2)   Add New Brand                         ");
			System.out.println("3)   Add New Product                       ");
			System.out.println("4)   Update Category                       ");
			System.out.println("5)   Update Brand                          ");
			System.out.println("6)   Update Product                        ");
			System.out.println("7)   Delete Category                       ");
			System.out.println("8)   Delete Brand                          ");
			System.out.println("9)   Delete Product                        ");
			System.out.println("10)  Fetch All Products and write it back to excel sheet in csv format");
			System.out.println("11)  Fetch Product By Using Id             ");
			System.out.println("12)  Fetch Product By Using Category Id    ");
			System.out.println("13)  Fetch Product By Using Brand Id       ");
			System.out.println("14)  Fetch Product By Using Category Name  ");
			System.out.println("15)  Fetch Product By Using Brand Name     ");

			System.out.println("--------------------------------------------------");
			System.out.println("\nEnter the choice (In number only for eg - 1,2,3)");

			int ch = InputValidation.inputIntegerValidation();

			ProductUtility productUtility = new ProductUtility();
			ProductDaoImpl productDaoImpl = new ProductDaoImpl();

			switch (ch) {
			case 1:
				System.out.println("========= You have selected option 1) Add New Category ======");
				productUtility.addNewCategory();
				break;
			case 2:
				System.out.println("========= You have selected option 2) Add New Brand =========");
				productUtility.addNewBrand();
				break;
			case 3:
				System.out.println("========= You have selected option 3) Add New Product =======");
				productUtility.addNewProduct();
				break;
			case 4:
				System.out.println("========= You have selected option 4) Update Category =======");
				productUtility.updateCategory();
				break;
			case 5:
				System.out.println("======== You have selected option 5) Update Brand ==========");
				productUtility.updateBrand();
				break;
			case 6:
				System.out.println("======= You have selected option 6) Update Product =========");
				productUtility.updateProduct();
				break;
			case 7:
				System.out.println("======== You have selected option 7) Delete Category =======");
				productUtility.deleteCategory();
				break;
			case 8:
				System.out.println("======== You have selected option 8) Delete Brand ==========");
				productUtility.deleteBrand();
				break;
			case 9:
				System.out.println("=======You have selected option 9) Delete Product ===========");
				productUtility.deleteProduct();
				break;
			case 10:
				System.out.println("=======You have selected option 10) Fetch All Products"
						+ "Write it back to excel sheet csv format =========");
				productDaoImpl.fetchAllProducts().forEach(System.out::println);
				break;
			case 11:
				System.out.println("=======You have selected option 11) Fetch Product By "
						+ "Using Product using ProductId  =========");
				productUtility.fetchProductByUsingId();
				break;
			case 12:
				System.out.println("=======You have selected option 12)  Fetch Product By Using Category Id");
				productUtility.fetchProductByUsingCategoryId();
				break;
			case 13:
				System.out.println("=======You have selected option 13)  Fetch Product By Using Brand Id");
				productUtility.fetchProductByUsingBrandId();
				break;
			case 14:
				System.out.println("=======You have selected option 14)  Fetch Product By Using Category Name");
				productUtility.fetchProductByCategoryName();
				break;
			case 15:
				System.out.println("=======You have selected option 15)  Fetch Product By Using Brand Name");
				productUtility.fetchProductByBrandName();
				break;
			default:
				System.out.println("Please Enter the Available Choice Number ::");
				break;
			}
			System.out.println("\n-----------------------------------------------------------");
			System.out.println("Do you want to continue ? 1)yes 2)no");
			num = InputValidation.inputIntegerValidation();
		} while (1 == num);

	}
}
