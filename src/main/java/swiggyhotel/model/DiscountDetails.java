package swiggyhotel.model;

public class DiscountDetails {
	public int minvalue;
	public int maxValue;
	public int discountRate;
	@Override
	public String toString() {
		return "DiscountDetails [minvalue=" + minvalue + ", maxValue=" + maxValue + ", discountRate=" + discountRate
				+ "]";
	}
	/*public int getMinvalue() {
		return minvalue;
	}
	public void setMinvalue(int minvalue) {
		this.minvalue = minvalue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}*/

}
