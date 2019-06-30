package application;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import entities.Department;
import entities.Worker;
import entities.enums.WorkLevel;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        
        System.out.println("Enter work date:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        
        System.out.print("Salary: ");
        Double baseSalary = sc.nextDouble();
        
        Worker worker = new Worker(workerName, WorkLevel.valueOf(workerName), baseSalary, new Department(departmentName) );
        
               
    }

}
