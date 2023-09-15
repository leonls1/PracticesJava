public class InheritanceAbstract {

    public static void main(String[] args) {
        Human[] array = new Human[5];

        array[0] = new Employee();
        array[1] = new Employee();
        array[2] = new Boss();
        array[3] = new Director();
        array[4] = new Student();

        for (Human h : array) {
            h.printSomething();
        }
    }

    static class Human {
        String name;

        public String getName() {
            return name;
        }

        public void printSomething() {
            System.out.println("I am a Human");
        }
    }

    static class Employee extends Human {

        @Override
        public void printSomething() {
            System.out.println("I am an employee");
        }

    }

    static class Boss extends Employee {
        @Override
        public void printSomething() {
            System.out.println("I am a Boss");
        }
    }

    static final class Director extends Boss {
        @Override
        public void printSomething() {
            System.out.println("I am a Director");
        }
    }

    static class Student extends Human {
        @Override
        public void printSomething() {
            System.out.println("I am a student");
        }
    }
}