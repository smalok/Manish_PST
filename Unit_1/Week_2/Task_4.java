import java.util.*; 
import java.util.stream.*; 
 
class Person { 
    String name; 
    int age; 
 
    Person(String name, int age) { 
        this.name = name; 
        this.age = age; 
    } 
 
    public String getName() { 
        return name; 
    } 
 
    public int getAge() { 
        return age; 
    } 
 
    // Static method for filtering 
    public static boolean isOlderThanLimit(Person p, int ageLimit) { 
        return p.age > ageLimit; 
    } 
} 
 
public class Task_4{ 
 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt(); 
 
        List<Person> persons = new ArrayList<>(); 
 
        for (int i = 0; i < n; i++) { 
            String name = sc.next(); 
            int age = sc.nextInt(); 
            persons.add(new Person(name, age)); 
        } 
 
        int ageLimit = sc.nextInt(); 
 
        // Sort names alphabetically using method reference 
        persons.stream() 
                .map(Person::getName) 
                .sorted(String::compareTo) 
                .forEach(name -> System.out.print(name + " ")); 
        System.out.println(); 
 
        // Filter persons older than ageLimit using static method reference 
        persons.stream() 
                .filter(p -> Person.isOlderThanLimit(p, ageLimit)) 
                .map(Person::getName) 
                .forEach(name -> System.out.print(name + " ")); 
        System.out.println(); 
 
        // Convert all names to uppercase using instance method reference 
        persons.stream() 
                .map(Person::getName) 
                .map(String::toUpperCase) 
                .forEach(name -> System.out.print(name + " ")); 
    } 
} 