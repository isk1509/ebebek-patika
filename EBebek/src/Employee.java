public class Employee {

    /*

        Not: Haftalık bonus, toplam maaşa 4 kez eklenmiştir.
             Zam miktarı vergi düşülmeden önce hesaplanmıştır.
             Vergi, bonuslar ve zam eklendikten sonra maaştan kesilmiştir.


     */

    String name;
    double salary;
    int workHours;
    int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax(double grossSalary) {
        if (grossSalary > 0 && grossSalary < 1000) {
            return 0;
        } else if (grossSalary >= 1000) {
            return grossSalary * 0.03;
        } else {
            System.out.println("Maaş eksi olamaz.");
        }

        return 0.0;
    }


    public int bonus(){
        if (workHours > 40){
            return (workHours - 40) * 30;
        }
        return 0;
    }

    public double raiseSalary(){
        int time = 2021;
        if (time - hireYear < 10){
            return (salary +bonus()) * 0.05;
        }else if (time - hireYear > 9 && time - hireYear < 20){
            return  (salary +bonus()) * 0.10;
        }else if (time - hireYear >19){
            return (salary +bonus()) * 0.15;
        }
        return 0;
    }

    @Override
    public String toString() {

        double grossSalary = salary + bonus() + raiseSalary();
        double finalSalary = grossSalary - tax(grossSalary);
        return
                 "İsim= " + name + '\n'
               + "Başlangıç Yılı= " + hireYear + '\n'
               + "Çalışma Saati= " + workHours + '\n'
               + "Maaş= " + salary + '\n'
               + "Haftalık Bonus= " + bonus()  + '\n'
               + "Aylık Bonus= " + bonus() * 4  + '\n'
               + "Zam Miktarı= " + raiseSalary()  + '\n'
               + "Vergi Kesintisi= " + tax(grossSalary) + '\n'
               + "Toplam Maaş= " + finalSalary ;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Sercan",10000,45,2007);
        System.out.println(employee.toString());
    }
}
