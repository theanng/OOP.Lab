import javax.swing.JOptionPane;

public class CalTwoNumbers{
    public static void main(String args[]) {
        String snum1, snum2;
        snum1=JOptionPane.showInputDialog(null,"Please input the first number:","Input the first number",1);
        snum2=JOptionPane.showInputDialog(null,"Please input the second number:","Input the second number",1);
        double num1= Double.parseDouble(snum1);
        double num2= Double.parseDouble(snum2);
        double sum=num1+num2;
        double dif=num1-num2;
        double pro=num1*num2;
        
        if (num2!=0){
            JOptionPane.showMessageDialog(null, "Sum: " + sum + "\n" + "Difference: " + dif + "\n" + "Product: " + pro +"\n" + "Quotient: " + num1/num2,
             "Result", 1);
        }
        else{
            JOptionPane.showMessageDialog(null, "Sum: " + sum + "\n" + "Difference: " + dif + "\n"+"Product: " + pro + "\n" + "Quotient: Divisor=0",
             "Result", 1);
        }
        

    }
}