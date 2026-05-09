class MultipleResponsibilities {
    public void print() {
        System.out.println("Printing!");
    }

    public void fax() {
        System.out.println("Faxing!");
    }

    public void scan() {
        System.out.println("Scanning!");
    }
}

interface Printable {
    void print();
}

interface Faxable {
    void fax();
}

interface Scannable {
    void scan();
}

class Printer implements Printable {
    @Override
    public void print() {
        System.out.println("Printing!");
    }
}

class MultifunctionalMachine extends Printer implements Faxable, Scannable {
    @Override
    public void fax() {
        System.out.println("Faxing!");
    }

    @Override
    public void scan() {
        System.out.println("Scanning!");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        MultifunctionalMachine machine = new MultifunctionalMachine();
        
        Printable printer = machine;
        printer.print();
        
        Faxable faxer = machine;
        faxer.fax();
        
        Scannable scanner = machine;
        scanner.scan();
    }
}
