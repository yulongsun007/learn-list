package win.yulongsun.demo.all.basic.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Sun.YuLong on 2017/10/8.
 */
public class ReferenceCase {

    //对象::实例方法
    @Test
    public void test() {
        Employee         employee = new Employee();
        PrintStream      ps       = System.out;
        Consumer<String> consumer = str -> ps.println(str);
        consumer.accept("hello world");
        //
        System.out.println("------------");
        consumer = ps::println;
        consumer.accept("hello world2");
    }


    @Test
    public void test2() {
        Employee         employee = new Employee(1, "zhangsan", 25, 33.3);
        Supplier<String> supplier = () -> employee.getName();
        System.out.println(supplier.get());
        //
        Supplier<Integer> supplierAge = employee::getAge;
        System.out.println(supplierAge.get());
    }

    //类名::静态方法
    @Test
    public void test3(){

    }
}

class Employee {
    int    id;
    String name;
    int    age;
    double salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
