package inventory.model;

public class Product {
	private String productId;
	private String productName;
	private String productType;
	private String productPrice;

	private String productsQuantity;
	private String reorderLevel;
	private String expiryDate;
	private boolean valid;


	public Product(){
		super();
	}
	public Product(String productId,String productName,String productType,String productPrice,String productQuantity,String reorderLevel,String expiryDate) {
		super();
		this.productId= productId;
		this.productName= productName;
		this.productType= productType;
		this.productPrice= productPrice;
	
		this.productsQuantity= productQuantity;
		this.reorderLevel= reorderLevel;
		this.expiryDate= expiryDate;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductsQuantity() {
		return productsQuantity;
	}
	public void setProductsQuantity(String productsQuantity) {
		this.productsQuantity = productsQuantity;
	}
	public String getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(String reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
}
