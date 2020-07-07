package com.example.mvp;

public interface Contract {
    interface IView<P extends IPresent>{
        void logHasEmpty();
        void setPresent(P p);
    }
    interface IPresent{
        void saveLog(String etTitle, String etContent);
    }
}
