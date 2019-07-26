package com.self.entertainment.unclassified.mybatisinterceptor;

/**
 * @author AmazingZ
 * @date 2019/7/23 9:37
 */
public class GetStrImpl implements IGetStr {
    @Override
    public String getStrZero() {
        return "0";
    }

    @Override
    public String getStrOne() {
        return "1";
    }
}
