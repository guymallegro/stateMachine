public class Context {

    boolean isOn = false;
    int userPoints = 0;

    IMDState internetCurrentState;
    IMDState downloadCurrentState;
    IMDState movieCurrentState;
    IMDState userCurrentState;

    private IMDState internetOn;
    private IMDState internetOff;

    private IMDState waitingForDownload;
    private IMDState checkingDisk;
    private IMDState downloading;
    private IMDState fixingDownload;
    private IMDState waitingForInternet;


    public Context() {
        internetOn = new InternetOff(this);
        internetOff = new InternetOn(this);

        waitingForDownload = new WaitingForDownload(this);
        checkingDisk = new CheckingDisk(this);
        downloading = new Downloading(this);
        fixingDownload = new FixingDownload(this);
        waitingForDownload = new WaitingForInternet(this);
    }


}
