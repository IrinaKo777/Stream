import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        //System.out.println(persons);
        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println(count);

        List<String> list = persons.stream()
                .filter(age -> age.getAge() >= 18)
                .filter(age -> age.getAge() < 27)
                .filter(sex -> sex.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        persons.stream()
                .filter(education-> education.getEducation() == Education.HIGHER)
                .filter(age -> age.getAge() >= 18)
                .filter(value -> value.getSex()==Sex.MAN && value.getAge() < 65 || value.getSex()==Sex.WOMAN && value.getAge() < 60)
                .sorted(Comparator.comparing(Person ::getFamily))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
