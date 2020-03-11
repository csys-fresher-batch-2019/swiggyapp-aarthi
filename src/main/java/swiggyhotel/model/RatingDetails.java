package swiggyhotel.model;

public class RatingDetails {
	private int userId;
	private int itemId;
	private String itemName;
	private int ratingPoints;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setRatingPoints(int ratingPoints) {
		this.ratingPoints = ratingPoints;
	}

	public int getRatingPoints() {
		return ratingPoints;
	}

	@Override
	public String toString() {
		return "RatingDetails [userId=" + userId + ", itemId=" + itemId + ", itemName=" + itemName + ", ratingPoints="
				+ ratingPoints + "]";
	}
}
