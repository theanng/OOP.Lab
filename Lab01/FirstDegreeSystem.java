import javax.swing.JOptionPane;
//a1x1+b1x2=c1
//a2x1+b2x2=c2
public class FirstDegreeSystem {
    public static void main(String[] args){
        String a1_str,a2_str,c1_str,b1_str,b2_str,c2_str;
        a1_str=JOptionPane.showInputDialog(null, "Input a1","Input the value of a1",JOptionPane.INFORMATION_MESSAGE);
        b1_str=JOptionPane.showInputDialog(null, "Input b1","Input the value of b1",JOptionPane.INFORMATION_MESSAGE);
        c1_str=JOptionPane.showInputDialog(null, "Input c1","Input the value of c1",JOptionPane.INFORMATION_MESSAGE);
        
        a2_str=JOptionPane.showInputDialog(null, "Input a2","Input the value of a2",JOptionPane.INFORMATION_MESSAGE);
        b2_str=JOptionPane.showInputDialog(null, "Input b2","Input the value of b2",JOptionPane.INFORMATION_MESSAGE);
        c2_str=JOptionPane.showInputDialog(null, "Input c2","Input the value of c2",JOptionPane.INFORMATION_MESSAGE);
        
        double a1=Double.parseDouble(a1_str);
        double b1=Double.parseDouble(b1_str);
        double c1=Double.parseDouble(c1_str);
        double a2=Double.parseDouble(a2_str);
        double b2=Double.parseDouble(b2_str);
        double c2=Double.parseDouble(c2_str);

        double D=(a1*b2-b1*a2);
        double D1x=-(b1*c2-c1*b2);
        double D2x=(a1*c2-c1*a2);
        if (D!=0){
            JOptionPane.showMessageDialog(null, "x="+D1x/D +"\n" +"y="+D2x/D,"Solution",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            double M=a2/a1;
            double N=c2/c1;
            if (M==N){
                JOptionPane.showMessageDialog(null, "Infinite solutions", "Result",JOptionPane.INFORMATION_MESSAGE);
            }
            if (M!=N){
                JOptionPane.showMessageDialog(null, "No solution", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }


    }
    
    
}
