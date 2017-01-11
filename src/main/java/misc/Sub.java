package misc;

import lombok.NonNull;

/**
 * Created by harish.sharma on 2/12/16.
 */
public class Sub extends Super {
    public Sub(@NonNull  Integer a){

        super(a);
        System.out.println(a);
    }

    public static void main(String[] arf){
        Sub s  = new Sub(null);
    }
}
