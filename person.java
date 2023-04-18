import java.util.Date;
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
    for(int i=0;i<42;++i){System.out.print('-');}
    int k=0;
    System.out.println(' ');
    System.out.print("| ");
    System.out.print(String.format("%s %c.%c. %c %d ",Surname,Name.toCharArray()[0],Second_name.toCharArray()[0],MF,age));
    if(age%10==1){System.out.print("Год");k=3;}
    if(age%10>1 && age%10<5){System.out.print("Года");k=4;}
    if(age%10>6 || (age>7 && age<21)){System.out.print("Лет");k=3;}
    for(int j=40-Second_name.length()-10-k;j>0;--j){System.out.print(' ');}
    System.out.println('|');
    for(int i=0;i<42;++i){System.out.print('-');}




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
        /**
        age counting
         */
        Date date = new Date();
        String day=String.format("%te", date);
        String year = String.format("%tY", date);
        String month = String.format("%tm", date);
        age = Integer.parseInt(year)-Integer.parseInt(Y);
        if(Integer.parseInt(M)-Integer.parseInt(month)<0) age-=1;
        if(Integer.parseInt(D)-Integer.parseInt(day)<0) age-=1;
        /**
         * MF detecting
         */
        if(Second_name.toCharArray()[Second_name.length()-1]=='ч'){MF='М';}
        else{MF='Ж';}

    }

}
