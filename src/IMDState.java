public interface IMDState {

    void enterState();
    void exitState();

    void turnOn();
    void turnOff();

    void internetOn();
    void internetOff();
    void fileRequest();

    void downloadStart();
    void downloadFinish();
    void downloadError();
    void downloadFix();
    void downloadResume();
    void downloadPause();
    void downloadAbort();
    void downloadCancel();

    void movieOn();
    void movieOff();
    void pauseMovie();
    void resumeMovie();
    void restartMovie();

}
