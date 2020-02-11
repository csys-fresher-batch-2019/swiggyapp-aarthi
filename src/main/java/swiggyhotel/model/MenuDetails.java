package swiggyhotel.model;

/*import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;*/
public class MenuDetails {
	
	public int menuId;
	public String category;
	@Override
	public String toString() {
		return "MenuDetails [menuId=" + menuId + ", category=" + category + "]";
	}
	

}
