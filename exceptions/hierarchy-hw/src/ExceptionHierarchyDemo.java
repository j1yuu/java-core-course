public class ExceptionHierarchyDemo {
    public static void main(String[] args) throws Exception {
        try {
            runExample(1);
            runExample(2);
            runExample(3);
        } catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception handled");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
    }

    public static void runExample(int mode) {
        switch(mode) {
            case 1 -> {
                System.out.println(1 / 0);
                break;
            }
            case 2 -> {
                int[] arr = new int[2];
                arr[3] = 1;
                System.out.println(arr[3]);
                break;
            }
            case 3 -> {
                throw new RuntimeException("Something went wrong");
            }
        }
    }
}
