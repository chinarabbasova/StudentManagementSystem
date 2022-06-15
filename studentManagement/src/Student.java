import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Student extends Human implements Comparable <Student>, Iterable <Exam>{

        String className;

    public void setClassName(String className) {
        this.className = className;
    }
//    public Student() {
//        super();
//    }

    public List<Exam> getExamList() {
        return examList;
    }
    List<Exam> examList = new ArrayList<>();

    public Student(String className, String name, LocalDate age) {
        super(name, age);
        this.className= className;

    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public Iterator<Exam> iterator() {
        return examList.iterator();
    }


    private class StudentIterable implements  Iterable<Exam> {
        @Override
        public Iterator<Exam> iterator() {
            Exam[] exams = new Exam[examList.size()];
            examList.toArray(exams);
            Arrays.sort(exams);
            return Arrays.asList(exams).iterator();
        }
    }


        @Override
        public int compareTo(Student o) {
            return 0;
        }
        public Iterable<Exam> getOrderedExams() {
            StudentIterable orderedExams = new StudentIterable();
            return orderedExams;
        }
        public Iterable<Exam> getOrderesExams(){
        return  new Iterable<Exam>() {
            @Override
            public Iterator<Exam> iterator() {
                Exam[] exams = new Exam[examList.size()];
                examList.toArray(exams);
                Arrays.sort(exams);
                return Arrays.asList(exams).iterator();
            }
        };
        }

        public List <Exam> addExamResults(Exam result){
        examList.add(result);
        return examList;
        }

        @Override
    public String toString(){
        return  getClassName()+ "  information is: " + getName() + " " + getAge();
    }
    public String getClassName() {
        return className;
    }
    }

