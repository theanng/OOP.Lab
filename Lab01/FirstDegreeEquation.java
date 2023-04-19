import javax.swing.JOptionPane;

//ax +b =0
public class FirstDegreeEquation {
    public static void main(String[] args){
        String a0;
        String b0;
        
        a0=JOptionPane.showInputDialog(null, "Input a:","Input the value of a", JOptionPane.INFORMATION_MESSAGE);

        b0=JOptionPane.showInputDialog(null,"Input b:","Input the value of b", JOptionPane.INFORMATION_MESSAGE);
        double a= Double.parseDouble(a0);
        double b= Double.parseDouble(b0);
        
        if (a==0){
            if (b==0){
                JOptionPane.showMessageDialog(null, "All real numbers are root", "Answer",JOptionPane.INFORMATION_MESSAGE );
            }
            if (b!=0){
                JOptionPane.showMessageDialog(null, "No real roots", "Answer",JOptionPane.INFORMATION_MESSAGE);

            }

        }
        else{
            JOptionPane.showMessageDialog(null,"x="+ -b/a, "Answer",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
