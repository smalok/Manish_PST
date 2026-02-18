import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Task_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();

        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student a, Student b) {
                if (Double.compare(b.getCgpa(), a.getCgpa()) != 0) {
                    return Double.compare(b.getCgpa(), a.getCgpa());
                }
                int nameCompare = a.getFname().compareTo(b.getFname());
                if (nameCompare != 0) {
                    return nameCompare;
                }
                return a.getId() - b.getId();
            }
        });

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
