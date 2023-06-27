package Objects;

public class OrderDetail
{
	private String item;
	private int quantity;
    private double unitPrice;
    
    public OrderDetail(String item, int quantity, double unitPrice) {
        this.item = item;
    	this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    
    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public double getTotalPrice() {
    	return unitPrice * quantity;
    }
    public String toString()
    {
    	return item.substring(0, Math.min(item.length(), 20)) + "\t\t x " + quantity + "\t\t" + getTotalPrice() +"\n";
    }
    
    
}