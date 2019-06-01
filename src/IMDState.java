public interface IMDState {

    void enterState();
    void exitState();

    void internetOn();
    void internetOff();

    void fileRequest();
    void downloadFinish();
    void downloadAbort();
    void downloadError();
    void downloadFixed();
    void downloadDelete();

    void movieOn();
    void movieOff();
    void pauseMovie();
    void resumeMovie();
    void restartMovie();


}
