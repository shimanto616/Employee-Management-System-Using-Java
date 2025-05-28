

interface ExceptionCheckMethods{

    boolean checkName(String name);
    boolean checkSalary(String salary);
    boolean checkPhonenumber(String number);
    boolean checkEmail(String email);
}

public class ValidationMethods implements ExceptionCheckMethods {
    



    // will return true if its a valid name and false if its a invalid name
    @Override
    public final boolean checkName(String name){

        boolean res;

        if(name.matches(".*\\d+.*")|| name==null){//return true if string has number in it else return false
            res = false;
        }
        else {
            if(name.length()== 0){
                res = false;
            }
            else{
                res = true;
            }
        }
        return res;
    }


    // return true if salary is inside the range which is [10000 - 100000]
    public final boolean checkSalary(String salary){
        boolean res= true;

        String contain = "[^0-9]";
        if(!salary.matches(contain)){
            if(salary.length()>=5 && salary.length()<=6){
                res = true;
            }
            else{
                res = false;
            }
        }
        else{
            res = false;
        }

        return res;
    }

    // the number must be 11 digit and initial two digit must be 01 else it is not a valid number
    @Override
    public final boolean checkPhonenumber(String number){

        boolean res;

        if(number.length()!=11){
            res = false;
        }
        else{

            if(number.matches("^[0-9]+")== true){
                if(number.charAt(0)=='0' && number.charAt(1)=='1'){
                    res = true;
                }
                else{
                    res = false;
                }
            }
            else{
                res = false;
            }
            
        }

        return res;

    }


    // our system only take gmail as email address
    //return true for valid input else return false
    @Override
    public final boolean checkEmail(String email){
        boolean res;
        if(email.contains("@gmail.com") || email.contains("@hotmail.com")|| email.contains("@yahoo.com")){
            if(email.contains(" ")){
                res = false;
            }else{
                String flag = "[^a-zA-Z0-9\\s]";

                if(email.matches(flag)){
                    res = false;
                }
                else{
                    res = true;
                }
            }
        }
        else{
            res = false;
        }
        return res;
    }

}
