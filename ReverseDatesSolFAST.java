public class ReverseDatesSolFAST {

    private static boolean isValidDate(int year, int month, int day) {
        if(day<1 || day>31 || month<1 || month>12) {
            return false;
        }
        if(month==2) {
            if((year%4==0 && year%100!=0) || (year%400==0)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        } else if(month==4 || month==6 || month==9 || month==11) {
            return day <= 30;
        } else {
            return day <= 31;
        }
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        if(toYear < 1000) return;
        fromYear = Integer.max(fromYear, 1000);
        while(fromYear <= toYear) {
            String yearStr = String.valueOf(fromYear);
            String monthStr = yearStr.substring(3,4)+yearStr.substring(2,3);
            String dayStr = yearStr.substring(1,2)+yearStr.substring(0,1);
            if(isValidDate(fromYear, Integer.valueOf(monthStr), Integer.valueOf(dayStr))) {
                String middleStr = yearStr.substring(4, yearStr.length());
                if(isPalindrome(middleStr)) {
                    System.out.println(yearStr+"-"+monthStr+"-"+dayStr);
                }
            }
            fromYear++;
        }
    }

    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }
}