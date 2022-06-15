package com.exam.exam1;

public class ResultData<T1, T2> {
    private String resultCode;
    private String msg;
    private T1 data1;
    private T2 data2;

    public ResultData(String resultCode, String msg, T1 data1, T2 data2) {
        this.resultCode = resultCode;
        this.msg = msg;
        this.data1 = data1;
        this.data2 = data2;
    }

    public T1 d1() {
        return data1;
    }

    public T2 d2() {
        return data2;
    }
}
