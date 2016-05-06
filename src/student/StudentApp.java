package student;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter , Consumer<Student> action , Comparator<Student> sortBy) {
		students.stream().filter(filter).sorted( sortBy).forEach(action);
	}

	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		LocalDate localDate = LocalDate.now();
		Predicate<Student> filter = s -> s.getBirthdate().getDayOfYear() <= localDate.getDayOfYear()+14 && s.getBirthdate().getDayOfYear() >= localDate.getDayOfYear();
		Consumer<Student> action = s -> System.out.printf("%s %s will have birthday on %d %s.\n" , s.getFirstname() , s.getLastname() , s.getBirthdate().getDayOfMonth() , s.getBirthdate().getMonth());
		Comparator<Student> byName = (a,b) -> a.getFirstname().charAt(0) - b.getFirstname().charAt(0);
		Comparator<Student> byBirthday = (a,b) -> a.getBirthdate().getDayOfMonth() - b.getBirthdate().getDayOfMonth() ;
		StudentApp app = new StudentApp();
		app.filterAndPrint(students, filter , action , byBirthday);
	}
}
