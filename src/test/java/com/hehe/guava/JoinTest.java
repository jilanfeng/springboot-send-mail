package com.hehe.guava;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author 刘伟锋
 * @date 2021/12/28
 **/

public class JoinTest {

    private final static List<String> languageList = Arrays.asList("JAVA","C++","Python");
    private final static List<String> languageValueList = Arrays.asList("JAVA","C++",null);

    @Test
    public void test() {
        String result = Joiner.on("#").join(languageList);
        assertThat(result,equalTo("JAVA#C++#Python"));
    }

    @Test
    public void test1() {
        String result = Joiner.on("#").join(languageValueList);
        assertThat(result,equalTo("JAVA#C++#Python"));
    }

    @Test(expected = NullPointerException.class)
    public void test2() {
        String result = Joiner.on("#").join(languageValueList);
        assertThat(result,equalTo("JAVA#C++#Python"));
    }

    @Test
    public void test3() {
        String result = Joiner.on("#").skipNulls().join(languageValueList);
        assertThat(result,equalTo("JAVA#C++"));
    }
    @Test
    public void test4() {
        String result = Joiner.on("#").useForNull("123").join(languageValueList);
        assertThat(result,equalTo("JAVA#C++#123"));
    }


}
