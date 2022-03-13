package com.ecart.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.ecart.dao.logger.LoggerImpl;
import com.ecart.dbconfig.DBConfig;
import com.ecart.model.Brand;
import com.ecart.model.Category;
import com.ecart.model.Product;

public class ProductDaoImpl {

	public Logger logger=LoggerImpl.getLogger(ProductDaoImpl.class);
	
	public void addNewCategory(Category category) {

		try {
			Connection con = DBConfig.getConnection();
			String sql = "insert into categories values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, category.getCategoryId());
			ps.setString(2, category.getCategoryName());

			int res = ps.executeUpdate();

			if (res != 0) {
				String methodName="addNewCategory()";
				logger.info(methodName+ " called");
				System.out.println("-------------------------------------------------------");
				System.out.println("------------ New Category Added Succesfully -----------");
				System.out.println("-------------------------------------------------------");
			} else {
				System.out.println("-------------------------------------------------------");
				System.out.println("---------------- Category Not Added -------------------");
				System.out.println("-------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addNewBrand(Brand brand) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "insert into brands values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, brand.getBrandId());
			ps.setString(2, brand.getBrandName());
			ps.setInt(3, brand.getCategory().getCategoryId());

			int res = ps.executeUpdate();
			if (res != 0) {
				String methodName="addNewBrand()";
				logger.info(methodName+ " called");
				System.out.println("-------------------------------------------------------");
				System.out.println("-------------- New Brand Added Succesfully ------------");
				System.out.println("-------------------------------------------------------");
			} else {
				System.out.println("-------------------------------------------------------");
				System.out.println("------------------- Brand Not Added -------------------");
				System.out.println("-------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addNewProduct(Product product) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "insert into products values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setInt(3, product.getProductPrice());
			ps.setString(4, product.getProductDescription());
			ps.setInt(5, product.getBrand().getBrandId());
			ps.setInt(6, product.getCategory().getCategoryId());

			int res = ps.executeUpdate();
			if (res != 0) {
				String methodName="addNewProduct()";
				logger.info(methodName+ " called");
				System.out.println("-------------------------------------------------------");
				System.out.println("------------- New Product Added Succesfully -----------");
				System.out.println("-------------------------------------------------------");
			} else {
				System.out.println("-------------------------------------------------------");
				System.out.println("------------------ Product Not Added ------------------");
				System.out.println("-------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCategorydetails(Category category) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "update categories set category_name=? where category_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getCategoryName());
			ps.setInt(2, category.getCategoryId());

			int res = ps.executeUpdate();
			if (res != 0) {
				String methodName="updateCategorydetails()";
				logger.info(methodName+ " called");
				System.out.println("-------------------------------------------------------");
				System.out.println("--------------- Update Category Succesfully -----------");
				System.out.println("-------------------------------------------------------");
			} else {
				System.out.println("-------------------------------------------------------");
				System.out.println("------------------ Category Not Updated ---------------");
				System.out.println("-------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateBranddetails(Brand brand) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "update brands set brand_name=?,category_id=? where brand_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, brand.getBrandName());
			ps.setInt(2, brand.getCategory().getCategoryId());
			ps.setInt(3, brand.getBrandId());

			int res = ps.executeUpdate();

			if (res != 0) {
				String methodName="updateBranddetails()";
				logger.info(methodName+ " called");
				System.out.println("-------------------------------------------------------");
				System.out.println("--------------- Update Brand Succesfully --------------");
				System.out.println("-------------------------------------------------------");
			} else {
				System.out.println("-------------------------------------------------------");
				System.out.println("--------------------- Brand Not Updated ---------------");
				System.out.println("-------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProductdetails(Product product) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "update products set product_name=?,product_price=?,product_desc=?,brand_id=?,category_id=? where product_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getProductPrice());
			ps.setString(3, product.getProductDescription());
			ps.setInt(4, product.getBrand().getBrandId());
			ps.setInt(5, product.getCategory().getCategoryId());
			ps.setInt(6, product.getProductId());

			int res = ps.executeUpdate();
			if (res != 0) {
				String methodName="updateProductdetails()";
				logger.info(methodName+ " called");
				System.out.println("-------------------------------------------------------");
				System.out.println("--------------- Update Product Succesfully ------------");
				System.out.println("-------------------------------------------------------");
			} else {
				System.out.println("-------------------------------------------------------");
				System.out.println("------------------- Product Not Updated ---------------");
				System.out.println("-------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCategoryById(Category category) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "delete from categories where category_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, category.getCategoryId());

			int res = ps.executeUpdate();
			if (res != 0) {
				String methodName="deleteCategoryById()";
				logger.info(methodName+ " called");
				System.out.println("-------------------------------------------------------");
				System.out
						.println("--------------- Delete Category Succesfully --------:: " + category.getCategoryId());
				System.out.println("-------------------------------------------------------");
			} else {
				System.out.println("-------------------------------------------------------");
				System.out.println("------------------- Category Not deleted --------------");
				System.out.println("-------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBrandById(Brand brand) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "delete from brands where brand_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, brand.getBrandId());

			int res = ps.executeUpdate();

			if (res != 0) {
				String methodName="deleteBrandById()";
				logger.info(methodName+ " called");
				System.out.println("-------------------------------------------------------");
				System.out.println("--------------- Delete Brand Succesfully --------:: " + brand.getBrandId());
				System.out.println("-------------------------------------------------------");
			} else {
				System.out.println("-------------------------------------------------------");
				System.out.println("------------------- Brand Not deleted --------------");
				System.out.println("-------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProductById(Product product) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "delete from products where product_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getProductId());

			int res = ps.executeUpdate();
			if (res != 0) {
				String methodName="deleteProductById()";
				logger.info(methodName+ " called");
				System.out.println("-------------------------------------------------------");
				System.out.println("--------------- Delete Product Succesfully --------:: " + product.getProductId());
				System.out.println("-------------------------------------------------------");
			} else {
				System.out.println("-------------------------------------------------------");
				System.out.println("------------------- Product Not deleted --------------");
				System.out.println("-------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Product> fetchAllProducts() throws FileNotFoundException {
		String userDefPath = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop";
		File file = new File(userDefPath + "\\ecart.csv");
		PrintWriter out = new PrintWriter(file);
		List<Product> listofproducts = new ArrayList<Product>();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("product_id");
			sb.append(",");
			sb.append("product_name");
			sb.append(",");
			sb.append("product_price");
			sb.append(",");
			sb.append("product_desc");
			sb.append(",");
			sb.append("brand_id");
			sb.append(",");
			sb.append("brand_name");
			sb.append(",");
			sb.append("category_id");
			sb.append(",");
			sb.append("category_name");
			sb.append(",");
			sb.append("\n");
			out.write(sb.toString());

			Connection con = DBConfig.getConnection();
			Statement st = con.createStatement();
			String sql = "select p.product_id,product_name,product_price,product_desc,p.brand_id,brand_name,p.category_id,category_name from products p inner join brands b on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id;";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				Brand brand = new Brand();
				Category category = new Category();

				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getInt(3));
				product.setProductDescription(rs.getString(4));
				brand.setBrandId(rs.getInt(5));
				brand.setBrandName(rs.getString(6));
				category.setCategoryId(rs.getInt(7));
				category.setCategoryName(rs.getString(8));
				product.setBrand(brand);
				product.setCategory(category);
				out.println(product.getProductId() + "," + product.getProductName() + "," + product.getProductPrice()
						+ "," + product.getProductDescription() + "," + product.getBrand().getBrandId() + ","
						+ product.getBrand().getBrandName() + "," + product.getCategory().getCategoryId() + ","
						+ product.getCategory().getCategoryName());
				listofproducts.add(product);
			}
			String methodName="fetchAllProducts()";
			logger.info(methodName+ " called");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

		return listofproducts;

	}

	public void fetchProductByUsingId(Product product) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "select * from products where product_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getProductId());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String methodName="fetchAllProducts()";
				logger.info(methodName+ " called");
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + "," + rs.getInt(3) + ","
						+ rs.getString(4) + "," + rs.getInt(5) + "," + rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fetchProductByUsingCategoryId(Product product) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "select p.product_id,product_name,product_price,product_desc,p.category_id,category_name from products p inner join categories c on p.category_id=c.category_id where p.category_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getCategory().getCategoryId());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3) + "," + rs.getString(4)
						+ "," + rs.getInt(5) + "," + rs.getString(6));
			}
			String methodName="fetchProductByUsingCategoryId()";
			logger.info(methodName+ " called");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fetchProductByBrandId(Product product) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "select p.product_id,product_name,product_price,product_desc,b.brand_id,brand_name from products p inner join brands b on p.brand_id=b.brand_id where p.brand_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getBrand().getBrandId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3) + "," + rs.getString(4)
						+ "," + rs.getInt(5) + "," + rs.getString(6));
			}
			String methodName="fetchProductByBrandId()";
			logger.info(methodName+ " called");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fetchProductByCategoryName(Product product) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "select p.product_id,product_name,product_price,product_desc,c.category_id,category_name from products p inner join categories c on p.category_id=c.category_id where c.category_name=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getCategory().getCategoryName());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3) + "," + rs.getString(4)
						+ "," + rs.getInt(5) + "," + rs.getString(6));
			}
			String methodName="fetchProductByCategoryName()";
			logger.info(methodName+ " called");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fetchProductByBrandName(Product product) {
		try {
			Connection con = DBConfig.getConnection();
			String sql = "select p.product_id,p.product_name,p.product_price,p.product_desc,b.brand_id,brand_name from products p inner join brands b on p.brand_id=b.brand_id where b.brand_name=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getBrand().getBrandName());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3) + "," + rs.getString(4)
						+ "," + rs.getInt(5) + "," + rs.getString(6));
			}
			String methodName="fetchProductByBrandName()";
			logger.info(methodName+ " called");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
