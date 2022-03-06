package Test1;

public class MathEquation {
    private double x;
    private double n;
    private double result;

    public MathEquation(double x, double n) {
        this.setX(x);
        this.setN(n);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double factorial(double n){
        double fact = 1;
        for(int i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }

    public double getResult() {
        double power = 2;
        result = 0;
        for(int i=1; i<=n;i++){
            if(i%2==0)
                result += ((Math.pow(this.x, power)) / (this.factorial(i)));
            else
                result -= (Math.pow(this.x, power) / this.factorial(i));
            power+=2;
        }
        return result;
    }

}
