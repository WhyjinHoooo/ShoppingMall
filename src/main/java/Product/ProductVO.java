package Product;

import java.sql.Date;

public class ProductVO {
	
	private String name;
	private String kind;
	private String many;
	private String id;
	private String img;
	private String date;
	//private Date date;
	private String company;

	public ProductVO(String img, String name, String kind, String many, String id, String company, String date) {
			super();
			this.name = name;
			this.many = many;
			this.company = company;
			this.img = img;
			this.date = date;
			this.kind = kind;
			this.id = id;
		}
	
	public ProductVO() {
		System.out.println("MemberVO ������ ȣ��");
	}
	
	//public ProductVO(String name, String kind, String many, String id, Date date) {
	public ProductVO(String name, String kind, String many, String id, String date) {
		super();
		this.name = name;
		this.kind = kind;
		this.many = many;
		this.id = id;
		this.date = date;
	}
	
	//public ProductVO(String name, String kind, String many, String id, String img, Date date) {
	public ProductVO(String name, String kind, String many, String id, String img, String date) {
		super();
		this.name = name;
		this.kind = kind;
		this.many = many;
		this.id = id;
		this.img = img;
		this.date = date;
	}
	public ProductVO(String img, String name) {
		super();
		this.img = img;
		this.name = name;
	}
	public String getName() { return name;}
	public void setName(String name) { this.name = name; }
	
	public String getkind() { return kind; }
	public void setkind(String kind) { kind = kind; }
	
	public String getmany() { return many; }
	public void setmany(String many) { many = many; }
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public String getImg() { return img; }
	public void setImg(String img) { this.img = img; }
	
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	//public Date getDate() { return date; }
	//public void setDate(Date date) { this.date = date; }
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

}
