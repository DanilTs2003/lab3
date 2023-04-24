import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * person contains separated name,surname,second name and age;
 */

public class person {
    String Surname="";
    String Name="";
    String Second_name="";
    int age;
    /**
     * MF- Male or Female
     */
    char MF;
    /**
     * Y,D,M - year day and month of birth
     */
    String Y="",D="",M="";
    void show(){
    int k=0;
    System.out.print(String.format("%s %c.%c. %c %d ",Surname,Name.toCharArray()[0],Second_name.toCharArray()[0],MF,age));
    if(age%10==1 && age!=11){System.out.print("Год");k=3;}
    if(age%10>1 && age%10<5 && (age>20|| age<10)){System.out.print("Года");k=4;}
    if(age%10>4 || (age>7 && age<21) || age%10==0){System.out.print("Лет");k=3;}
    }
    person(String Data){
        int i=0;
        /**
         * Name parsing
         */
        while(Data.toCharArray()[i]!=' ' && i < Data.length()){Surname+=Data.toCharArray()[i];++i;}
        while(Data.toCharArray()[i]==' ')++i;
        while(Data.toCharArray()[i]!=' ' && i < Data.length()){Name+=Data.toCharArray()[i];++i;}
        while(Data.toCharArray()[i]==' ')++i;
        while(Data.toCharArray()[i]!=' ' && i < Data.length()){Second_name+=Data.toCharArray()[i];++i;}
        while(Data.toCharArray()[i]==' ')++i;
        /**
         * birth parsing
         */
        D+=Data.toCharArray()[i];D+=Data.toCharArray()[i+1];i+=3;
        M+=Data.toCharArray()[i];M+=Data.toCharArray()[i+1];i+=3;
        Y+=Data.toCharArray()[i];Y+=Data.toCharArray()[i+1];i+=2;
        Y+=Data.toCharArray()[i];Y+=Data.toCharArray()[i+1];

        for(int flag=0;true;){
            if(flag==1){
                Scanner in = new Scanner(System.in);
                int k=in.nextInt();
                M="";
                M+=k;
            }
            int mt=Integer.parseInt(M);
            if(mt>12){System.out.println("\nMonth  error! MAX : 12 ");flag=1;continue;}
            else{break;}
        };
        for(int flag=0;true;) {

            if(flag==1){
                Scanner in = new Scanner(System.in);
                int k=in.nextInt();
                D="";
                D+=k;
            }
            int temp=Integer.parseInt(D);
            int mt=Integer.parseInt(M);
            if (mt == 2 && temp >= 30) {
                System.out.println("\nBirth day error! MAX : 29 ");
                flag=1;continue;
            }
            if ((mt == 1) && (mt == 3) && (mt == 5) && (mt == 7) && (mt == 8) && temp >= 32 && (mt == 12) && (mt == 10)) {
                System.out.println("\nBirth day error! MAX : 31 ");
                flag=1;continue;
            }
            else if (  temp >= 31 && ((mt == 4) || (mt == 6) || (mt == 9) || (mt == 11) )) {
                System.out.println("\nBirth day error! MAX : 30 ");
                flag=1;continue;
            }
            else{break;}

        }


        /**
        age counting
         */
        Date date = new Date();
        String day=String.format("%te", date);
        String year = String.format("%tY", date);
        String month = String.format("%tm", date);
        age = Integer.parseInt(year)-Integer.parseInt(Y);
        int m_dif=Integer.parseInt(month)-Integer.parseInt(M);
        int d_dif=Integer.parseInt(day)-Integer.parseInt(D);
        if((m_dif<0) || ((m_dif==0) && (d_dif<0))){
            age-=1;
        }
        /**
         * MF detecting
         */
        if(Second_name.toCharArray()[Second_name.length()-1]=='ч'){MF='М';}
        else{MF='Ж';}

    }

}
