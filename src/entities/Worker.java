package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department; // Tipo department da classe departmente associação
    private List<HourContract> contracts = new ArrayList<>(); // Instanciando ArrayList do tipo HourContract um trabalhador tem varios contratos

    public Worker() { // Inicio do metodo construtos vazio
    }//Fim do metodo construtor

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) { // Inicio do metodo construtor sobre carga
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    } // Fim do metodo construtor sobre carga

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setContracts(List<HourContract> contracts) { // Atenção a esse set
        this.contracts = contracts;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract) { // Metodo para adicionar um novo contrato
        contracts.add(contract); // comando para adicionar contrato ao ArrayList
    }

    public void removeContract(HourContract contract) { // Metodo para remover contrato
        contracts.remove(contract); // Comando para remover contrato do Arraylist
    }

    public double income(int year, int month) { // Metodo de pesquisa de salario baseada nas datas ano e mês

        double sum = baseSalary; // Variavel para armezenar o valor informado para salario
        Calendar cal = Calendar.getInstance(); // variavel para armazenar a data informada dos contratos

        for (HourContract c : contracts) { //Percorre do o ArrayList (for ech)
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH); // o mês do calendar começa com 0, por isso soma mais 1
            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }
}
