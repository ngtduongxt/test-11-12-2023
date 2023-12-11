public class Student {
    private static int nextId = 1;
    private int id;
    private String name;
    private int age;
    private double math;
    private double physical;
    private double chemistry;
    private float avg;
    private String rank;

    public Student(String name, int age, double math, double physical, double chemistry) {
        this.id = nextId++;
        this.name = name;
        this.age = age;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
        this.avg = (float) ((math + physical + chemistry) / 3.0);
        calculateRank();
    }

    public void calculateRank() {
        if (avg >= 8.0) {
            rank = "GIOI";
        } else if (avg >= 6.5 && avg < 8.0) {
            rank = "KHA";
        } else if (avg >= 5.0 && avg < 6.5) {
            rank = "TB";
        } else {
            rank = "YEU";
        }
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
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

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "\n" + "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", math=" + math +
                ", physical=" + physical +
                ", chemistry=" + chemistry +
                ", avg=" + avg +
                ", rank='" + rank + '\'' +
                '}' + "\n";
    }
}
