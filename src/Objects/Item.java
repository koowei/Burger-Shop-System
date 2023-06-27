package Objects;
public class Item 
{
    private int itemId;
    private String name;
    private String description;
    private String status;
    private double price;
    
    
    // Constructor
    public Item(int itemId, String name, String description, String status, double price) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.price = price;
        
    }
    
    // Getters and setters
    public int getId() {
        return itemId;
    }
    
    public void setId(int itemId) {
        this.itemId = itemId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString()
    {
    	
    	return "Item id: "+ itemId
    		  +"\nItem Name: "+ name
    		  +"\nItem Description: " + description
    		  +"\nItem Status: "+ status
    		  +"\nItem Price: " + price;
    }
}