package by.it.kisielev.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private static Logger instance;

    private Logger(){
    }

    static Logger getInstance(){
        if(instance==null)
            synchronized (Logger.class){/* Для того чтобы не отдался монитор и нее создалась новый "Пример", делаем потоко безопасую формулу*/
            if(instance==null)/*Доп.проверка для тово чтобы не созхдалась новый "Пример"*/
                instance=new Logger();
        }
            return instance;

    }
    synchronized void log (String message){
        String path=System.getProperty("user.dir");
        path=path.concat("/src/by/it/kisielev/jd02_06/log.txt");
        try(PrintWriter out=new PrintWriter(new FileWriter(path, true))){
            out.println(message);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
