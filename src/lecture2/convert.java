package lecture2;

import java.util.Scanner;
import java.util.StringTokenizer;

interface Temprature {
    public double getCelsius();

    public double getFahrenheit();

    public void setCelsius(double celsius);

    public void setFarenheit(double farenheit);

}

class MyTemprature implements Temprature{
	
	private double celsius;
	char scale;

	public MyTemprature(double value, char scale){
		// TODO Auto-generated constructor stub
		this.scale = scale;
		if (scale=='C') setCelsius(value);
		else setFarenheit(value);
	}

	@Override
	public double getCelsius() {
		// TODO Auto-generated method stub
		return celsius;
	}

	@Override
	public double getFahrenheit() {
		// TODO Auto-generated method stub
		return 9*celsius/5 + 32.0;
	}

	@Override
	public void setCelsius(double celsius) {
		// TODO Auto-generated method stub
		this.celsius = celsius;
	}

	@Override
	public void setFarenheit(double farenheit) {
		// TODO Auto-generated method stub
		this.celsius = 5*(farenheit - 32)/9;
	}
	
	public String toString() {
		if (scale == 'C') {
			return Math.round(getFahrenheit())+"";
		}
		else return Math.round(getCelsius())+"";
	}
}

public class convert {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	int n = Integer.parseInt(input.nextLine());
    	for (int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(input.nextLine());
            double value = Double.parseDouble(st.nextToken());
            char scale = Character.toUpperCase(st.nextToken().charAt(0));
            MyTemprature temprature = new MyTemprature(value, scale);
            System.out.println(temprature);
    	}
    }
}
