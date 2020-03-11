package swiggyhotel.model;

public class FoodDetails {
	private int itemId;
	private String itemName;
	private String foodType;
	private int price;
	private int menuId;
	private String images;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "FoodDetails [itemId=" + itemId + ", itemName=" + itemName + ", foodType=" + foodType + ", price="
				+ price + ", menuId=" + menuId + "]";
	}

	public String display() {
		return "FoodDetails [images=" + images + ",itemId=" + itemId + ",itemName=" + itemName + ", foodType="
				+ foodType + ", price=" + price + "]";
	}

	public String displayItem() {
		return "FoodDetails [itemName=" + itemName + ", price=" + price + "]";
	}

}
