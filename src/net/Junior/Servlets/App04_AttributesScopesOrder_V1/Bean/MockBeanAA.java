package net.Junior.Servlets.App04_AttributesScopesOrder_V1.Bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr_Faton on 18.03.2015.
 */
public class MockBeanAA {
    private String str;
    private String[] arrayStr;
    private List<Integer> list;
    private Map<String, String> map;
    private MockBeanBB mockBeanBB;

    public MockBeanAA() {
        this.str = "Hello from BeanAAAAAAAA";
        this.arrayStr = new String[] {"ABC", "DEF", "GHI"};
        this.list = Arrays.asList(123, 456, 789);
        this.map = new HashMap<String, String>() {{put("key--0", "value--0");}};
        mockBeanBB = new MockBeanBB();
    }

    public String getStr() {
        return str;
    }

    public String[] getArrayStr() {
        return arrayStr;
    }

    public List<Integer> getList() {
        return list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public MockBeanBB getMockBeanBB() {
        return mockBeanBB;
    }
}
