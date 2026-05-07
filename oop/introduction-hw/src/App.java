class SampleClass {
    String string;
    int number;

    public SampleClass(String string, int number) {
        this.string = string;
        this.number = number;
    }

    public void print() {
        System.out.println("string: " + string);
        System.out.println("number: " + number);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        SampleClass sampleClass = new SampleClass("hello", 10);
        sampleClass.print();
    }
}
