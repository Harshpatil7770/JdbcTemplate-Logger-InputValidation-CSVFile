package com.ecart.utility;

import java.util.logging.Logger;

import com.ecart.dao.ProductDaoImpl;
import com.ecart.dao.logger.LoggerImpl;
import com.ecart.model.Brand;
import com.ecart.model.Category;
import com.ecart.model.Product;

public class ProductUtility {

	public Logger logger = LoggerImpl.getLogger(ProductUtility.class);

	public void addNewCategory() {
		System.out.println("Enter category name ::");
		String category_name = InputValidation.inputStringValidation();

		Category category = new Category();
		category.setCategoryName(category_name);
		String methodName = "addNewCategory()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.addNewCategory(category);

	}

	public void addNewBrand() {
		System.out.println("Enter Brand Name ::");
		String brand_name = InputValidation.inputStringValidation();

		System.out.println("Enter Category Id ::");
		int category_id = InputValidation.inputIntegerValidation();

		Brand brand = new Brand();
		Category category = new Category();
		brand.setBrandName(brand_name);
		category.setCategoryId(category_id);
		brand.setCategory(category);

		String methodName = "addNewBrand()";
		logger.info(methodName + " called");
		ProductDaoImpl ProductDaoImpl = new ProductDaoImpl();
		ProductDaoImpl.addNewBrand(brand);
	}

	public void addNewProduct() {
		System.out.println("Enter Product Name ::");
		String product_name = InputValidation.inputStringValidation();
		System.out.println("Enter Product Price ::");
		int product_price = InputValidation.inputIntegerValidation();
		System.out.println("Enter Product Description ::");
		String product_desc = InputValidation.inputStringValidation();
		System.out.println("Enter Brand Id ::");
		int brand_id = InputValidation.inputIntegerValidation();
		System.out.println("Enter Category Id ::");
		int category_id = InputValidation.inputIntegerValidation();

		Product product = new Product();
		Brand brand = new Brand();
		Category category = new Category();

		product.setProductName(product_name);
		product.setProductPrice(product_price);
		product.setProductDescription(product_desc);

		brand.setBrandId(brand_id);
		category.setCategoryId(category_id);

		product.setBrand(brand);
		product.setCategory(category);

		String methodName = "addNewProduct()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.addNewProduct(product);
	}

	public void updateCategory() {
		System.out.println("Enter Existing Category Id ::");
		int category_id = InputValidation.inputIntegerValidation();
		System.out.println("Enter New Category Name ::");
		String category_name = InputValidation.inputStringValidation();

		Category category = new Category();
		category.setCategoryId(category_id);
		category.setCategoryName(category_name);

		String methodName = "updateCategory()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.updateCategorydetails(category);
	}

	public void updateBrand() {
		System.out.println("Enter Existing brand Id ::");
		int brand_id = InputValidation.inputIntegerValidation();
		System.out.println("Enter New Brand Name ::");
		String brand_name = InputValidation.inputStringValidation();
		System.out.println("Enter New Category Id::");
		int category_id = InputValidation.inputIntegerValidation();
		Brand brand = new Brand();
		Category category = new Category();
		brand.setBrandId(brand_id);
		brand.setBrandName(brand_name);
		category.setCategoryId(category_id);
		brand.setCategory(category);

		String methodName = "updateBrand()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.updateBranddetails(brand);
	}

	public void updateProduct() {
		System.out.println("Enter Existing Product Id ::");
		int product_id = InputValidation.inputIntegerValidation();
		System.out.println("Enter New Product Name ::");
		String product_name = InputValidation.inputStringValidation();
		System.out.println("Enter New Product Price ::");
		int product_price = InputValidation.inputIntegerValidation();
		System.out.println("Enter New Product Description ::");
		String product_desc = InputValidation.inputStringValidation();
		System.out.println("Enter New Brand Id");
		int brand_id = InputValidation.inputIntegerValidation();
		System.out.println("Enter New Category Id");
		int category_id = InputValidation.inputIntegerValidation();

		Product product = new Product();
		Brand brand = new Brand();
		Category category = new Category();

		product.setProductId(product_id);
		product.setProductName(product_name);
		product.setProductPrice(product_price);
		product.setProductDescription(product_desc);
		brand.setBrandId(brand_id);
		category.setCategoryId(category_id);

		product.setBrand(brand);
		product.setCategory(category);


		String methodName = "updateProduct()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.updateProductdetails(product);
	}

	public void deleteCategory() {

		System.out.println("Enter Exisiting Category Id::");
		int category_id = InputValidation.inputIntegerValidation();

		Category category = new Category();
		category.setCategoryId(category_id);
		String methodName = "deleteCategory()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.deleteCategoryById(category);
	}

	public void deleteBrand() {
		System.out.println("Enter Exisiting brand Id ::");
		int brand_id = InputValidation.inputIntegerValidation();
		Brand brand = new Brand();
		brand.setBrandId(brand_id);

		String methodName = "deleteBrand()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.deleteBrandById(brand);
	}

	public void deleteProduct() {
		System.out.println("Enter Existing Product Id ::");
		int product_id = InputValidation.inputIntegerValidation();

		Product product = new Product();
		product.setProductId(product_id);
		String methodName = "deleteProduct()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.deleteProductById(product);
	}

	public void fetchProductByUsingId() {
		System.out.println("Enter Product Id ::");
		int product_id = InputValidation.inputIntegerValidation();

		Product product = new Product();
		product.setProductId(product_id);
		String methodName = "fetchProductByUsingId()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.fetchProductByUsingId(product);
	}

	public void fetchProductByUsingCategoryId() {
		System.out.println("Enter Category Id ::");
		int category_id = InputValidation.inputIntegerValidation();

		Product product = new Product();
		Category category = new Category();
		category.setCategoryId(category_id);
		product.setCategory(category);
		String methodName = "fetchProductByUsingCategoryId()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.fetchProductByUsingCategoryId(product);
	}

	public void fetchProductByUsingBrandId() {
		System.out.println("Enter Brand Id::");
		int brand_id = InputValidation.inputIntegerValidation();

		Product product = new Product();
		Brand brand = new Brand();
		brand.setBrandId(brand_id);
		product.setBrand(brand);
		String methodName = "fetchProductByUsingBrandId()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.fetchProductByBrandId(product);
	}

	public void fetchProductByCategoryName() {
		System.out.println("Enter category Name::");
		String category_name = InputValidation.inputStringValidation();
		Product product = new Product();
		Category category = new Category();
		category.setCategoryName(category_name);
		product.setCategory(category);
		String methodName = "fetchProductByCategoryName()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.fetchProductByCategoryName(product);
	}

	public void fetchProductByBrandName() {
		System.out.println("Enter brand Name::");
		String brand_name = InputValidation.inputStringValidation();

		Product product = new Product();
		Brand brand = new Brand();

		brand.setBrandName(brand_name);
		product.setBrand(brand);
		String methodName = "fetchProductByBrandName()";
		logger.info(methodName + " called");
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		productDaoImpl.fetchProductByBrandName(product);
	}
}
