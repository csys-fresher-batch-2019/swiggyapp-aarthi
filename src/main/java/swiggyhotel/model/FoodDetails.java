package swiggyhotel.model;

public class FoodDetails {

	public int itemId;
	public String itemName;
	public String foodType;
	public int price;
	public int menuId;
	public String images;
	
	@Override
	public String toString() {
		return "FoodDetails [itemId=" + itemId + ", itemName=" + itemName + ", foodType=" + foodType + ", price="
				+ price + ", menuId=" + menuId + "]";
	}
	
	
	
}
