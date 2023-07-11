package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	
	
	private static  String dbURL = "";
	private static  String dbID = "";
	private static  String dbPassword = "";
	private static  String driver = "";
	
	
	public ProductDAO() {
		
		driver = "com.mysql.jdbc.Driver";
		dbURL = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC&useSSL=false";
		dbID = "root";
		dbPassword = "jinsang1027#";
		
	}
	
	public List<ProductVO> listProducts(String id) {

		List<ProductVO>  productsList = new ArrayList();
		
		try {
				try {
						connDB();	
				} catch (Exception e) {
					e.printStackTrace();
				}
				String query = "select * from product where productor_id = '" + id + "'";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				String kind = rs.getString("kind");
				String many = rs.getString("many");
				String date = rs.getString("date");
				//Date date = rs.getDate("date");
				
				ProductVO productVO = new ProductVO(name, kind, many, id, date);
				
				productsList.add(productVO);
				
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productsList;
	}

	public void addProduct(ProductVO p) {
		try {
			
			try {
					connDB();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String name = p.getName();
			String kind = p.getkind();
			String many = p.getmany();
			String id = p.getId();
			String img = p.getImg();
			String date = p.getDate();
			//Date date = p.getDate();
			String sql = 
					"INSERT INTO product(name, kind, many, productor_id, img, date)" 
					+ "VALUES(?,?,?,?,?,?)";
						
			PreparedStatement pstmt = conn.prepareStatement(sql);
						
			pstmt.setString(1, name);
			pstmt.setString(2, kind);
			pstmt.setString(3, many);
			pstmt.setString(4, id);
			pstmt.setString(5, img);
			pstmt.setString(6, date);
			//pstmt.setDate(6, date);
						
					
			pstmt.executeUpdate();	
					
			pstmt.close();
						
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProductVO> showProducts(String str) {
		List<ProductVO> productList = new ArrayList<ProductVO>();
		try {
			try {
				connDB();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			String kind = str;
			String sql = "select product.name,many,img,productor_id,company,date from product,productor where product.productor_id=productor.id and kind='"+str+"'";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String many= rs.getString("many");
				String company= rs.getString("company");
				String img = rs.getString("img");
				String date = rs.getString("date");
				String id = rs.getString("productor_id");
					
				ProductVO productVO = new ProductVO(img,name,kind,many,id,company,date);
				productList.add(productVO);
					
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	public List<ProductVO> showAll(){
		List<ProductVO> allList = new ArrayList<ProductVO>();
		try {
			try {
				connDB();
			}catch(Exception e) {
				e.printStackTrace();
			}

			String sql = "select img, name from product order by many";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String img = rs.getString("img");
					
				ProductVO productVO = new ProductVO(img,name);
				allList.add(productVO);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return allList;
	}
	
	public ProductVO showOne(String str) {
		ProductVO product = new ProductVO();
		try {
			try {
				connDB();
			}catch(Exception e) {
				e.printStackTrace();
			}

			String sql = "select product.name,kind,many,img,productor_id,company,date from product,productor where product.productor_id=productor.id and product.name='"+str+"'";
			//제품의 정보를 수량에 맞게 오름차순으로 정렬하여 값을 가져오는 쿼리문
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("product.name");
				String kind = rs.getString("kind");
				String many = rs.getString("many");
				String id = rs.getString("productor_id");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String date = rs.getString("date");
					
				 product = new ProductVO(img,name,kind,many,id,company,date);
				//ProductVO 생성자를 호출하여 해당 상품의 상품정보가 담긴 product 객체 생성
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	private void connDB() {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			System.out.println("Connection 이 성공적으로 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}