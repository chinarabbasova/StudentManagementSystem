import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
       Student s1,s2,s3;
        LocalDate date = LocalDate.of(1995, 05,14);
        LocalDate date1 = LocalDate.of(1998,1,12);


        Student [] students = {
                s1 = new Student("11K","Orxan",  date),
         s2 = new Student("41l", " Ayse",date1 ),
         s3 = new Student("5J", "Ayxan", date),
        };
        s1.addExamResults(new Exam(80,"Math"));
        s2.addExamResults(new Exam(95,"English"));
        s3.addExamResults(new Exam(97," History"));

        for(Student student : students){
            System.out.println(student.toString());
        }
        Path path = Path.of("file.txt");
        save(path, students);
       load(path);

    }
    public static void save(Path path, Student[] student){
        try( BufferedWriter writer = Files.newBufferedWriter(path)){
            for(int i = 0; i< student.length; i++) {
                writer.write("\n " + student[i].getClassName()+ " " + student[i].getExamList().toString());
                writer.newLine();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

//    public static  void save(Path path, Student[] students ) throws IOException {
//        try {
//            List <Student> aList = new ArrayList<>();
//
//            for(int i=0;i< students.length;i++) {
//                aList.add(students[i]);
//            }
//            File file = new File("file.txt");
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            FileWriter fw = new FileWriter(file);
//            BufferedWriter bf = new BufferedWriter(fw);
//            for (int i=0;i<aList.size();i++){
//                bf.write(aList.get(i).toString());
//            }
//            bf.flush();
//            bf.close();
//
//        } catch (Exception ex){
//            System.out.println(ex.toString());
//        }
//        }

    public  static void load(Path path) throws IOException {
        try {
            BufferedReader br = Files.newBufferedReader(path);
            String st;
            while((st= br.readLine())!= null)
                System.out.println(st);
        } catch (Exception ex ){
            System.out.println(ex.toString());
        }
    }
}
