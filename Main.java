import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /**
         * Asking for name,surname,second name and age
         */
        System.out.println("Введите данные в формате : Фамилия Имя Отчество день.месяц.год \n -> Иванов Иван Иванович 15.01.1990");
        /**
         * Scanner creating
        */
        Scanner in = new Scanner(System.in);
        /**
         * Data - string of  name,surname,second name and age
         */
        String Data=in.nextLine();
        /**
         * Checking Data
         */
        if(Data.length()==0){System.out.println("EMPTY!"); System.exit(1);}
        /**
         * person contains separated name,surname,second name and age;
         */
        person human = new person(Data);
        human.show();


        }





    }
