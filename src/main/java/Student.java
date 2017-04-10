import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class Student {
    String name;
    int age;
    boolean verified;
    int[] marks;
}