package Objects;
import java.util.*;



public class Order 
{
	User user;
	private List<OrderDetail> orderDetails;
	private int orderId;
    private String date;
    
    public Order(User user,int orderId) 
    {
    	this.user = user;
        this.orderId = orderId;
        this.date = new Date().toString();
        orderDetails = new ArrayList<>();
    }
    public User getUser()
    {
    	return this.user;
    }
    public int getOrderId() 
    {
        return orderId;
    }

    public void setOrderId(int orderId) 
    {
        this.orderId = orderId;
    }

    public String getDate() 
    {
        return date;
    }
    
    public void setDate(String date) 
    {
        this.date = date;
    }
    
    public List<OrderDetail> getOrderDetails()
    {
    	return this.orderDetails;
    }
    public void addItem(OrderDetail orderDetail)
    {
    	this.orderDetails.add(orderDetail);
    }
    public boolean deleteItem(int ItemNumber)
    {
    	OrderDetail itemToRemove = this.orderDetails.get(ItemNumber-1);
    	return this.orderDetails.remove(itemToRemove);
    }
    public double getTotalPrice() 
    {
        double totalPrice = 0.0;
        for (OrderDetail orderDetail : orderDetails) 
        {
            totalPrice += orderDetail.getTotalPrice();
        }
        return totalPrice;
    }
    public String toString()
    {
    	String orderString = "  Item\t\t\t\tQuantity\tSubtotal\n"; 
    	for(OrderDetail od: orderDetails)
    	{
    		orderString+=(orderDetails.indexOf(od)+1)+"."+od.toString();
    	}
    	return orderString;
    }

    
}