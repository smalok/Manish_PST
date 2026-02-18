import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Event {
    String name;
    LocalDate date;

    Event(String name, String dateStr) {
        this.name = name;
        this.date = LocalDate.parse(dateStr); // Parses yyyy-MM-dd
    }

    public String getName() { return name; }
    public LocalDate getDate() { return date; }
}

public Task_9{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            events.add(new Event(parts[0], parts[1]));
        }
        int filterMonth = Integer.parseInt(sc.nextLine());

        // 1. Sort events chronologically
        events.sort(Comparator.comparing(Event::getDate));
        System.out.println(events.stream().map(Event::getName).collect(Collectors.joining(" ")));

        // 2. Determine earliest and latest events
        System.out.println(events.get(0).getName());
        System.out.println(events.get(events.size() - 1).getName());

        // 3. Filter by month
        String filtered = events.stream()
            .filter(e -> e.getDate().getMonthValue() == filterMonth)
            .map(Event::getName)
            .collect(Collectors.joining(" "));
        System.out.println(filtered);
        
        sc.close();
    }
}
