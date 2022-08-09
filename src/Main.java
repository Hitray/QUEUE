import java.util.*;

public class Main {
    private static final int MAXIMUM_NUMBER_OF_TICKETS = 4;

    public static void main(String[] args) {
        Person person;

      
        List<Person> clients = generateClients();

        Queue<Person> queueForTheRide = new LinkedList<>(clients);

        while (!queueForTheRide.isEmpty()) {
            person = queueForTheRide.poll();
            person.decrementNumberOfTickets();
            System.out.printf("%s %s прокатился на аттракционе (dbg>> %d Tickets left)\n",
                    person.getName(), person.getSurName(), person.getNumberOfTickets());
            if (person.getNumberOfTickets() > 0) {
                queueForTheRide.offer(person);
            }
        }
    }

    static List<Person> generateClients() {
        var random = new Random();
        Person[] clients = new Person[]{
                new Person("Донна", "Тартт"),
                new Person("Билл", "Гейтс"),
                new Person("Стив", "Джобс"),
                new Person("Линус", "Торвальдс"),
                new Person("Ричард", "Гэрриот")
        };
        // Раздаем билетики
        for (Person person : clients) {
            person.setNumberOfTickets(random.nextInt(MAXIMUM_NUMBER_OF_TICKETS) + 1);
        }
        return Arrays.asList(clients);
    }
}
