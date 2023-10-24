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
        
        for(Human h: array){
            h.doSomething();
        }
        //a lambda expresion
        DoingSomething doing = (()-> System.out.println("\n doing something"));
        doing.doSomething();
    }

    static class Human implements DoingSomething,SayHi{
        String name;

        public String getName() {
            return name;
        }

        public void printSomething() {
            System.out.println("I am a Human");                       
        }
        @Override
        public void doSomething() {
            System.out.println("I am Doing something");
        }

        @Override
        public void hi() {
            System.out.println("Hi, I am a human and I can speak");
        }
    }

    static class Employee extends Human {

        @Override
        public void printSomething() {
            System.out.println("I am an employee");
        }
        
        @Override
        public void doSomething(){
            System.out.println("I'm working");
        }

    }

    static class Boss extends Employee {
        @Override
        public void printSomething() {
            System.out.println("I am a Boss");
        }
        @Override
        public void doSomething(){
            System.out.println("Working very, very hard");
        }
    }

    static final class Director extends Boss {
        @Override
        public void printSomething() {
            System.out.println("I am a Director");
        }
        
        @Override
        public void doSomething(){
            System.out.println("Working extremely hard... sometimes");
        }
    }

    static class Student extends Human   {
        @Override
        public void printSomething() {
            System.out.println("I am a student");
        }

        
    }
    
    //iterfaces(in this case i will also aply FuncitionalInterfaces to add some
//complexity with lambda expresions)
    @FunctionalInterface
    interface DoingSomething{
        void doSomething();
    }
    
    @FunctionalInterface
    interface SayHi{
        void hi();
    }
}