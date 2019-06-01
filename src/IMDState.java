public interface IMDState {

    void enterState();
    void exitState();

    void turnOn();
    void turnOff();

    void internetOn();
    void internetOff();

    void fileRequest();
    void downloadFinish();
    void downloadAborted();
    void downloadError();
    void errorFixed();
    void downloadDelete();

    void movieOn();
    void movieOff();
    void holdMovie();
    void resume();
    void restartMovie();


}
