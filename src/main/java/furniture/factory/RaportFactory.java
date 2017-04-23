package main.java.furniture.factory;

public class RaportFactory {
  
	public static IRaport getRaportGenerator() {
		return new FileRaport();
	}
	
}
