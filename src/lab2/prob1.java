package lab2;

import java.util.Scanner;
import java.util.StringTokenizer;

interface Temperature {
    public double getCelsius();

    public double getFahrenheit();

    public void setCelsius(double celsius);

    public void setFahrenheit(double fahrenheit);
}


class MyTemperature implements Temperature{
	
	private double celsius;
	char scale;

	public MyTemperature(double value, char scale){
		// TODO Auto-generated constructor stub
		this.scale = scale;
		if (scale=='C') setCelsius(value);
		else setFahrenheit(value);
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
	public void setFahrenheit(double fahrenheit) {
		// TODO Auto-generated method stub
		this.celsius = 5*(fahrenheit - 32)/9;
	}
	
	public String toString() {
		if (scale == 'C') {
			return Math.round(getFahrenheit()*100)/100.0 + "";
		}
		else return Math.round(getCelsius()*100)/100.0 + "";
	}
}

public class prob1{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	int n = Integer.parseInt(input.nextLine());
    	for (int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(input.nextLine());
            double value = Double.parseDouble(st.nextToken());
            char scale = Character.toUpperCase(st.nextToken().charAt(0));
           MyTemperature temprature = new MyTemperature(value, scale);
            System.out.println(temprature);
    	}
    }
}
