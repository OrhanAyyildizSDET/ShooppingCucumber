package pages;

public class Training {
    private  int age = 12;
    private static String name = "Selly";

    public static void main(String[] args) {
        Training training = new Training();
        System.out.println(training.getAge());
        name = "Yaades";
        System.out.println(name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
