import javax.swing.JOptionPane;

//ax^2 + bx + c = 0
public class SecondDegreeEquation {
    public static void main(String[] arg){
        String a_str,b_str,c_str;
        a_str=JOptionPane.showInputDialog(null, "Input a:","Input the value of a",JOptionPane.INFORMATION_MESSAGE);
        b_str=JOptionPane.showInputDialog(null, "Input b:","Input the value of b",JOptionPane.INFORMATION_MESSAGE);
        c_str=JOptionPane.showInputDialog(null, "Input c:","Input the value of c",JOptionPane.INFORMATION_MESSAGE);
        
        double a=Double.parseDouble(a_str);
        double b=Double.parseDouble(b_str);
        double c=Double.parseDouble(c_str);
        
        double DELTA=Math.pow(b, 2)-4*a*c;
        
        if (a==0){
            if (b==0){
                if (c==0){
                    JOptionPane.showMessageDialog(null, "Infinite real roots", "Result",JOptionPane.INFORMATION_MESSAGE );
                }
                if (c!=0){
                    JOptionPane.showMessageDialog(null, "No roots", "Result",JOptionPane.INFORMATION_MESSAGE);
    
                }
    
            }
            else{
                JOptionPane.showMessageDialog(null,"x="+ -c/b, "Result",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            if (DELTA==0){
                JOptionPane.showMessageDialog(null, "x="+-b/(2*a), "Result", JOptionPane.INFORMATION_MESSAGE);

            }
            else if (DELTA <0){
                JOptionPane.showMessageDialog(null, "No real roots", "Result", JOptionPane.INFORMATION_MESSAGE);

            }
            else{
                double x1=(-b+Math.sqrt(DELTA))/(2*a);
                double x2=(-b-Math.sqrt(DELTA))/(2*a);
                JOptionPane.showMessageDialog(null, "x1="+x1+"\n"+"x2="+x2, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
