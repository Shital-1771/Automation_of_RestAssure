package JavaConcepts;

public class Car2 {
	
	int price;
	int wheels;
	String model;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car2 c=new Car2();
		c.setModel("BMW");
		c.setPrice(100000);
		c.setWheels(4);
		
		System.out.println(c.getModel());
		System.out.println(c.price);
		System.out.println(c.getWheels());

	}

}
