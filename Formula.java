package isc.chem_project;
import java.util.*;
class Formula
{
    String chemform;
    double molmas = 0;
    Formula(String cform)
    {
        chemform = cform;//Chemical  formula
    }
    void calculate()
    {
        String s[] = new String[20];// Symbols of the elements in the chemical formula
        double massat =0;//Atomic masses
        double coeff[] = new  double[20];//Coefficients
        int len = chemform.length();//Number of  characters in the  formula
        char c;
        String ch, coefficient;
        int a = 0, i = 0, end = 0;
        chemform = chemform + " ";
        // Lexical analysis of the chemical formula
        do
        {
            ch = ""; coefficient = "1"; coeff[a] =0;
            //  First letter has to be uppercase
            c = chemform.charAt(i);
            if(Character.isUpperCase(c))
            {
                ch = String.valueOf(c);
                s[a] = ch;
                i++;
            }
            // If  exists, second letter has to be lowercase
            c = chemform.charAt(i);
            if(Character.isLowerCase(c))
            {
                ch = String.valueOf(c);
                s[a] =s[a] + ch; // The symbol of  the element is obtained
                i++;
            }
            // Then could be a number
            c = chemform.charAt(i);
            if(Character.isDigit(c))
            {
                coefficient = String.valueOf(c);
                i++;
            }
            // Could again be a number
            c = chemform.charAt(i);
            if(Character.isDigit(c))
            {
                coefficient = coefficient + String.valueOf(c);
                i++;
            }
            // Then could be a dot if it is a real number
            c = chemform.charAt(i);
            if(c =='.')
            {
                coefficient = coefficient + ".";
                i++;
            }
            // Then it could be First decimal
            c = chemform.charAt(i);
            if(Character.isDigit(c))
            {
                coefficient = coefficient + String.valueOf(c);
                i++;
            }
            // Then it could again be a digit(second decimal)
            c = chemform.charAt(i);
            if(Character.isDigit(c))
            {
                coefficient = coefficient + String.valueOf(c);
                i++;
            }
            c = chemform.charAt(i);
            // The next character could be a comma
            if(c ==',') 
            {
                i++;
            }
            coeff[a] =  Double.valueOf(coefficient);
            if (coeff[a]==0)
            {
                coeff[a] = 1;
            }
            a++;
        }while(i<=len-1); // End of the lexical analysis of the chemical formula
        end=a;
        calculation obj=new calculation(end, s, coeff);
        molmas = obj.mass();
    }

    double result()
    {
        return molmas;
    }

    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a chemical formula:");
        String str=sc.next();
        Formula obj=new Formula(str);
        obj.calculate();
        if(obj.result()==0)
        {
            System.out.println("Wrong formula");
        }
        else
        {
            System.out.println("The molecular mass of the above compound is "+obj.result()+"g");
        }
    }
}