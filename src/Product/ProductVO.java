package Product;

public class ProductVO {
	private String productName;
	private int sellingPrice;
	private int normalPrice;
	private int quantity;
	private int turnover;
	private int rank;
	private int rankChange;
	private int rate;

	public ProductVO(String productName, int normalPrice, int sellingPrice, int quantity) {
		this.productName = productName;
		this.normalPrice = normalPrice;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
	}
	
	public ProductVO(int turnover, String productName, int normalPrice, int sellingPrice, int rate) {
		this.turnover = turnover;
		this.productName = productName;
		this.normalPrice = normalPrice;
		this.sellingPrice = sellingPrice;
		this.rate = rate;
	}

	// getter and setter
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(int normalPrice) {
		this.normalPrice = normalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRankChange() {
		return rankChange;
	}

	public void setRankChange(int rankChange) {
		this.rankChange = rankChange;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getTurnover() {
		return turnover;
	}

	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}

	@Override
	public String toString() {
		return "ProductVO [productName=" + productName + ", sellingPrice=" + sellingPrice + ", normalPrice="
				+ normalPrice + ", quantity=" + quantity + ", rank=" + rank + ", rankChange=" + rankChange + ", rate="
				+ rate + "]";
	}
}
