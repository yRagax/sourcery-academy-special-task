import java.time.LocalDate;

public class ReverseDatesSolSLOW {

    public static void printBonusDatesBetween(int fromYear, int toYear) {

        LocalDate date = LocalDate.of(fromYear, 1, 1);
        LocalDate endDate = LocalDate.of(toYear, 12, 31);

        while (!date.isAfter(endDate)) {
            String strForward = date.toString().replace("-","").replace("+","");
            String strBackward = new StringBuilder(strForward).reverse().toString();
            if(strForward.equals(strBackward)) {
                System.out.println(date.toString().replace("+",""));
            }
            date = date.plusDays(1);
        }
    }

    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }
}