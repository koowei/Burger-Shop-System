package DataList;
import java.util.List;

import Objects.Item;

public class ItemData implements IObjectData{
	private static ItemData single_instance = null;
	private java.util.ArrayList<Item> items;
	private ItemData()
	{
		items = new java.util.ArrayList<Item> ();
		defaultObject();
	}
	public static ItemData getInstance() {
		if(single_instance == null)
			single_instance = new ItemData();
		return single_instance;
	}

	@Override
	public Object[] getArray() {
		Item [] itemsArr = new Item[this.items.size()];
		return this.items.toArray(itemsArr);
	}

	@Override
	public void defaultObject() {
		items.add(new Item(1, "Veggie Burger", "Delicious vegetarian patty with lettuce and tomato", "Available", 9.99));
		items.add(new Item(2, "Classic Cheeseburger", "Beef patty with melted cheese, lettuce, tomato, and ketchup", "Out of Stock", 12.99));
		items.add(new Item(3, "Bacon Cheeseburger", "Beef patty with melted cheese, crispy bacon, lettuce, tomato, and mayo", "Available", 14.99));
		items.add(new Item(4, "Mushroom Swiss Burger", "Beef patty with sautéed mushrooms, swiss cheese, lettuce, and garlic aioli", "Available", 13.99));
		items.add(new Item(5, "Spicy Chicken Sandwich", "Crispy chicken fillet with spicy mayo, lettuce, and tomato on a bun", "Out of Stock", 10.99));
		items.add(new Item(6, "Grilled Chicken Sandwich", "Grilled chicken fillet with avocado, lettuce, tomato, and mayo on a bun", "Available", 11.99));
		items.add(new Item(7, "Fish Burger", "Fried fish fillet with lettuce, tomato, and tartar sauce on a bun", "Available", 12.99));
		items.add(new Item(8, "Impossible Burger", "Plant-based burger patty with lettuce, tomato, and special sauce on a bun", "Out of Stock", 15.99));
		items.add(new Item(9, "Double Bacon Cheeseburger", "Two beef patties with melted cheese, double bacon, lettuce, tomato, and mayo", "Available", 17.99));
		items.add(new Item(10, "Turkey Burger", "Turkey patty with lettuce, tomato, and cranberry mayo on a bun", "Available", 11.99));
		
	}
	@Override
	public List<Item> record() {
		return this.items;
	}

}
