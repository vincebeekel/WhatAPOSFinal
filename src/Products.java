
public class Products {
	private String name;
	private String category;
	private String description;
	private String price;
	private int quantity;
	//double priceDBL = Double.parseDouble(price);

	public Products(String name, String category, String description, String price) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
//	public double getPriceDBL() {
//		return priceDBL;
//	}
//
//	public void setPriceDBL(double priceDBL) {
//		this.priceDBL = priceDBL;
//	}
	

	@Override
	public String toString() {
		return name + "," + category + "," + description + "," + ( quantity)  ;
	}

}
