//internship task 1//
//CodeWay Solutions Private Limited//
//Student Grade Calculator//

import java.util.Scanner;
class grade_calculator
{
     float maths,science,english,social,gujarati,percentage,total;
     String grade;

     Scanner sc=new Scanner(System.in);
     protected void fetch_marks()
     {
         System.out.println("Enter Marks of Mathemartics(out of 100):");
         maths=sc.nextFloat();
         System.out.println("Enter Marks of Science(out of 100):");
         science=sc.nextFloat();
         System.out.println("Enter Marks of English(out of 100):");
         english=sc.nextFloat();
         System.out.println("Enter Marks of Social(out of 100):");
         social=sc.nextFloat();
         System.out.println("Enter Marks of Gujarati(out of 100):");
         gujarati=sc.nextFloat();
  
         total=(maths+social+science+gujarati+english);
     }
     protected void obtain_percentage()
     {
         this.percentage=(this.total/500)*100;
     }
     protected void compute_grade()
     {
          this.grade="";
          if(this.percentage<=100&&this.percentage>90)
          {
              this.grade="A+";
          }
          if(this.percentage<=90&&this.percentage>80)
          {
              this.grade="A";
          }
          if(this.percentage<=80&&this.percentage>70)
          {
              this.grade="B+";
          }
          if(this.percentage<=70&&this.percentage>60)
          {
              this.grade="B";
          }
          if(this.percentage<=60&&this.percentage>50)
          {
              this.grade="C+";
          }
          if(this.percentage<=50&&this.percentage>40)
          {
              this.grade="C";
          }
          if(this.percentage<=40&&this.percentage>=35)
          {
              this.grade="D+";
          }
          if(this.percentage<=34)
          {
              this.grade="Fail";
          }
        System.out.println("Grade is "+this.grade);
          
     }
    protected void display_result()
    {
          System.out.println("==================RESULT===================");
          System.out.println("Total Marks Obtained(out of 500):"+this.total);
          System.out.println("Percentage (out of 100%):"+this.percentage);
          System.out.println("Grade occupied:"+this.grade);
          if(this.grade.equals("Fail"))
          {
            System.out.println("Sorry!!! Exam Not Cleared");
          }
          else
          {
            System.out.println("Congratulations!!! Exam cleared");
          }
          System.out.println("===========================================");
    }
}
public class internship1
{
    public static void main(String arguments[])
    {
          grade_calculator gc=new grade_calculator();
           gc.fetch_marks();
           gc.obtain_percentage();
           gc.compute_grade();
           gc.display_result();
    }
}
