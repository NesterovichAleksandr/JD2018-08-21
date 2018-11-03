package by.it.kisielev.jd02_03;

class Util {
    static int random(int from, int to){return  (int/*формат выводачисел*/)(from+ Math.random()*(to-from+1));}

    static int random(int max){return  random(0, max);}

    static void sleep(int millis){
        try {
            Thread.sleep(millis / Dispatcher.KSPEED);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
