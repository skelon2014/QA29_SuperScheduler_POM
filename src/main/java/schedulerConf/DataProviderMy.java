package schedulerConf;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderMy {
    @DataProvider
    public Iterator <Object []> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"skelon@bk.ru","Qwerty$4"});
        list.add(new Object[]{"skilon@bk.ru","Qwerty$4"});
        return list.iterator();
    }
}
