package clone_java;

import java.io.Serializable;

public class MyUtil {
    private MyUtil(){
        throw new AssertionError(); //
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) throws Exception{
        
    }
}
