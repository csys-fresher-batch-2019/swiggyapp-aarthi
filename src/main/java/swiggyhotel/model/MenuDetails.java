package swiggyhotel.model;
public class MenuDetails {
	
	private int menuId;
	private String category;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "MenuDetails [menuId=" + menuId + ", category=" + category + "]";
	}
	

}
