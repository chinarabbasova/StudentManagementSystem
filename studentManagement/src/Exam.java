public class Exam {

    private int result;
   private String subject;

    public Exam(int result, String subject) {
        this.result = result;
        this.subject = subject;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Override
    public String toString(){
        return " The result is " + result;
    }
}
