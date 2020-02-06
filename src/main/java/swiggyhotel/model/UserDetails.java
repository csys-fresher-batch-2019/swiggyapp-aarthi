package swiggyhotel.model;

public class UserDetails {
	
	public int userId;
	public String userName;
	public Long phoneNo;
	public String address;
	public String city;
	

	
	/*public UserDetails(int userId, String userName, Long phoneNo, String address, String city) {
		this.userId = userId;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.city = city;
	}*/


	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", phoneNo=" + phoneNo + ", address="
				+ address + ", city=" + city + "]";
	}

}
