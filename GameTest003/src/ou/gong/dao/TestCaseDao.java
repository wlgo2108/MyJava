package ou.gong.dao;

import ou.gong.models.TestCase;

import java.util.List;
import java.util.ArrayList ;

/**
 * Created by wlgo2108 on 2017/3/8.
 */
public class TestCaseDao {

    private TestCase tc ;


    /**
     * 从excel表中获取游戏用例
     * @return
     */

    public List<TestCase> getTestCaseByExcel(int game_id) {
        List<TestCase> tList = new ArrayList<TestCase>() ;

        return tList ;
    }

    /***
     * 从数据库中获取游戏用例
     * @return
     */
    public List<TestCase> getTestCaseByDB() {
        List<TestCase> tList = new ArrayList<TestCase>() ;

        return tList ;
    }


}
