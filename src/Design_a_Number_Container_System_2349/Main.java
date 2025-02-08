package Design_a_Number_Container_System_2349;

public class Main {
    public static void main(String[] args) {
        NumberContainers obj = new NumberContainers();
        int param_2 = obj.find(10);
        obj.change(2,10);
        obj.change(2,20);
        obj.change(1,10);
        int param_3 = obj.find(10);
        int param_4 = obj.find(20);

        System.out.println("param_2 : " + param_2);
        System.out.println("param_3 : " + param_3);
        System.out.println("param_3 : " + param_4);
    }
}
